package com.ecaray.owms.dao.mapper.orders;

import com.ecaray.owms.entity.orders.ProblemType;

import java.util.List;

public interface ProblemTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProblemType record);


}