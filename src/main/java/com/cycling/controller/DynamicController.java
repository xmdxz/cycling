package com.cycling.controller;

import com.cycling.pojo.Dynamic;
import com.cycling.service.DynamicService;
import com.cycling.utils.ResponseResult;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DynamicController
 * @Author: RainGoal
 * @Description: TODO
 * @Date: 2021/10/20 3:45 下午
 */
@RestController
@Log4j2
@RequestMapping("/dynamic")
@Api(tags = "动态相关模块")
public class DynamicController {
    
    @Autowired
    private DynamicService dynamicService;

    @PostMapping("publicDynamic")
    public ResponseResult publicDynamic(Dynamic dynamic, Long[] topicId, String[] imgName) {
        return dynamicService.addDynamic(dynamic, topicId, imgName);
    }
}
