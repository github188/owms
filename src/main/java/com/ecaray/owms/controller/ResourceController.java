package com.ecaray.owms.controller;

import com.ecaray.owms.entity.sys.Button;
import com.ecaray.owms.services.api.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * com.ecaray.owms.controller
 * Author ：zhxy
 * 2016/12/6 10:48
 * 说明：TODO
 */
@RequestMapping(value = "resource")
@Controller
public class ResourceController {
    @Autowired
    ResourceService resourceService;
    @RequestMapping(value="/{username}/buttons")
    public @ResponseBody List<Button> getUserButtons(@PathVariable String username){
        return  resourceService.selectUserButtons(username);
    }
}
