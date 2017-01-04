package com.ecaray.owms.entity.Vo;

import com.ecaray.owms.entity.sys.BaseUser;

/**
 * com.ecaray.owms.entity.Vo
 * Author ：zhxy
 * 2016/12/6 11:06
 * 说明：TODO
 */
public class BaseUserVo extends BaseUser {
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
