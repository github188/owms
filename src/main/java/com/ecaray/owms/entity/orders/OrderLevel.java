package com.ecaray.owms.entity.orders;

/**
 * com.ecaray.owms.entity.orders.OrderLevel
 * Author ：zhxy
 * 2016/12/1 12:03
 * 说明：订单级别
 */
public class OrderLevel {
    String orderLevelId;
    String orderLevelName;

    public String getOrderLevelId() {
        return orderLevelId;
    }

    public void setOrderLevelId(String orderLevelId) {
        this.orderLevelId = orderLevelId;
    }

    public String getOrderLevelName() {
        return orderLevelName;
    }

    public void setOrderLevelName(String orderLevelName) {
        this.orderLevelName = orderLevelName;
    }
}
