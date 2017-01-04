package com.ecaray.owms.services.email;

import com.ecaray.owms.commons.Constants;
import com.ecaray.owms.commons.utils.ConstantsMapUtil;
import com.ecaray.owms.entity.Vo.MailVo;
import com.ecaray.owms.entity.Vo.OrderQueryVo;
import com.ecaray.owms.entity.orders.OrderDetail;
import com.ecaray.owms.entity.orders.WorkOrder;
import com.ecaray.owms.entity.sys.BaseUser;
import com.ecaray.owms.services.api.PersonService;
import com.ecaray.owms.services.api.WorkOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * com.ecaray.owms.services.email
 * Author ：zhxy
 * 2016/11/30 17:53
 * 说明：邮件发送的支线任务，不影响主线任务的运行
 */
@Service
public class MailSendThread extends Thread {

    public static LinkedBlockingQueue<MailVo> queue  = new LinkedBlockingQueue();
    Logger logger = LoggerFactory.getLogger(MailSendThread.class);
    @Autowired
    MailSendService mailSendService ;
    @Autowired
    WorkOrderService workOrderService;
    @Autowired
    PersonService personService;

    @Value("${mail.oa.url}")
    String oaUrl;

    @Override
    public void run() {
        while(true) {
            try {
                MailVo mailVo = queue.take();//wait
                StringBuffer sbText = new StringBuffer();
                OrderQueryVo orderQueryVo = workOrderService.selectWorkOrderById(mailVo.getOrderid());
                if(Constants.ORDER_OPER_STATUS_FINISH.equals(orderQueryVo.getOperStatus())){
                    if(orderQueryVo.getSubmitterId()!=null){
                    mailVo.getReceiver().add(orderQueryVo.getSubmitterId());
                    }
                    if(orderQueryVo.getSenderId()!=null){
                        mailVo.getReceiver().add(orderQueryVo.getSenderId());
                    }
                }
                List<BaseUser> baseUserList= personService.selectUserListByUserId(mailVo.getReceiver());
                List<OrderDetail> odList = (List<OrderDetail>) workOrderService.selectDetailByOrderId(mailVo.getOrderid());
                if(baseUserList==null||baseUserList.size()==0)
                {
                    logger.info("发送邮件失败，邮件接收人为空，"+mailVo.toString());
                    continue;
                }
                String [] receiverUsers =  new String[baseUserList.size()];
                for(int i=0;i<baseUserList.size();i++){
                    receiverUsers[i] = baseUserList.get(i).getEmail();
                }
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sbText.append("<body>");
                        if(Constants.ORDER_OPER_STATUS_FINISH.equals(orderQueryVo.getOperStatus())){
                            sbText.append("<p>工单已经结束，请相关人员做好回访工作！</p>");
                        }else {
                            sbText.append("<p>[").append(
                                    ((Map) ConstantsMapUtil.constantsCache
                                            .get(Constants.CONSTANTS_ORDER_USER))
                                            .get(mailVo.getSenderUser())
                                    ).append("]:给您发送了一个工单,")
                                    .append("请尽快<a href='"+oaUrl+"'>登录OA</a>进行操作").append("</p>");
                        }
                sbText .append("<p><b>提单时间：</b>")
                        .append(format.format(new Date(Long.parseLong(String.valueOf(orderQueryVo.getCreateTime())))))
                        .append("</p>")
                        .append("<p><b>问题类型：</b>").append(orderQueryVo.getOrdertypeName()).append("</p>")
                        .append("<p><b>优先级别：</b>").append(orderQueryVo.getOrderLevelName()).append("</p>")
                        .append("<p><b>问题简述：</b>").append(orderQueryVo.getShortComment()).append("</p>")
                        .append("<p><b>工单状态：</b>").append(orderQueryVo.getOperStatusName()).append("</p>")
                        .append("<p><b>工单详情：</b>");

                        for(OrderDetail orderDetail :odList){

                            sbText.append("<p>");
                            if(orderDetail.getDetailType()==1){
                                sbText.append("<font color=\"#ff9900\">");
                            }
                            sbText.append("操作人：").append(orderDetail.getOperUserName());
                            sbText.append("  |  ");
                            sbText.append("操作：").append(orderDetail.getOperTitle());
                            sbText.append("  |  ");
                            sbText.append("时间：").append(
                                    format.format(new Date(Long.parseLong(String.valueOf(orderDetail.getCreateTime())))));
                            sbText.append("</br>");
                            sbText.append("说明：</br>");
                            sbText.append(orderDetail.getComment());
                            if(orderDetail.getDetailType()==1){
                                sbText.append("</font>");
                            }
                            sbText.append("</p>");
                            sbText.append("<hr style=\" height:2px;border:none;border-top:2px dotted #185598;\" />");
                        }

                sbText.append("</body>");

                mailSendService.sendHTMLMail("【"+mailVo.getSubject()+"】"+orderQueryVo.getShortComment(),
                        sbText.toString(),
                        receiverUsers);
                Thread.sleep(1);
            } catch (InterruptedException e) {
                logger.debug("邮件发送失败！");
                e.printStackTrace();
            }


        }
    }

}
