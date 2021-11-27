package com.cycling.service.impl;

import com.cycling.dao.DynamicDao;
import com.cycling.dao.DynamicImageDao;
import com.cycling.dao.DynamicTopicDao;
import com.cycling.pojo.Dynamic;
import com.cycling.pojo.DynamicImage;
import com.cycling.pojo.DynamicTopic;
import com.cycling.pojo.dto.AddDynamicPojo;
import com.cycling.service.DynamicService;
import com.cycling.utils.RequestUtil;
import com.cycling.utils.ResponseResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: DynamicServiceImpl
 * @Author: RainGoal
 * @Description: TODO
 * @Date: 2021/10/29 5:13 下午
 */
@Service
@Log4j2
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicDao dynamicDao;

    @Autowired
    private DynamicTopicDao dynamicTopicDao;

    @Autowired
    private DynamicImageDao dynamicImageDao;

    @Override
    public ResponseResult addDynamic(AddDynamicPojo addDynamicPojo) {
        // 将接受到的添加动态实体封装到一个新的实体
        Dynamic dynamic = new Dynamic();
        dynamic.setTitle(addDynamicPojo.getTitle());
        dynamic.setContent(addDynamicPojo.getContent());
        dynamic.setAuthorId(RequestUtil.getUserId());
        dynamic.setTime(new Timestamp(System.currentTimeMillis()));
        dynamic.setPosition(addDynamicPojo.getPosition());
        // 添加动态 获取动态
        Long i = dynamicDao.addDynamic(dynamic);
        log.warn("插入成功的动态id为：{}", dynamic.getId());
        if (i != 0) {
            HashMap<Object, Object> map = new HashMap<>();
            DynamicTopic dynamicTopic = new DynamicTopic();
            dynamicTopic.setDynamicId(dynamic.getId());
            //遍历动态所有包含的话题id
            Long[] topicId = addDynamicPojo.getTopicId();
            for (Long topic : topicId) {
                dynamicTopic.setTopicId(topic);
                dynamicTopicDao.addDynamicTopic(dynamicTopic);
            }

            String[] imgName = addDynamicPojo.getImgName();
            DynamicImage dynamicImage = new DynamicImage();
            dynamicImage.setDynamicId(dynamic.getId());
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
