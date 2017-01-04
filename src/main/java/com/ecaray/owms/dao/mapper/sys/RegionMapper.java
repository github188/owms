package com.ecaray.owms.dao.mapper.sys;

import com.ecaray.owms.entity.Vo.RegionVo;
import com.ecaray.owms.entity.sys.Area;
import com.ecaray.owms.entity.sys.City;
import com.ecaray.owms.entity.sys.Province;

import java.util.List;

/**
 * com.ecaray.owms.dao.mapper.sys
 * Author ：zhxy
 * 2016/12/5 15:18
 * 说明：地区
 */
public interface RegionMapper {
    public  RegionVo getRegion(RegionVo regionVo);
    List<Province> selectProvinceList();

    List<City>  selectCityList();

    List<Area> selectAreaList();
}
