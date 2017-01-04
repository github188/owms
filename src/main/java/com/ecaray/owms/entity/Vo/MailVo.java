package com.ecaray.owms.entity.Vo;

import java.util.List;

/**
 * com.ecaray.owms.entity.Vo.OrderVo
 * Author ：zhxy
 * 2016/11/30 18:05
 * 说明：TODO
 */
public class MailVo {
    private String subject;

    private String senderUser;

    private String orderid;

    private List<String> receiver;

    public MailVo(String subject, String orderid,String senderUser, List<String> receiver) {
        this.subject = subject;
        this.orderid = orderid;
        this.receiver = receiver;
        this.senderUser = senderUser;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(String senderUser) {
        this.senderUser = senderUser;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public List<String> getReceiver() {
        return receiver;
    }

    public void setReceiver(List<String> receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "MailVo{" +
                "subject='" + subject + '\'' +
                ", orderid='" + orderid + '\'' +
                '}';
    }
}
