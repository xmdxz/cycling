package com.cycling.controller;

import com.cycling.pojo.UserInfo;
import com.cycling.pojo.dto.OwnInfo;
import com.cycling.pojo.dto.RelatedCount;
import com.cycling.service.UserService;
import com.cycling.utils.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseResult getUserInfo() {
        UserInfo userInfo = userService.selectUserInfoById();
        return isEmpty(userInfo);
    }

    @GetMapping(value = "/getOwnInfo")
    public ResponseResult getOwnInfo() {
        OwnInfo ownInfo = userService.getMyInfo();
        return isEmpty(ownInfo);
    }

    @GetMapping(value = "/getRelatedCount")
    public ResponseResult getRelatedCount() {
        final RelatedCount relatedCount = userService.getRelatedCount();
        return isEmpty(relatedCount);
    }

    @PutMapping(value = "/updateInfo")
    public ResponseResult updateInfo(UserInfo userInfo) {
        return isEmpty(isUpdate(userService.updateInfo(userInfo)));
    }

    @GetMapping(value = "/getFansAndSimple")
    public ResponseResult getFansAndSimple() {
        return isEmpty(userService.getFansAndSimpleUserInfo());
    }

    @GetMapping(value = "/getFocusedAndSimple")
    public ResponseResult getFocusedAndSimple() {
        return isEmpty(userService.getFocusedAndSimpleUserInfo());
    }

    private <T> ResponseResult isEmpty(T parameter) {
        if (ObjectUtils.isEmpty(parameter)) {
            return ResponseResult.error("获取用户信息失败,请重试", HttpStatus.NOT_FOUND.value());
        }
        return ResponseResult.ok(parameter);
    }

    private ResponseResult isUpdate(int parameter) {
        if (parameter <= 0) {
            return ResponseResult.error("更新失败,服务器错误", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return ResponseResult.ok(parameter);
    }
}
