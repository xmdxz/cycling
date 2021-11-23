package com.cycling.service.impl;

import com.cycling.dao.DynamicDao;
import com.cycling.dao.DynamicImageDao;
import com.cycling.dao.DynamicTopicDao;
import com.cycling.pojo.Dynamic;
import com.cycling.pojo.DynamicImage;
import com.cycling.pojo.DynamicTopic;
import com.cycling.service.DynamicService;
import com.cycling.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: DynamicServiceImpl
 * @Author: RainGoal
 * @Description: TODO
 * @Date: 2021/10/29 5:13 下午
 */
@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicDao dynamicDao;

    @Autowired
    private DynamicTopicDao dynamicTopicDao;

    @Autowired
    private DynamicImageDao dynamicImageDao;

    @Override
    public ResponseResult addDynamic(Dynamic dynamic, Long[] topicId, String[] imgName) {
        Long i = dynamicDao.addDynamic(dynamic);
        if (i != 0) {
            DynamicTopic dynamicTopic = new DynamicTopic();
            dynamicTopic.setDynamicId(i);
            //遍历动态所有包含的话题id
            for (Long topic : topicId) {
                dynamicTopic.setTopicId(topic);
                dynamicTopicDao.addDynamicTopic(dynamicTopic);
            }

            DynamicImage dynamicImage = new DynamicImage();
            dynamicImage.setDynamicId(i);
            for (String imgUrl : imgName) {
                dynamicImage.setImageUrl(imgUrl);
                dynamicImageDao.insertImage(dynamicImage);
            }
            return ResponseResult.ok();
        }
        return ResponseResult.error("发布出错");
    }

    @Override
    public ResponseResult findDynamicByUser(String id) {
        List<Dynamic> dynamicByUser = dynamicDao.findDynamicByUser(id);
        return ResponseResult.ok(dynamicByUser);
    }

    @Override
    public ResponseResult findDynamicByArea(String area) {
        List<Dynamic> dynamicByArea = dynamicDao.findDynamicByArea(area);
        return ResponseResult.ok(dynamicByArea);
    }

    @Override
    public ResponseResult findDynamicRecommend() {
        List<Dynamic> dynamicRecommend = dynamicDao.findDynamicRecommend();
        return ResponseResult.ok(dynamicRecommend);
    }
}
