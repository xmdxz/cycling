package com.cycling.controller;

import com.cycling.dto.Student;
import com.cycling.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName TestController
 * @Description TODO
 * @Date 2021/9/22 20:20
 * @Version 1.0
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public String getTestMessage() {
        return "test";
    }

    @RequestMapping("/getStudent")
    public List<Student> getStudent() {
        return testService.getList();
    }

}
