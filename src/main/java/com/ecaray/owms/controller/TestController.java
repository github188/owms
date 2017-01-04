package com.ecaray.owms.controller;

import com.ecaray.owms.commons.Result;
import com.ecaray.owms.entity.Vo.MailVo;
import com.ecaray.owms.services.email.MailSendThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * com.ecaray.owms.controller
 * Author ：zhxy
 * 2016/12/5 23:03
 * 说明：TODO
 */
@RequestMapping(value ="test")
@Controller
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);
    @RequestMapping(value="/email")
    public @ResponseBody Result sendEmail(@CookieValue("_uid")String uid,@CookieValue("_uname")String username){
        List<String> receiverusers = new ArrayList<String>();
        receiverusers.add("ywtda");
        MailVo  mailVo = new MailVo("uid","ea2853762513422e86940cb574fb7502",null,receiverusers);
        mailVo.setOrderid("ea2853762513422e86940cb574fb7502");
        mailVo.setSubject("提交工单");
        mailVo.setSenderUser("ywtda");
        mailVo.setReceiver(receiverusers);
        MailSendThread.queue.offer(mailVo);
        return Result.success();
    }
    @RequestMapping(value="/request")
    public @ResponseBody Result testRequest(@CookieValue("_uid")String uid,@CookieValue("_uname")String username){
        logger.info("=============================="+uid+"==================="+username);
        System.out.println("=============================="+uid+"==================="+username);
        return Result.failed("=============================="+uid+"==================="+username);
    }

}
