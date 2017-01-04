package com.ecaray.owms.dao.mapper.orders;

import com.ecaray.owms.entity.orders.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDetailMapper {

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectDetailByOrderId(@Param("orderid") String orderid);


}