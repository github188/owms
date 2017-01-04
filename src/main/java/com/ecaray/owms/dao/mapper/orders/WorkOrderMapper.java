package com.ecaray.owms.dao.mapper.orders;

import com.ecaray.owms.entity.Vo.FilterQueryVo;
import com.ecaray.owms.entity.Vo.OrderQueryVo;
import com.ecaray.owms.entity.orders.WorkOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface WorkOrderMapper {

    int insertSelective(WorkOrder record);

    int  updateById(WorkOrder workOrder);

    Object selectAddPersonListByFilter(OrderQueryVo orderQueryVo);

    Object selectDealerListByFilter(OrderQueryVo orderQueryVo);

    Object selectViewListByFilter(OrderQueryVo orderQueryVo);

    void updateWorkNodeByOrderId(String orderId, String nextNode);

    /**逻辑删除，这里不做物理删除操作*/
    int deleteWorkOrderById(@Param("orderid") String orderid);

    void setOrderCompletion(String id);

    void updateOrderNodeId(@Param("orderid") String orderid,
                           @Param("nodeId") String nodeId,
                           @Param("nodeName") String nodeName);

    int  dispatchOrderById(@Param("orderid") String orderid,
                            @Param("receiverId")String receiverId,
                            @Param("receiverName")String receiverName,
                            @Param("updateTime")String updateTime);

    List<OrderQueryVo> selectListByReceiver(FilterQueryVo filterQueryVo);

    List<OrderQueryVo> selectListBySubmitter(FilterQueryVo filterQueryVo);

    List<OrderQueryVo> selectListBySender(FilterQueryVo filterQueryVo);

    List<OrderQueryVo> selectListByViewer(FilterQueryVo filterQueryVo);

    OrderQueryVo selectOrderStatusById(@Param("orderid") String orderid,@Param("roleId") String roleId);

    void completeWorkOrder(@Param("orderid") String orderid,
                           @Param("operStatus") String operStatus,
                           @Param("updateTime") String updateTime);

    OrderQueryVo selectWorkOrderById(@Param("orderid") String orderid);

    int setDemandStatus(@Param("orderid")String orderid, @Param("isDemand")String isDemand, @Param("updateTime")String updateTime);
}