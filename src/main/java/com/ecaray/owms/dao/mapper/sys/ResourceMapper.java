package com.ecaray.owms.dao.mapper.sys;

import com.ecaray.owms.entity.sys.Button;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * com.ecaray.owms.dao.mapper.sys
 * Author ：zhxy
 * 2016/12/6 11:12
 * 说明：TODO
 */
public interface ResourceMapper {

    List<Button> selectUserButtons(@Param("userId") String userId);

}
