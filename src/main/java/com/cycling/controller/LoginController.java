package com.cycling.controller;


import com.cycling.pojo.User;
import com.cycling.service.UserService;
import com.cycling.utils.JWTUtils;
import com.cycling.utils.RedisUtil;
import com.cycling.utils.ResponseResult;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @Description: loginController
 * @Author: qyz
 * @date: 2021/10/20 13:07
 * @Version: V1.0
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public ResponseResult login(String phone, String password, HttpServletResponse response) {

        User user=userService.findByPhone(phone);
        if(user!=null && !(user.getPassword().equals(new Md5Hash(password,user.getSalt(),1024).toHex())))
        {
               return ResponseResult.error("密码错误", HttpStatus.FORBIDDEN.value());
        }
        else if(user==null) {
            return ResponseResult.error("该手机未注册",HttpStatus.FORBIDDEN.value());
        }
        //当前登录时间
        long currentTimeMillis = System.currentTimeMillis();
        //生成token
        Map<String,String> map=new HashMap<>();
        map.put("username",phone);
        String token= JWTUtils.getToken(map,currentTimeMillis);
        //把该账号登陆时间以用户名作为key存入redis 有效时间为30分钟用来刷新token和踢出用户
        redisUtil.set(phone,currentTimeMillis,JWTUtils.RefreshToken_EXPIRE_TIME);
        //把token放在响应header 用于用户之后访问携带
        response.setHeader("Authorization",token);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        return ResponseResult.ok();
    }


}