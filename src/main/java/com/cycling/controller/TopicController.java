package com.cycling.controller;

import com.cycling.pojo.Topic;
import com.cycling.service.TopicService;
import com.cycling.utils.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: TopicController
 * @Author: RainGoal
 * @Description: TODO
 * @Date: 2021/11/19 8:08 上午
 */
@RestController
@RequestMapping("/topic")
@Api(tags = "话题相关模块")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("findAll")
    public ResponseResult findAll(Integer pageNum, Integer pageSize) {
        List<Topic> all = topicService.findAll(pageNum, pageSize);
        return ResponseResult.ok(all);
    }

    @GetMapping("findByTopicName")
    public ResponseResult findByTopicName(String topicName, Integer pageNum, Integer pageSize) {
        List<Topic> topics = topicService.findByTopicName(topicName, pageNum, pageSize);
        return ResponseResult.ok(topics);
    }
    
}
