package com.ecaray.owms.commons.utils;

import java.util.UUID;

/**
 * com.ecaray.owms.commons.utils
 * Author ：zhxy
 * 2016/11/23 15:31
 * 说明：数字转化工具类
 */
public class DataUtil {

    /**
     * Author ：zhxy
     * 说明：随机数转化工具类
     */
    public static String uuidData(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid;
    }

}
