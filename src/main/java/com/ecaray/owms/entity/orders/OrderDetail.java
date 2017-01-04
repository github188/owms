package com.ecaray.owms.entity.orders;

import com.ecaray.owms.commons.Constants;
import com.ecaray.owms.commons.utils.ConstantsMapUtil;

import java.util.Map;

public class OrderDetail {
    private Integer id;

    private String orderId;

    private String operTitle;

    private String operUser;

    private String operUserName;

    private String receiveUser;

    private String receiveUserName;

    private String createTime;

    private String updateTime;

    private Integer isDelete;

    private Integer detailType;

    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOperTitle() {
        return operTitle;
    }

    public void setOperTitle(String operTitle) {
        this.operTitle = operTitle == null ? null : operTitle.trim();
    }

    public String getOperUser() {
        return operUser;
    }

    public void setOperUser(String operUser) {
        this.operUser = operUser == null ? null : operUser.trim();
    }

    public String getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(String receiveUser) {
        this.receiveUser = receiveUser == null ? null : receiveUser.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getDetailType() {
        return detailType;
    }

    public void setDetailType(Integer detailType) {
        this.detailType = detailType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getOperUserName() {
        return (String) ((Map)ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_ORDER_USER))
                .get(this.getOperUser());
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }

    public String getReceiveUserName() {
        return (String) ((Map) ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_ORDER_USER))
                .get(this.getReceiveUser());
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }
}