package com.cycling.dao;

import com.cycling.pojo.Dynamic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: DynamicDao
 * @Author: RainGoal
 * @Description: TODO
 * @Date: 2021/10/20 4:26 下午
 */
@Repository
public interface DynamicDao {
    /**
     * 插入动态
     *
     * @param dynamic
     * @author RainGoal
     * @return: int
     */
    Long addDynamic(Dynamic dynamic);
    
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
    List<Dynamic> findDynamicByUser(@Param("id") String id);

    /**
     * 根据账户id获取关注的人的动态
     *
     * @param username
     * @author RainGoal
     * @return: java.util.List<com.cycling.pojo.Dynamic>
     */
    List<Dynamic> findDynamicByAttention(@Param("id") String id);

    /**
     * 根据地区获取推荐的动态
     *
     * @param area
     * @param page
     * @param num
     * @author RainGoal
     * @return: java.util.List<com.cycling.pojo.Dynamic>
     */
    List<Dynamic> findDynamicByArea(@Param("area") String area);

    /**
     * 获取推荐的动态
     *
     * @author RainGoal
     * @return: java.util.List<com.cycling.pojo.Dynamic>
     */
    List<Dynamic> findDynamicRecommend();


}
