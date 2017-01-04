package com.ecaray.owms.entity.Vo;

import com.ecaray.owms.commons.Constants;
import com.ecaray.owms.commons.utils.ConstantsMapUtil;

import java.util.Map;

/**
 * com.ecaray.owms.entity.orders.OrderVo
 * Author ：zhxy
 * 2016/11/26 15:08
 * 说明：订单列表实体类
 */
public class OrderQueryVo {


    private String id;

    private String flowId;

    private String ordertypeId;

    private String ordertypeName;

    private String problemTypeId;

    private String problemTypeName;

    private String parkId;

    private String parkName;

    private String submitterId;

    private String submitterName;

    private String senderId;

    private String senderName;

    private String receiverId;

    private String receiverName;

    private Integer needSupport;

    private String orderLevelId;

    private String orderLevelName;

    private String province;

    private String city;

    private String area;

    private String provinceName;

    private String cityName;

    private String areaName;

    private String createTime;

    private String startTime;

    private String endTime;

    private String userId;

    private  String action;

    private  String shortComment;

    private String  operStatus;

    private String  operStatusName;

    private String  opers;

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

    public String getOrdertypeName() {
        Map<String,String> map = (Map) ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_ORDERSTATUS);
        return  map.get(this.getOrdertypeId());
    }

    public void setOrdertypeName(String ordertypeName) {
        this.ordertypeName = ordertypeName;
    }

    public String getProblemTypeId() {
        return problemTypeId;
    }

    public void setProblemTypeId(String problemTypeId) {
        this.problemTypeId = problemTypeId;
    }

    public String getProblemTypeName() {
        Map<String,String> map = (Map) ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_ORDERSTATUS);
        return  map.get(this.getProblemTypeId());
    }

    public void setProblemTypeName(String problemTypeName) {
        this.problemTypeName = problemTypeName;
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
        this.parkName = parkName;
    }

    public String getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
    }

    public String getSubmitterName() {
        return (String) ((Map)ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_ORDER_USER))
                .get(this.getSubmitterId());
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
        return (String) ((Map)ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_ORDER_USER))
                .get(this.getSenderId());
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
       return (String) ((Map)ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_ORDER_USER))
               .get(this.getReceiverId());
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

    public String getOrderLevelName() {
        Map<String,String> map = (Map) ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_ORDERSTATUS);
        return  map.get(this.getOrderLevelId());
    }

    public void setOrderLevelName(String orderLevelName) {
        this.orderLevelName = orderLevelName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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

    public String getOperStatus() {
        return operStatus;
    }

    public void setOperStatus(String operStatus) {
        this.operStatus = operStatus;
    }

    public String getOperStatusName() {
        Map<String,String> map = (Map) ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_ORDERSTATUS);
        return  map.get(this.getOperStatus());
    }

    public void setOperStatusName(String operStatusName) {
        this.operStatusName = operStatusName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getProvinceName() {
        Map<String,String> map = (Map) ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_PROVINCE);
       return  map.get(this.getProvince());

    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        Map<String,String> map = (Map) ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_CITY);
        return  map.get(this.getCity());
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        Map<String,String> map = (Map) ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_AREA);
        return  map.get(this.getArea());
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getOpers() {
        return opers;
    }

    public void setOpers(String opers) {
        this.opers = opers;
    }
}
