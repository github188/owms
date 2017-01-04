package com.ecaray.owms.services.api;

import com.ecaray.owms.commons.Result;
import com.ecaray.owms.dao.mapper.orders.WorkOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * com.ecaray.owms.services.api
 * Author ：zhxy
 * 2016/11/23 17:08
 * 说明：TODO
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class OrderFlowService {
    @Autowired
    WorkOrderMapper workOrderMapper;


    /**
     * Author ：zhxy
     * 说明：提交工单
     * 1.新增并提交工单
     */
    public Result dispatchWorkOrder(String orderId, String username,String realname) {
        workOrderMapper.dispatchOrderById(orderId,username,realname,System.currentTimeMillis()+"");
        return Result.success();
    }

    public Result completeWorkOrder(String orderId) {
        workOrderMapper.setOrderCompletion(orderId);
        //发送邮件 TODO 新建线程，支线任务不能影响主线任务的运行

        return Result.success();
    }
}
