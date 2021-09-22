package com.cycling.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xpdxz
 * @ClassName TestController
 * @Description TODO
 * @Date 2021/9/22 20:20
 * @Version 1.0
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String getTestMessage(){
        return "test";
    }

}
