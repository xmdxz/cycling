package com.cycling.dao;

import com.cycling.pojo.Active;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2021/10/28 19:06
 */
public interface ActiveDao {

/**
 *
 * @param active
 * @return int
 * @author Shubo_Yang
 * @date 2021/10/28 20:15
 */
    int insert(@Param(value = "active") Active active);

    /**
     *获取所有已审核活动那
     * @param
     * @return java.util.List<com.cycling.pojo.Active>
     * @author Shubo_Yang
     * @date 2021/10/28 20:20
     */
    List<Active> getAllActive();

    /**
     * 获取未经过审核活动
     * @param
     * @return java.util.List<com.cycling.pojo.Active>
     * @author Shubo_Yang
     * @date 2021/11/10 19:40
     */
    List<Active>getAllActiveWithoutCheck();

}
