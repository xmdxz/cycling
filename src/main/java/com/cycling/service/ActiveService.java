package com.cycling.service;

import com.cycling.pojo.Active;
import com.cycling.utils.ResponseResult;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2021/10/28 20:20
 */
public interface ActiveService {

    /**
     * 插入
     * @param active
     * @return int
     * @author Shubo_Yang
     * @date 2021/10/28 20:23
     */
    ResponseResult insert(Active active);

    /**
     * 获取全部
     * @param
     * @return java.util.List<com.cycling.pojo.Active>
     * @author Shubo_Yang
     * @date 2021/10/28 20:26
     */
    ResponseResult getAllActive();

    /**
     * 分页获取
     * @param pageNo //页码
     * @return com.github.pagehelper.PageInfo<com.cycling.pojo.Active>
     * @author Shubo_Yang
     * @date 2021/10/28 20:27
     */
    ResponseResult getAllActiveByPage(int pageNo);
}
