package com.ecaray.owms.controller;

import com.ecaray.owms.commons.Constants;
import com.ecaray.owms.commons.Result;
import com.ecaray.owms.commons.utils.ConstantsMapUtil;
import com.ecaray.owms.dao.mapper.sys.BaseUserMapper;
import com.ecaray.owms.entity.Vo.BaseUserVo;
import com.ecaray.owms.entity.Vo.UserRoleVo;
import com.ecaray.owms.entity.Vo.UserVo;
import com.ecaray.owms.entity.sys.BaseUser;
import com.ecaray.owms.entity.sys.Role;
import com.ecaray.owms.entity.sys.UserRole;
import com.ecaray.owms.services.api.PersonService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.ecaray.owms.controller
 * Author ：zhxy
 * 2016/11/28 15:54
 * 说明：后面加上组织
 */
@RequestMapping(value ="person")
@Controller
public class PersonController {
    Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    PersonService personService;
    /**
     * Author ：zhxy
     * 说明：获取技术支持员列表 13
     */
    @RequestMapping(value = "/tech" ,method = RequestMethod.GET )
    public @ResponseBody Object getTechPerson(String realname){
        return personService.getPersonByRole(realname,"13");
    }
    /**
     * Author ：zhxy
     * 说明：获取产品人员列表 14
     */
    @RequestMapping(value = "/product" ,method = RequestMethod.GET )
    public @ResponseBody  Object getProductPerson(String realname){
        return personService.getPersonByRole(realname,"14");
    }
    /**
     * Author ：zhxy
     * 说明：获取工程调度人员列表 15
     */
    @RequestMapping(value = "/dispatch" ,method = RequestMethod.GET )
    public @ResponseBody  Object  getDispatchPerson(String realname){
        return personService.getPersonByRole(realname,"15");
    }
    /**
     * Author ：zhxy
     * 说明：获取工程调度人员列表 18
     */
    @RequestMapping(value = "/projecttech" ,method = RequestMethod.GET )
    public @ResponseBody  Object  getProjectTechPerson(String realname){
        return personService.getPersonByRole(realname,"18");
    }
    /**
     * Author ：zhxy
     * 说明：运维提单人 16
     */
    @RequestMapping(value = "/submitter" ,method = RequestMethod.GET )
    public @ResponseBody  Object getSubmitterPerson(String realname){
        return personService.getPersonByRole(realname,"16");
    }

    /**
     * Author ：zhxy
     * 说明：添加用户
     */
    @RequestMapping(value = "/userrole",method = RequestMethod.POST)
    public @ResponseBody Result addUserRoles(@RequestBody UserRole userRole){
        if(userRole.getUserId()==null||userRole.getRoleId()==null||
                "".equals(userRole.getUserId())|| "".equals(userRole.getRoleId()))
            return Result.failed("用户或角色ID为空");
        //先删除后插入
        personService.delUserRoles(userRole);
        Result result = personService.addUserRoles(userRole);
        ConstantsMapUtil.addUserCache(userRole.getUserId(),personService.selectBaseUserByUserId(userRole.getUserId()));
        return result;
    }
    /**
     * Author ：zhxy
     * 说明：这个不做删除用户的操作，删除用户的用户角色表
     */

    @RequestMapping(value = "/userrole",method = RequestMethod.DELETE)
    public @ResponseBody Result stopUserRoles(@RequestBody UserRole userRole){

        if ((Result.success().getCode()).equals(personService.stopUserRole(userRole).getCode())) {
            ((Map) ConstantsMapUtil.constantsCache.get(Constants.CONSTANTS_ORDER_USER)).remove(userRole.getUserId());
            return Result.success();
        } else {
            return Result.failed("add user failed");
        }
    }

    /**
     * Author ：zhxy
     * 说明：获取所有的单据相关的 角色
     */
    @RequestMapping(value = "/orderroles",method = RequestMethod.GET)
    public @ResponseBody List<Role> getWorkOrderRoles(){
        return personService.selectOrderRoles();
    }


    @RequestMapping(value="/user/list",method = RequestMethod.GET)
    public @ResponseBody List<BaseUser> getUserByName(){
        return personService.selectAllUsers();
    }


    @RequestMapping(value="/roleuser/filter",method = RequestMethod.GET)
    public @ResponseBody Map<String ,Object> getRoleUserByName(UserRoleVo userRoleVo){
        String keyWords=null;
        Page page = PageHelper.startPage(userRoleVo.getPageNum(),userRoleVo.getPageSize());
        if(userRoleVo.getKeyWords()!=null&&!"".equals(userRoleVo.getKeyWords())){
            keyWords="%"+userRoleVo.getKeyWords()+"%";
        }
        Map<String ,Object> baseUserMap = new HashMap<String, Object>();
        baseUserMap.put("data",personService.getRoleUserFilter(keyWords,userRoleVo.getRoleId()));
        baseUserMap.put("pages",page.getPages());
        baseUserMap.put("totals",page.getTotal());
        return baseUserMap;
    }


}
