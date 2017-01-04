package com.ecaray.owms.dao.mapper.sys;

import com.ecaray.owms.entity.Vo.BaseUserVo;
import com.ecaray.owms.entity.sys.BaseUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);

    BaseUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);

    List<BaseUser> selectPersonByRoleId(@Param("realname") String realname,@Param("roleId") String roleId);

    BaseUser selectBaseUserByUserId(String userId);
//    BaseUser selectBaseUserByUsername(String userId);

    List<BaseUser> selectAllUsers();

    List<BaseUserVo>  selectRoleUserFilter(@Param("keyWords")String keyWords, @Param("roleId") String roleId);

    List<BaseUser> selectUserListByUserId(List<String> receiver);

    List<BaseUser> selectWorkOrderUsers();
}