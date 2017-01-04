package com.ecaray.owms.dao.mapper.sys;

import com.ecaray.owms.entity.sys.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper {

    List<Area> selectAreaByCityId(@Param("city_id") String cityId);
}