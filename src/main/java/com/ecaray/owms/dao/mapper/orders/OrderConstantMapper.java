package com.ecaray.owms.dao.mapper.orders;

import com.ecaray.owms.entity.orders.OrderLevel;
import com.ecaray.owms.entity.orders.OrderOperStatus;
import com.ecaray.owms.entity.orders.OrderType;
import com.ecaray.owms.entity.Vo.OrderConstantsVo;
import com.ecaray.owms.entity.orders.ProblemType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderConstantMapper {

    List<OrderType> selectOrderTypes();

    List<OrderLevel> selectOrderLevels();

    List<ProblemType> selectProblemTypes();

    List<OrderConstantsVo>  selectAllOrderConstants();

    List<OrderOperStatus> selectOrderOperStatus();

    void addProblemTypes(OrderConstantsVo orderConstantsVo);

    String selectMaxIdByType(@Param("type") String type);
}