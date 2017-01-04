package com.ecaray.owms.dao.mapper.sys;

import com.ecaray.owms.entity.sys.UserRole;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    void deleteUserRole(UserRole userRole);

    void stopUserRole(UserRole userRole);
}