package com.ecaray.owms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * com.ecaray.owms.controller
 * Author ：zhxy
 * 2016/11/23 22:51
 * 说明：取得当前用户的操作权限（即菜单和操作按钮）
 */
@RequestMapping(value="security")
public class SecurityController {
    @RequestMapping(value="/resources")
    public @ResponseBody Object getUserMenus(HttpServletRequest request ){
        return null;
    }

}
