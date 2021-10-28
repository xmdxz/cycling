package com.cycling.dao;

import com.cycling.pojo.Dynamic;
import org.apache.ibatis.annotations.Param;

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
     *
     * @param dynamic
     * @author RainGoal
     * @return: int
     */
    int addDynamic(Dynamic dynamic);

    /**
     * 删除动态
     *
     * @param id
     * @author RainGoal
     * @return: int
     */
    int deleteDynamic(@Param("id") Integer id);

    /**
     * 根据用户查询动态
     *
     * @param username
     * @author RainGoal
     * @return: java.util.List<com.cycling.pojo.Dynamic>
     */
    List<Dynamic> findDynamicByUser(@Param("id") String id, @Param("page") int page, @Param("num") int num);

    /**
     * 根据账户获取关注的人的动态
     *
     * @param username
     * @param page
     * @param num
     * @author RainGoal
     * @return: java.util.List<com.cycling.pojo.Dynamic>
     */
    List<Dynamic> findDynamicByAttention(String username, int page, int num);

    /**
     * 根据地区获取推荐的动态
     *
     * @param area
     * @param page
     * @param num
     * @author RainGoal
     * @return: java.util.List<com.cycling.pojo.Dynamic>
     */
    List<Dynamic> findDynamicByArea(@Param("area") String area, @Param("page") int page, @Param("num") int num);

    /**
     * 获取推荐的动态
     *
     * @param page
     * @param num
     * @author RainGoal
     * @return: java.util.List<com.cycling.pojo.Dynamic>
     */
    List<Dynamic> findDynamicRecommend(int page, int num);


}
