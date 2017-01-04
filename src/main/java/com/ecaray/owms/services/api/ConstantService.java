package com.ecaray.owms.services.api;

import com.ecaray.owms.commons.Constants;
import com.ecaray.owms.commons.Result;
import com.ecaray.owms.commons.utils.ConstantsMapUtil;
import com.ecaray.owms.dao.mapper.orders.OrderConstantMapper;
import com.ecaray.owms.dao.mapper.sys.AreaMapper;
import com.ecaray.owms.dao.mapper.sys.CityMapper;
import com.ecaray.owms.dao.mapper.sys.ProvinceMapper;
import com.ecaray.owms.entity.Vo.OrderConstantsVo;
import com.ecaray.owms.entity.orders.OrderLevel;
import com.ecaray.owms.entity.orders.OrderOperStatus;
import com.ecaray.owms.entity.orders.OrderType;
import com.ecaray.owms.entity.orders.ProblemType;
import com.ecaray.owms.entity.sys.Area;
import com.ecaray.owms.entity.sys.City;
import com.ecaray.owms.entity.sys.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * com.ecaray.owms.services.api
 * Author ：zhxy
 * 2016/11/22 20:41
 * 说明：TODO
 */
@SuppressWarnings("ALL")
@Service
public class ConstantService {
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private OrderConstantMapper orderConstantMapper;

    public List<Province> getProvinces() {
        return  provinceMapper.selectProvinceList();
    }

    public List<City> getCityByProvinceId(String pid) {
      return   cityMapper.selectCityByProvinceId(pid);
    }

    public List<Area> getAreaByCityId(String cityId) {
        return areaMapper.selectAreaByCityId(cityId);
    }

    public List<ProblemType> selectProblemTypes() {
        return orderConstantMapper.selectProblemTypes();
    }

    public List<OrderType> selectOrderTypes() {
        return orderConstantMapper.selectOrderTypes();
    }

    public List<OrderLevel> selectOrderLevels() {
        return orderConstantMapper.selectOrderLevels();
    }

    public List<OrderOperStatus> selectOrderOperStatus() {
            return orderConstantMapper.selectOrderOperStatus();
    }

    public Result addProblemTypes(OrderConstantsVo orderConstantsVo) {
        //获取最大的id;
        String maxid = orderConstantMapper.selectMaxIdByType("problemtype");
        orderConstantsVo.setId(maxid);
        orderConstantMapper.addProblemTypes(orderConstantsVo);
        //新增问题类型放入缓存中
        ((Map)ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_ORDERSTATUS)).put(maxid,orderConstantsVo.getValue());
        return Result.success();
    }
}
