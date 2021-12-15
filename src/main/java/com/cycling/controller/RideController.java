package com.cycling.controller;

import com.cycling.service.RideService;
import com.cycling.utils.ResponseResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/ride")
public class RideController {

    @Autowired
    RideService rideService;

    /**
     * 传入选择的路书地图信息到prepare界面
     *
     * @param mapId
     * @return
     */
    @GetMapping("/route")
    public ResponseResult prepareRide(Integer mapId) {
        double[][] allRoute = {{112.590189, 37.42093},
                {112.589862, 37.420964},
                {112.58984, 37.421033},
                {112.590151, 37.423205},
                {112.590211, 37.423431},
                {112.591139, 37.429996},
                {112.588569, 37.43115},
                {112.587979, 37.426368}};
        ResponseResult result = ResponseResult.ok(allRoute);
        return result;
    }

    @PostMapping("/finish")
    public ResponseResult finishRide() {

        return ResponseResult.ok("");
    }

}
