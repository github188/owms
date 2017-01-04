package com.ecaray.owms.controller;

import com.ecaray.owms.commons.Constants;
import com.ecaray.owms.commons.Result;
import com.ecaray.owms.commons.utils.ConstantsMapUtil;
import com.ecaray.owms.dao.mapper.orders.OrderConstantMapper;
import com.ecaray.owms.entity.Vo.OrderConstantsVo;
import com.ecaray.owms.entity.orders.OrderLevel;
import com.ecaray.owms.entity.orders.OrderOperStatus;
import com.ecaray.owms.entity.orders.OrderType;
import com.ecaray.owms.entity.orders.ProblemType;
import com.ecaray.owms.entity.sys.Area;
import com.ecaray.owms.entity.sys.City;
import com.ecaray.owms.entity.sys.Province;
import com.ecaray.owms.services.api.ConstantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * com.ecaray.owms.controller
 * Author ：zhxy
 * 2016/11/22 19:55
 * 说明：常量信息获取接口
 */

@SuppressWarnings("ALL")
@RequestMapping(value="constants")
@Controller
public class ConstantController {
    @Autowired
    ConstantService constantService;
    @Autowired
    OrderConstantMapper orderConstantMapper;
    /**
     * Author ：zhxy
     * 说明：获取省份列表
     */
    @RequestMapping("/region/provinces")
    public @ResponseBody List<Province> provinceList(){
       return  constantService.getProvinces();
    }
    /**
     * Author ：zhxy
     * 说明：根据省份ID获取市列表
     */
    @RequestMapping("/region/{province_id}/city")
    public @ResponseBody List<City> cityList(@PathVariable("province_id") String id){
        return constantService.getCityByProvinceId(id);
    }
    /**
     * Author ：zhxy
     * 说明：根据city_id 获取区列表
     */
    @RequestMapping("/region/{city_id}/area")
    public @ResponseBody List<Area> areaList(@PathVariable("city_id") String cityId){
        return constantService.getAreaByCityId(cityId);
    }
    /**
     * Author ：zhxy
     * 说明：获取问题类型列表
     */
    @RequestMapping("/problemtypes")
    public @ResponseBody List<ProblemType> problemTypes(){
        return constantService.selectProblemTypes();
    }

    @RequestMapping(value = "/problemtypes",method = RequestMethod.POST)
    public @ResponseBody Result addProblemTypes(@RequestBody OrderConstantsVo orderConstantsVo){
        return constantService.addProblemTypes(orderConstantsVo);
    }
    /**
     * Author ：zhxy
     * 说明：获取工单类型
     */
    @RequestMapping("/ordertypes")
    public @ResponseBody List<OrderType> ordertTypes(){
        return constantService.selectOrderTypes();
    }

    /**
     * Author ：zhxy
     * 说明：订单状态
     */
    @RequestMapping("/orderoperstatus")
    public @ResponseBody List<OrderOperStatus> ordertOperStatus(){
        return constantService.selectOrderOperStatus();
    }

    /**
     * Author ：zhxy
     * 说明：优先级
     */
    @RequestMapping("/orderlevels")
    public @ResponseBody List<OrderLevel> orderLevels(){
        return constantService.selectOrderLevels();
    }

    /**
     * Author ：zhxy
     * 说明：TODO
     */
    @RequestMapping("/all")
    public @ResponseBody Object selectAllConstants(){
        Map<String,String> mapConstants = ConstantsMapUtil.convertConstantsMap(orderConstantMapper.selectAllOrderConstants());
       return mapConstants;
    }


}
