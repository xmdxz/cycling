package com.cycling.service.impl;

import com.cycling.dao.TopicDao;
import com.cycling.pojo.Topic;
import com.cycling.service.TopicService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: TopicServiceImpl
 * @Author: RainGoal
 * @Description: TODO
 * @Date: 2021/11/18 8:50 下午
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Override
    public List<Topic> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return topicDao.findAll();
    }

    @Override
    public List<Topic> findByTopicName(String topicName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return topicDao.findByTopicName(topicName);
    }
}
