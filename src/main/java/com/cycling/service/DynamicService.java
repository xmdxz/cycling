package com.cycling.service;

import com.cycling.pojo.Dynamic;
import com.cycling.utils.ResponseResult;

/**
 * @InterfaceName: DynamicService
 * @Author: RainGoal
 * @Description: TODO
 * @Date: 2021/10/29 4:43 下午
 */

public interface DynamicService {

    ResponseResult addDynamic(Dynamic dynamic, String topic, String... imgName);

    /**
     * 查找用户动态
     *
     * @param id
     * @author RainGoal
     * @return: com.cycling.utils.ResponseResult
     */
    ResponseResult findDynamicByUser(String id);

    /**
     * 根据地区获取动态
     *
     * @param area
     * @author RainGoal
     * @return: com.cycling.utils.ResponseResult
     */
    ResponseResult findDynamicByArea(String area);

    /**
     * 获取推荐动态
     *
     * @author RainGoal
     * @return: com.cycling.utils.ResponseResult
     */
    ResponseResult findDynamicRecommend();
}
