package com.ecaray.owms.services.api;

import com.ecaray.owms.dao.mapper.sys.ResourceMapper;
import com.ecaray.owms.entity.sys.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.ecaray.owms.services.api
 * Author ：zhxy
 * 2016/12/6 12:10
 * 说明：资源  按钮 和 菜单
 */
@SuppressWarnings("ALL")
@Service
public class ResourceService {
    @Autowired
    ResourceMapper resourceMapper;
    public List<Button> selectUserButtons(String username) {
        return resourceMapper.selectUserButtons(username);
    }
}
