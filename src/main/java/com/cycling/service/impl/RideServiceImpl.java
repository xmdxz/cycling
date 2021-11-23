package com.cycling.service.impl;

import com.cycling.dao.RideDao;
import com.cycling.pojo.Ride;
import com.cycling.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    RideDao rideDao;

    @Override
    public Ride selectRideById(Integer id) {
        return rideDao.selectRideById(id);
    }

    @Override
    public int insertRide(Ride ride) {
        int i = rideDao.insertRide(ride);
        return i;
    }

    @Override
    public int deleteRideById(Integer id) {
        int i = rideDao.deleteRideById(id);
        return i;
    }

    @Override
    public int deleteRideByUserId(Integer userId) {
        int i = rideDao.deleteRideByUserId(userId);
        return i;
    }

    @Override
    public ArrayList<Ride> selectRideByUserId(Integer userId) {
        ArrayList<Ride> rides;
        rides = rideDao.selectRideByUserId(1);
        return rides;
    }
}
