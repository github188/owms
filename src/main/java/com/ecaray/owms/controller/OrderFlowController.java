package com.ecaray.owms.controller;

import com.ecaray.owms.commons.Result;
import com.ecaray.owms.entity.orders.WorkOrder;
import com.ecaray.owms.services.api.OrderFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * com.ecaray.owms.controller
 * Author ：zhxy
 * 2016/11/23 15:08
 * 说明：新增工单
 */

@RequestMapping(value="flow")
@Controller
public class OrderFlowController {
    @Autowired
    OrderFlowService orderFlowService;

    /**
     * Author ：zhxy
     * 说明：指派工单
     */
    @RequestMapping(value ="/{orderId}/{username}/dispatch" ,method = RequestMethod.PUT)
    public @ResponseBody  Result dispatchWorkOrder(@RequestParam(value ="orderId")String orderId,
                                                   @RequestParam("username") String username,
                                                   @RequestParam("realname") String realname){
        if(orderId == null || username == null){
           return Result.failed("工单ID或指定人为空！");
        }
        return orderFlowService.dispatchWorkOrder(orderId,username,realname);
    }

    /**
     * Author ：zhxy
     * 说明：完成工单
     */
    @RequestMapping(value ="/{orderId}/{username}/complete" ,method = RequestMethod.GET)
    public @ResponseBody  Result completeWorkOrder(@RequestParam(value ="orderId")String orderId){
        if(orderId == null){
            return Result.failed("无效工单！");
        }
        return orderFlowService.completeWorkOrder(orderId);
    }
}
