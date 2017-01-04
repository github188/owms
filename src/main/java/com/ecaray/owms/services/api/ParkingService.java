package com.ecaray.owms.services.api;

import com.ecaray.owms.commons.Result;
import com.ecaray.owms.dao.mapper.sys.ProjParkingMapper;
import com.ecaray.owms.entity.sys.ProjParking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.ecaray.owms.services.api
 * Author ：zhxy
 * 2016/11/29 0:22
 * 说明：TODO
 */
@SuppressWarnings("ALL")
@Service
public class ParkingService {
    @Autowired
    private ProjParkingMapper projParkingMapper;
    public List<ProjParking> selectParkingList(String province, String city, String area, String keywords){
        if(keywords!=null&&!"".equals(keywords)) {
            keywords = "%" + keywords + "%";
        }else{
            keywords = null;
        }
      return  projParkingMapper.selectByRegionAndKeywords(province,city,area,keywords);
    }

    public ProjParking getParkingMessage(Long parkId){
        return projParkingMapper.selectByPrimaryKey(parkId);
    };

    public int selectParkingListById(String parkId) {
        ProjParking pro = projParkingMapper.selectParkingListById(parkId);
        if(pro==null||pro.getId()==null){
            return 0;
        }
        return 1;
    }

    public Object selectTestError(String parkId) {
        ProjParking pro = projParkingMapper.selectTestError(parkId);
        return pro;
    }
}
