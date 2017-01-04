package com.ecaray.owms.dao.mapper.sys;

import com.ecaray.owms.entity.sys.ProjParking;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjParkingMapper {

    ProjParking selectByPrimaryKey(Long id);

    List<ProjParking> selectByRegionAndKeywords(@Param("province") String province,
                                                @Param("city") String city,
                                                @Param("district") String district,
                                                @Param("keyWords") String keyWords);

    ProjParking selectParkingListById(@Param("id") String id);

    ProjParking selectTestError(String id);
}