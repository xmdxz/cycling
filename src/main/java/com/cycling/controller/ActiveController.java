package com.cycling.controller;

import com.cycling.service.ActiveService;
import com.cycling.utils.ResponseResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2021/11/10 20:51
 */
@RestController
@Log4j2
@RequestMapping("/active")
public class ActiveController {
    @Resource
    private ActiveService activeService;

    @RequestMapping("/getallactive")
    public ResponseResult getall(){
        return ResponseResult.ok(activeService.getAllActive());
    }
}
