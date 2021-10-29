package com.cycling.dao;

import com.cycling.pojo.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: TopicDao
 * @Author: RainGoal
 * @Description: TODO
 * @Date: 2021/10/29 11:07 上午
 */
@Repository
public interface TopicDao {

    /**
     * 查询所有话题
     *
     * @author RainGoal
     * @return: java.util.List<com.cycling.pojo.Topic>
     */
    List<Topic> findAll();

}
