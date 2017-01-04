package com.ecaray.owms.dao.mapper.sys;

import com.ecaray.owms.entity.sys.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    String selectRoleByUserId(@Param("userId") String userId);

    List<Role> selectOrderRoles();
}