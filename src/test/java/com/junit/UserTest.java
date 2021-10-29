package com.junit;

import com.cycling.CyclingSsmApplication;
import com.cycling.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author xpdxz
 * @ClassName UserTest
 * @Description TODO
 * @Date 2021/10/29 16:41
 */


@SpringBootTest(classes = CyclingSsmApplication.class)
class UserTest {

    @Resource
    private UserService userService;

    @Test
    void testFansAndFocused() {
        System.out.println(userService.getFansAndSimpleUserInfo());
    }

}
