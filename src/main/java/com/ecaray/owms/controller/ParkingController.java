package com.ecaray.owms.controller;

import com.ecaray.owms.entity.sys.ProjParking;
import com.ecaray.owms.services.api.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * com.ecaray.owms.controller
 * Author ：zhxy
 * 2016/11/28 0:19
 * 说明：TODO
 */
@RequestMapping("parking")
@Controller
public class ParkingController {
    @Autowired
    private ParkingService parkingService;
    @RequestMapping(value="/list")
    public @ResponseBody
    List<ProjParking> selectParkingList(String province, String city, String area, String keywords){
        return parkingService.selectParkingList(province,city,area,keywords);
    }

    @RequestMapping(value="/{parkId}/message")
    public @ResponseBody ProjParking getParkMessage(@PathVariable  Long parkId){
        return parkingService.getParkingMessage(parkId);
    }

    @RequestMapping(value="/test")
    public @ResponseBody Object getTestMessage(String parkId){
       return  parkingService.selectTestError(parkId);
    }
}
