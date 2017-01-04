package com.ecaray.owms.entity.Vo;

/**
 * com.ecaray.owms.entity.Vo
 * Author ：zhxy
 * 2016/12/5 10:49
 * 说明：问题处理完成
 */
public class CompleteVo extends OrderDetailVo {
    private String problemTypeId;

    private String problemTypeName;

    public String getProblemTypeId() {
        return problemTypeId;
    }

    public void setProblemTypeId(String problemTypeId) {
        this.problemTypeId = problemTypeId;
    }

    public String getProblemTypeName() {
        return problemTypeName;
    }

    public void setProblemTypeName(String problemTypeName) {
        this.problemTypeName = problemTypeName;
    }
}
