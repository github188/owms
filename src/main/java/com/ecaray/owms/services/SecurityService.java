package com.ecaray.owms.services;

import com.ecaray.owms.commons.Constants;
import com.ecaray.owms.commons.utils.CookieUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * com.ecaray.owms.services
 * Author ：zhxy
 * 2016/11/23 21:58
 * 说明：用户鉴权管理
 */
@Service
public class SecurityService {

    /**
     * Author ：zhxy
     * 说明：获取当前用户的权限角色
     */
    public String[] getRoles(HttpServletRequest request){
        Cookie cookie = CookieUtil.getCookieByName(request, Constants.USER_ROLE);
        String value = cookie.getValue();
        String [] roleStr = value.split(";");
        return roleStr;
    }

    /**
     * Author ：zhxy
     * 说明：根据传入的传入的角色，从cookies中取得当前的用户的角色来做验证
     */
    public boolean hasRolePermission(HttpServletRequest request, ArrayList<String> roles){
        //从cookies中获取当前角色
        String [] roleStr = getRoles(request);
        for(String role:roleStr){
            for(String frole:roles){
                if(frole==null||"".equals(frole))
                    continue;
                if(frole==role||frole.equals(role)){
                    //只要有一个符合的就返回符合权限
                    return true;
                }
            }
        }
        return false;
    }
}
