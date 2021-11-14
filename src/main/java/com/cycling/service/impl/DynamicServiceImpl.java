package com.cycling.service.impl;

import com.cycling.dao.DynamicDao;
import com.cycling.pojo.Dynamic;
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

    @Override
    public ResponseResult addDynamic(Dynamic dynamic, String topic, String... imgName) {
        int i = dynamicDao.addDynamic(dynamic);
        if (i != 0) {
            
        }
        return null;
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
