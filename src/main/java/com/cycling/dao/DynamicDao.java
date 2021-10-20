package com.cycling.dao;

import com.cycling.pojo.Dynamic;

/**
 * @ClassName: DynamicDao
 * @Author: RainGoal
 * @Description: TODO
 * @Date: 2021/10/20 4:26 下午
 */

public interface DynamicDao {
    /**
     * 插入动态
     * @author RainGoal
     * @param dynamic
     * @return: int
     */
    int addDynamic(Dynamic dynamic);

    /**
     * 删除动态
     * @author RainGoal
     * @param id
     * @return: int
     */
    int deleteDynamic(Integer id);
}
