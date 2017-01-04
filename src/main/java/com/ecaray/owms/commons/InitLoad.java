package com.ecaray.owms.commons;

import com.ecaray.owms.commons.utils.ConstantsMapUtil;
import com.ecaray.owms.dao.mapper.orders.OrderConstantMapper;
import com.ecaray.owms.dao.mapper.sys.BaseUserMapper;
import com.ecaray.owms.dao.mapper.sys.RegionMapper;
import com.ecaray.owms.dao.mapper.sys.ResourceMapper;
import com.ecaray.owms.services.api.PersonService;
import com.ecaray.owms.services.email.MailSendThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.plaf.synth.Region;

/**
 * com.ecaray.owms.commons
 * Author ：zhxy
 * 2016/11/30 18:22
 * 说明：初始化 缓存等基础服务
 */
@SuppressWarnings("ALL")
@Component
public class InitLoad implements InitializingBean {
    @Autowired
    MailSendThread mailSendThread;
    @Autowired
    RegionMapper regionMapper;
    @Autowired
    OrderConstantMapper orderConstantMapper;
    @Autowired
    BaseUserMapper baseUserMapper;
    Logger logger = LoggerFactory.getLogger(InitLoad.class);
    public void afterPropertiesSet() throws Exception {
        //加载邮件发送线程
        mailSendThread.start();
        logger.info("邮件服务启动完毕...");
        //缓存数据
        ConstantsMapUtil.initConstants(regionMapper,orderConstantMapper,baseUserMapper);
        logger.info("常量数据缓存完毕...");
    }
}
