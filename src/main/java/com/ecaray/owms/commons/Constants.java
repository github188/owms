package com.ecaray.owms.commons;

/**
 * com.ecaray.authmanager.commons
 * Author ：zhxy
 * 2016/11/19 20:36
 * 说明：TODO
 */
public interface Constants {
    //常量
    public static final String TOKEN_TOKEN ="token";
    /**Token 常量值*/
    public static final String TOKEN_VALUE ="Ecar2016";


    /**订单是否已经提交：1 是， 0否*/
    public static final int ORDER_SUBMIT_STATUS_YES = 1;
    /**订单是否已经提交：1 是， 0否*/
    public static final int ORDER_SUBMIT_STATUS_NO = 0;


    //常数
    /**Token 验证码*/
    public static final String TOKEN_SIGNATURE ="signature";
    /**Token 时间戳*/
    public static final String TOKEN_TIMESTAMP ="timestamp";
    /**Token 随机数*/
    public static final String TOKEN_NONCE ="nonce";
    /**userrole常量值*/
    public static final String USER_ROLE = "userrole";
    /**订单全局查看角色*/
    public static final String  ORDER_ROLE_VIEW = "order_all_view";
    /**订单初始化角色*/
    public static final String  ORDER_ROLE_ADD = "order_add";
    /**处理角色*/
    public static final String  ORDER_ROLE_DEALER = "order_dealer";

    /**工程提单*/
    public static final String  WORK_ORDER_TYPE_PROJECT = "1001";
    /**产品提单*/
    public static final String  WORK_ORDER_TYPE_PRODUCT = "1002";
    /**运维提单*/
    public static final String  WORK_ORDER_TYPE_MAINTENANCE = "1003";


    //工单操作状态
    /** 1 为待派单  2 为 处理中 ，3 处理中，4 已经处理*/
    public static final String ORDER_OPER_STATUS_SENDER_WAIT = "4001";
    public static final String ORDER_OPER_STATUS_SENDER_WAIT_NAME = "待派单";
    public static final String ORDER_OPER_STATUS_RECEIVE_WAIT = "4002";
    public static final String ORDER_OPER_STATUS_RECEIVE_WAIT_NAME = "待接单";
    public static final String ORDER_OPER_STATUS_DOING = "4003";
    public static final String ORDER_OPER_STATUS_DOING_NAME = "处理中";
    public static final String ORDER_OPER_STATUS_FINISH = "4004";
    public static final String ORDER_OPER_STATUS_FINISH_NAME = "处理完成";


    public static final String CONSTANTS_ORDERSTATUS = "constants_orderstatus";
    public static final String CONSTANTS_PROVINCE = "constants_province";
    public static final String CONSTANTS_CITY = "constants_city";
    public static final String CONSTANTS_AREA = "constants_area";
    public static final String CONSTANTS_ORDER_USER ="constants_order_user" ;
}
