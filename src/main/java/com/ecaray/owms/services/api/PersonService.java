package com.ecaray.owms.services.api;

import com.ecaray.owms.commons.Result;
import com.ecaray.owms.dao.mapper.sys.BaseUserMapper;
import com.ecaray.owms.dao.mapper.sys.RoleMapper;
import com.ecaray.owms.dao.mapper.sys.UserRoleMapper;
import com.ecaray.owms.entity.Vo.BaseUserVo;
import com.ecaray.owms.entity.Vo.UserVo;
import com.ecaray.owms.entity.sys.BaseUser;
import com.ecaray.owms.entity.sys.Role;
import com.ecaray.owms.entity.sys.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.ecaray.owms.services.api
 * Author ：zhxy
 * 2016/11/29 0:17
 * 说明：TODO
 */
@SuppressWarnings("ALL")
@Service
public class PersonService {
    @Autowired
    BaseUserMapper baseUserMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    RoleMapper roleMapper;
    public Object getPersonByRole(String realname, String roleId) {
        if(realname!=null) {
            realname = "%" + realname + "%";
        }
        return baseUserMapper.selectPersonByRoleId(realname,roleId);
    }

    public Result addUserRoles(UserRole userRole) {
        userRoleMapper.insertSelective(userRole);
        return Result.success();
    }

    public Result delUserRoles(UserRole userRole) {
        userRoleMapper.deleteUserRole(userRole);
        return Result.success();
    }

    public Result stopUserRole(UserRole userRole) {
        userRoleMapper.stopUserRole(userRole);
        return Result.success();
    }

    public List<Role> selectOrderRoles() {
        return roleMapper.selectOrderRoles();
    }

    public BaseUser selectBaseUserByUserId(String username){
        return  baseUserMapper.selectBaseUserByUserId(username);
    }

    public List<BaseUser> selectAllUsers() {
        return  baseUserMapper.selectAllUsers();
    }

    public Result addUserRoles(String userId, Integer roleId) {
        UserRole ur = new UserRole();
        ur.setUserId(userId);
        ur.setRoleId(roleId);
        userRoleMapper.insert(ur);
        return Result.success();
    }

    public List<BaseUserVo> getRoleUserFilter(String keyWords, String roleId) {
       return   baseUserMapper.selectRoleUserFilter(keyWords, roleId);
    }

    public List<BaseUser> selectUserListByUserId(List<String> receiver) {
        return baseUserMapper.selectUserListByUserId(receiver);
    }
}
