package com.cycling.controller;

import com.cycling.pojo.Ride;
import com.cycling.service.RideService;
import com.cycling.utils.ResponseResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Log4j2
@RequestMapping("/ride")
public class RideController {

    @Autowired
    RideService rideService;

    @GetMapping("/prepare")
    public ResponseResult prepareRide() {
        ArrayList<Ride> rides = rideService.selectRideByUserId(1);
        System.out.println(rides);

        ResponseResult result = ResponseResult.ok(rides);
        return result;
    }

}
