package com.cycling.dao;

import com.cycling.pojo.Dynamic;

import java.util.List;

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

    /**
     * 根据用户查询动态
     * @author RainGoal
     * @param username
     * @return: java.util.List<com.cycling.pojo.Dynamic>
     */
    List<Dynamic> findDynamicByUser(String username);
}
