package com.cycling.controller;

import com.cycling.pojo.UserInfo;
import com.cycling.pojo.dto.OwnInfo;
import com.cycling.pojo.dto.RelatedCount;
import com.cycling.service.UserService;
import com.cycling.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author xpdxz
 * @ClassName UserController
 * @Description TODO
 * @Date 2021/10/28 12:06
 */

@Api(tags = "用户信息模块")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("获取用户全部信息")
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
    public ResponseResult updateInfo(@RequestBody UserInfo userInfo) {
        System.out.println(userInfo);
        return ResponseResult.ok(userService.updateInfo(userInfo));
    }

    @GetMapping(value = "/getFansAndSimple")
    public ResponseResult getFansAndSimple(Long minId, Integer num) {
        return isEmpty(userService.getFansAndSimpleUserInfo(minId, num));
    }

    @GetMapping(value = "/getFocusedAndSimple")
    public ResponseResult getFocusedAndSimple(Long minId, Integer num) {
        return isEmpty(userService.getFocusedAndSimpleUserInfo(minId, num));
    }

    @PutMapping(value = "/focus")
    public ResponseResult focus(Long focusedUserId) {
        return ResponseResult.ok(userService.focus(focusedUserId));
    }

    @DeleteMapping(value = "/cancelFocused")
    public ResponseResult cancelFocused(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "focusedUserId", required = false) Long focusedUserId) {
        return ResponseResult.ok(userService.cancelFocused(id, focusedUserId));
    }

    private <T> ResponseResult isEmpty(T parameter) {
        if (parameter == null) {
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
