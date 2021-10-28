package com.cycling.controller;

import com.cycling.pojo.UserInfo;
import com.cycling.pojo.dto.OwnInfo;
import com.cycling.service.UserService;
import com.cycling.utils.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xpdxz
 * @ClassName UserController
 * @Description TODO
 * @Date 2021/10/28 12:06
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/getUserInfo")
    public ResponseResult getUserInfo(){
        UserInfo userInfo = userService.selectUserInfoById();
        if (ObjectUtils.isEmpty(userInfo)){
            return ResponseResult.error("获取用户信息失败,请重试", HttpStatus.NOT_FOUND.value());
        }
        return ResponseResult.ok(userInfo);
    }

    @GetMapping(value = "/getOwnInfo")
    public ResponseResult getOwnInfo(){
        OwnInfo ownInfo = userService.getMyInfo();
        if (ObjectUtils.isEmpty(ownInfo)){
            return ResponseResult.error("获取用户信息失败,请重试", HttpStatus.NOT_FOUND.value());
        }
        return ResponseResult.ok(ownInfo);
    }

}
