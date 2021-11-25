package com.cycling.service;

import com.cycling.pojo.Ride;

import java.util.ArrayList;
import java.util.List;

public interface RideService {

    /**
     * 通过骑行记录id查找记录
     * @param id
     * @return com.cycling.pojo.Ride
     */
    Ride selectRideById(Integer id);

    /**
     * 插入一条骑行记录
     * @param ride
     * @return
     */
    int insertRide(Ride ride);

    /**
     * 删除一条骑行记录
     * @param id
     * @return
     */
    int deleteRideById(Integer id);

    /**
     * 根据userId删除用户的全部骑行记录
     * @param userId
     * @return
     */
    int deleteRideByUserId(Integer userId);

    /**
     * 根据用户userId获取用户所有的骑行记录
     * @param userId
     * @return
     */
    ArrayList<Ride> selectRideByUserId(Integer userId);
}
