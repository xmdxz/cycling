package com.cycling.controller;


import com.cycling.utils.ResponseResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestShiroController {
    @RequestMapping("/")
    public String index()  {
        return "index";
    }

    @PostMapping("/user")
    @RequiresRoles(logical = Logical.OR,value = {"user","admin"})
    @ResponseBody
    public ResponseResult user(){
        return ResponseResult.ok("成功访问admin接口");
    };

    @PostMapping("/admin")
    @RequiresRoles(logical = Logical.OR,value = {"admin"})
    @ResponseBody
    public ResponseResult admin() {
        return ResponseResult.ok("成功访问user接口");
    };

}