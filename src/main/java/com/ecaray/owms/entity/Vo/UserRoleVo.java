package com.ecaray.owms.entity.Vo;

/**
 * com.ecaray.owms.entity.Vo
 * Author ：zhxy
 * 2016/12/6 9:45
 * 说明：TODO
 */
public class UserRoleVo {
    private String keyWords;
    private Integer pageNum;
    private Integer pageSize;
    private String roleId;

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
