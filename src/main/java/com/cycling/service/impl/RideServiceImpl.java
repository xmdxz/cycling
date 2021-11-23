package com.cycling.service.impl;

import com.cycling.dao.RideDao;
import com.cycling.pojo.Ride;
import com.cycling.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    RideDao rideDao;

    @Override
    public Ride selectRideById(Integer id) {
        return rideDao.selectRideById(id);
    }
}
