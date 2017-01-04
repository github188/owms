package com.ecaray.owms.controller;

import com.ecaray.owms.commons.Result;
import com.ecaray.owms.entity.Vo.*;
import com.ecaray.owms.entity.orders.WorkOrder;
import com.ecaray.owms.services.api.WorkOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * com.ecaray.owms.controller
 * Author ：zhxy
 * 2016/11/21 15:34
 * 说明：工单
 */

@RequestMapping(value="workorder")
@Controller
public class WorkOrderController {
    public static Logger logger  = LoggerFactory.getLogger(WorkOrder.class);
    @Autowired
    WorkOrderService workOrderService;
    /**
     * Author ：zhxy
     * 说明：新增工单
     */
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public @ResponseBody Result addWorkOrder(@RequestBody WorkOrder workOrder){
        logger.info("新增工单 :"+workOrder.toString());
        return workOrderService.addWorkOrder(workOrder);
    }

    /**
     * Author ：zhxy
     * 说明：添加说明
     */
    @RequestMapping(value = "/comments" ,method = RequestMethod.POST)
    public @ResponseBody Result addWorkOrderComment(@RequestBody  OrderDetailVo orderDetailVo){
        logger.info("工单添加说明:"+orderDetailVo.toString());
        return workOrderService.addWorkOrderDetail(orderDetailVo.getOperUser(),
                orderDetailVo.getComment(),orderDetailVo.getOperTitle(),orderDetailVo.getOrderId(),0);
    }

    /**
     * Author ：zhxy
     * 说明：更新工单信息
     */
    @RequestMapping(value = "/update" ,method = RequestMethod.PUT)
    public @ResponseBody  Result updateWorkOrder(WorkOrder workOrder){
       return  workOrderService.updateWorkOrder(workOrder);
    }

    /**
     * Author ：zhxy
     * 说明：获取当前用户的
     */
//    @RequestMapping("/list")
    public @ResponseBody Object getWorkOrderList(HttpServletRequest request,
                                   @ModelAttribute("orderQueryVo") OrderQueryVo orderQueryVo,
                                   @RequestParam("pageNum")int pageNum,
                                   @RequestParam("pageSize") int pageSize) {
        return workOrderService.getAllOrderList(request,orderQueryVo,pageNum,pageSize);
    }
    /**
     * Author ：zhxy
     * 说明：获取当前用户的列表
     */
    @RequestMapping("list")
    public @ResponseBody Object getCurUserList(FilterQueryVo filterQueryVo){
        return workOrderService.getCurUserList(filterQueryVo);

    }

    /**
     * Author ：zhxy
     * 说明：已经完成的订单
     */
    @RequestMapping("/list/complete")
    public @ResponseBody Object getCompleteWorkOrderList()
    {
        return workOrderService.selectFinishOrders();
    }

    @RequestMapping("/{orderid}/detail")
    public @ResponseBody Object getWorkOrderDetail(@PathVariable String orderid){
       return  workOrderService.selectDetailByOrderId(orderid);
    }
    @RequestMapping(value ="/{orderid}/delete")
    public @ResponseBody Result deleteWorkOrderById(@PathVariable String orderid){
      return  workOrderService.deleteWorkOrderById(orderid);
    }

    /**
     * Author ：zhxy
     * 说明：派单
     */
    @RequestMapping(value="/dispatch" ,method = RequestMethod.PUT)
    public @ResponseBody Result dispatchWorkOrder(@RequestBody OrderDetailVo orderDetailVo){
        logger.info("派单:"+orderDetailVo.toString());
        return  workOrderService.dispatchWorkOrder(orderDetailVo.getOperTitle(),orderDetailVo.getOrderId(),
                orderDetailVo.getReceiveUser(),orderDetailVo.getComment(),orderDetailVo.getOperUser());
    }

    /**
     * Author ：zhxy
     * 说明：订单状态
     */
    @RequestMapping(value ="/{orderid}/{userId}/orderstatus")
    public @ResponseBody OrderQueryVo getWorkOrderStatus(@PathVariable  String orderid,
                                                         @PathVariable String userId){
        return workOrderService.getWorkOrderStatus(orderid,userId);

    }

    /**
     * Author ：zhxy
     * 说明：完成订单
     */
    @RequestMapping(value = "/complete" ,method = RequestMethod.PUT)
    public @ResponseBody Result completeWorkOrder( @RequestBody CompleteVo completeVo){
        logger.info("完成工单:"+completeVo.getOrderId());
        return workOrderService.completeWorkOrder(completeVo);
    }
    /**
     * Author ：zhxy
     * 说明：需求判定
     */
    @RequestMapping(value = "/demandJudge" ,method = RequestMethod.PUT)
    public @ResponseBody Result demandJudge( @RequestBody DemandJudgeVo demandJudgeVo){
        return workOrderService.demandJudge(demandJudgeVo);
    }


}
