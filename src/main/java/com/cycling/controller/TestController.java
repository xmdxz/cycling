package com.cycling.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public String test(String param){
        Logger logger = LogManager.getLogger(TestController.class);
        logger.info("success");
        return "success";
    }

}
