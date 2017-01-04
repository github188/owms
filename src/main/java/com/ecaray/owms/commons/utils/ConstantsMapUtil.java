package com.ecaray.owms.commons.utils;

import com.ecaray.owms.commons.Constants;
import com.ecaray.owms.dao.mapper.orders.OrderConstantMapper;
import com.ecaray.owms.dao.mapper.sys.BaseUserMapper;
import com.ecaray.owms.dao.mapper.sys.RegionMapper;
import com.ecaray.owms.dao.mapper.sys.ResourceMapper;
import com.ecaray.owms.entity.Vo.OrderConstantsVo;
import com.ecaray.owms.entity.sys.Area;
import com.ecaray.owms.entity.sys.BaseUser;
import com.ecaray.owms.entity.sys.City;
import com.ecaray.owms.entity.sys.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.ecaray.owms.commons
 * Author ：zhxy
 * 2016/12/1 22:00
 * 说明：可以放入redis
 */
@SuppressWarnings("ALL")
@Component
public class ConstantsMapUtil {

    public static Map<String,Object> constantsCache = new HashMap();

    public static Map<String, Object> initConstants(RegionMapper regionMapper,
                                                    OrderConstantMapper orderConstantMapper,
                                                    BaseUserMapper baseUserMapper ){
        //将订单状态常量放入 后面需要统一改成改成redis
        Map<String,String> mapConstants = convertConstantsMap(orderConstantMapper.selectAllOrderConstants());
        constantsCache.put(Constants.CONSTANTS_ORDERSTATUS,mapConstants);
        constantsCache.put(Constants.CONSTANTS_PROVINCE,convertRegionMap(regionMapper.selectProvinceList()));
        constantsCache.put(Constants.CONSTANTS_CITY,convertRegionMap(regionMapper.selectCityList()));
        constantsCache.put(Constants.CONSTANTS_AREA,convertRegionMap(regionMapper.selectAreaList()));
        constantsCache.put(Constants.CONSTANTS_ORDER_USER,convertUserMap(baseUserMapper.selectWorkOrderUsers()));
        return constantsCache;
    }

    private static Object convertUserMap(List<BaseUser> baseUsers) {
        Map<String ,String> map = new HashMap<String, String>();
        for (BaseUser baseUser :baseUsers){
            if(baseUser.getId()!=null&&!"".equals(baseUser.getId())){
                map.put(baseUser.getId()+"",baseUser.getRealname());
            }
        }
        return map;
    }

    public static Map<String,String> convertConstantsMap(List<OrderConstantsVo> olst){
        Map<String,String> map =new HashMap();
        for(OrderConstantsVo ocv :olst){
            map.put(ocv.getId(),ocv.getValue());
        }
        return map;
    }

    public static Map<String ,String> convertRegionMap(List objList){
        Map<String,String> map = new HashMap<String, String>();
        for(Object object :objList){
            if(object instanceof Province){
                map.put(((Province) object).getProvinceId()+"",((Province) object).getName());
            }else if(object instanceof City){
                map.put(((City) object).getCityId()+"",((City) object).getName());
            }else if(object instanceof Area){
                map.put(((Area) object).getAreaId()+"",((Area) object).getName());
            }
        }
        return map;
    }

    public static void addUserCache(String userId,BaseUser baseUser){
        if(baseUser.getRealname()==null || "".equals(baseUser.getRealname())) return ;
        ((Map)constantsCache.get(Constants.CONSTANTS_ORDER_USER)).put(userId,baseUser.getRealname());
    }
}
