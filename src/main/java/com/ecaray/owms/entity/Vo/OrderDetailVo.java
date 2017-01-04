package com.ecaray.owms.entity.Vo;

/**
 * com.ecaray.owms.entity.Vo
 * Author ：zhxy
 * 2016/12/2 18:00
 * 说明：TODO
 */
public class OrderDetailVo {
    private Integer id;

    private String orderId;

    private String operTitle;

    private String operUser;

    private String receiveUser;

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
        this.operTitle = operTitle;
    }

    public String getOperUser() {
        return operUser;
    }

    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }

    public String getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(String receiveUser) {
        this.receiveUser = receiveUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
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
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "OrderDetailVo{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", operTitle='" + operTitle + '\'' +
                ", operUser='" + operUser + '\'' +
                ", receiveUser='" + receiveUser + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isDelete=" + isDelete +
                ", detailType=" + detailType +
                ", comment='" + comment + '\'' +
                '}';
    }
}
