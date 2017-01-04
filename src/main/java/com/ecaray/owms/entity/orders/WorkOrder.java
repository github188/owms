package com.ecaray.owms.entity.orders;

public class WorkOrder {
    private String id;

    /**工单类型*/
    private String ordertypeId;

    private String ordertypeName;
    /**工单流程*/
    private String flowId;

    /**问题类型*/
    private String problemTypeId;

    /**停车场*/
    private String parkId;

    private String parkName;
    /**提单人*/
    private String submitterId;
    /**提单人*/
    private String submitterName;
    /**工单调度人*/
    private String senderId;
    /**工单调度人*/
    private String senderName;
    /**具体处理人（产品和技术支持）*/
    private String receiverId;
    /**具体处理人（产品和技术支持）*/
    private String receiverName;
    /**是否需要技术支持 需要1 不需要 0*/
    private Integer needSupport;
    /**程状态（操作状态）1待派单、2待接单、3处理中4 处理完成*/
    private String operStatus;
    /**订单优先级别*/
    private String orderLevelId;
    /**省市区*/
    private String province;

    private String city;

    private String area;

    private String orderStatus;

    private String createTime;

    private String updateTime;

    private Integer isDelete;
    /**简单描述*/
    private String shortComment;

    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrdertypeId() {
        return ordertypeId;
    }

    public void setOrdertypeId(String ordertypeId) {
        this.ordertypeId = ordertypeId;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId == null ? null : flowId.trim();
    }

    public String getProblemTypeId() {
        return problemTypeId;
    }

    public void setProblemTypeId(String problemTypeId) {
        this.problemTypeId = problemTypeId;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName == null ? null : parkName.trim();
    }

    public String getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Integer getNeedSupport() {
        return needSupport;
    }

    public void setNeedSupport(Integer needSupport) {
        this.needSupport = needSupport;
    }

    public String getOperStatus() {
        return operStatus;
    }

    public void setOperStatus(String operStatus) {
        this.operStatus = operStatus == null ? null : operStatus.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
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

    public String getOrdertypeName() {
        return ordertypeName;
    }

    public void setOrdertypeName(String ordertypeName) {
        this.ordertypeName = ordertypeName;
    }

    public String getShortComment() {
        return shortComment;
    }

    public void setShortComment(String shortComment) {
        this.shortComment = shortComment;
    }

    public String getOrderLevelId() {
        return orderLevelId;
    }

    public void setOrderLevelId(String orderLevelId) {
        this.orderLevelId = orderLevelId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "WorkOrder{" +
                "id='" + id + '\'' +
                ", ordertypeId='" + ordertypeId + '\'' +
                ", ordertypeName='" + ordertypeName + '\'' +
                ", flowId='" + flowId + '\'' +
                ", parkId=" + parkId +
                ", parkName='" + parkName + '\'' +
                ", submitterId='" + submitterId + '\'' +
                ", submitterName='" + submitterName + '\'' +
                ", senderId='" + senderId + '\'' +
                ", senderName='" + senderName + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", needSupport=" + needSupport +
                ", operStatus='" + operStatus + '\'' +
                ", orderLevelId='" + orderLevelId + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isDelete=" + isDelete +
                ", shortComment='" + shortComment + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}