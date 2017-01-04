package com.ecaray.owms.dao.mapper.sys;

import com.ecaray.owms.entity.sys.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityMapper {
    List<City> selectCityByProvinceId(@Param("province_id")String id);
}