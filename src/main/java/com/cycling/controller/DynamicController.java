package com.cycling.controller;

import com.cycling.pojo.dto.AddDynamicPojo;
import com.cycling.pojo.dto.DynamicShow;
import com.cycling.service.DynamicService;
import com.cycling.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @ApiOperation("发布动态")
    public ResponseResult publicDynamic(AddDynamicPojo addDynamicPojo) {
        log.warn(addDynamicPojo.toString());
        return dynamicService.addDynamic(addDynamicPojo);
    }

    @PostMapping("getDynamicRecommend")
    @ApiOperation("获取推荐获取动态")
    public ResponseResult getDynamicByRecommend() {
        return dynamicService.findDynamicRecommend();
    }

    @PostMapping("getDynamicByAttention")
    @ApiOperation("获取关注人的动态")
    public ResponseResult getDynamicByAttention() {
        List<DynamicShow> dynamicList = dynamicService.findDynamicByAttention();
        return ResponseResult.ok(dynamicList);
    }
}
