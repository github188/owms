package com.ecaray.owms.services.api;

import com.ecaray.owms.commons.Constants;
import com.ecaray.owms.commons.Result;
import com.ecaray.owms.commons.utils.ConstantsMapUtil;
import com.ecaray.owms.commons.utils.DataUtil;
import com.ecaray.owms.dao.mapper.orders.OrderConstantMapper;
import com.ecaray.owms.dao.mapper.orders.OrderDetailMapper;
import com.ecaray.owms.dao.mapper.orders.WorkOrderMapper;
import com.ecaray.owms.dao.mapper.sys.RoleMapper;
import com.ecaray.owms.entity.Vo.*;
import com.ecaray.owms.entity.orders.OrderDetail;
import com.ecaray.owms.entity.orders.WorkOrder;
import com.ecaray.owms.services.email.MailSendThread;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.ecaray.owms.services.api
 * Author ：zhxy
 * 2016/11/23 15:17
 * 说明：TODO
 */

@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class WorkOrderService {
    Logger logger = LoggerFactory.getLogger(WorkOrderService.class);
    @Autowired
    WorkOrderMapper workOrderMapper;
    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    OrderConstantMapper orderConstantMapper;
    @Autowired
    PersonService personService;
    @Autowired
    ParkingService parkingService;
    /**
     * Author ：zhxy
     * 说明：重写新增订单，非流程方式 low
     *  1001 工程提单	0
     *  1002 产品提单	0
     *  1003 运维提单	0
     */
    public Result addWorkOrder(WorkOrder workOrder) {
        String parkId = workOrder.getParkId();
       if(parkingService.selectParkingListById(parkId)<1){
           logger.info("未找到有效车场,parkid="+parkId+",orderid="+workOrder.getId());
           return Result.failed("未找到有效车场，请重新匹配!");
       }
        List<String> mailReceiver = new ArrayList<String>();
        String flowId = workOrder.getOrdertypeId();
        String orderId = DataUtil.uuidData();
        workOrder.setId(orderId);
        String acceptUser = null;
       if (Constants.WORK_ORDER_TYPE_PROJECT.equals(flowId)) {//工程提单
           if(workOrder.getSenderId()==null||"".equals(workOrder.getSenderId())){
               return Result.failed("未指定有效的派单人!");
           }
           acceptUser = workOrder.getSenderId();
           workOrder.setOperStatus(Constants.ORDER_OPER_STATUS_SENDER_WAIT);
       }else if (Constants.WORK_ORDER_TYPE_PRODUCT.equals(flowId)){//产品提单
           workOrder.setNeedSupport(1);//具体到处理人
           acceptUser = workOrder.getReceiverId();
           workOrder.setOperStatus(Constants.ORDER_OPER_STATUS_DOING);
       }else if (Constants.WORK_ORDER_TYPE_MAINTENANCE.equals(flowId)){//运维提单
           //运维工单，判断是否需要技术支持,如果需要技术支持则直接提交
           if(workOrder.getNeedSupport()!=null&&workOrder.getNeedSupport()==1){
               if(workOrder.getReceiverId()==null ||"".equals(workOrder.getReceiverId())){
                   return Result.failed("未指定有效的运维支持人员!");
               }
               acceptUser = workOrder.getReceiverId();
               workOrder.setOperStatus(Constants.ORDER_OPER_STATUS_DOING);
           }else{
               workOrder.setOperStatus(Constants.ORDER_OPER_STATUS_FINISH);
           }
       }else{
           Result.failed("提单类型错误!");
       }

        String createTime = System.currentTimeMillis()+"";
        workOrder.setCreateTime(createTime);
        workOrder.setUpdateTime(createTime);
        workOrderMapper.insertSelective(workOrder);

        if(acceptUser!=null&&!"".equals(acceptUser)){
            mailReceiver.add(acceptUser);//如果指定处理人则发邮件给处理人，否则不发邮件
        }
        //增加提单明细
        createOrderDetail("提交工单",workOrder.getId(),workOrder.getComment(),acceptUser,
              workOrder.getSubmitterId() ,createTime,createTime,1);
        if(!Constants.WORK_ORDER_TYPE_MAINTENANCE.equals(flowId)) {
            MailVo mailVo = new MailVo("提交工单", workOrder.getId(), workOrder.getSubmitterId(), mailReceiver);
            MailSendThread.queue.offer(mailVo);
        }
        return Result.success();
    }
    /**
     * Author ：zhxy
     * 说明：根据order id更新工单信息
     */
    public Result updateWorkOrder(WorkOrder workOrder) {
        String id = workOrder.getId();
        if(id==null||"".equals(id)){
            return Result.failed("无法识别的工单！");
        }
        workOrderMapper.updateById(workOrder);
        return Result.success();
    }

    /**
     * Author ：zhxy
     * 说明：
     * 1.查询根据当前用户和登录的角色，如果没有登录角色则为用户对单一角色
     * 2.查询登录角色所在的工作流节点，如果为录单角色或者查看角色则可以单独查询，不做工单类型对角色的现实
     * 3.
     */

    public Object getAllOrderList(HttpServletRequest request, OrderQueryVo orderQueryVo, int pageNum, int pageSize ){
        PageHelper.startPage(pageNum,pageSize);
        return workOrderMapper.selectDealerListByFilter(orderQueryVo);
    }

    public Object selectDetailByOrderId(String orderId) {
        return orderDetailMapper.selectDetailByOrderId(orderId);
    }

    public Result deleteWorkOrderById(String orderid) {
        workOrderMapper.deleteWorkOrderById(orderid);
        return Result.success();
    }

    /**
     * Author ：zhxy
     * 说明：工程工单调度
     */
    public Result dispatchWorkOrder(String title,String orderid, String receiverUser,
                                     String comment, String userId) {
        String updateTime = System.currentTimeMillis()+"";
        workOrderMapper.dispatchOrderById(orderid,receiverUser,null,updateTime);
        if(receiverUser==null||"".equals(receiverUser)){
            logger.info("派单失败,未指定有效的派单人,orderid:"+orderid);
            Result.failed("未指定有效的指派人！");
        }
        createOrderDetail(title,orderid,comment,receiverUser,userId,updateTime,updateTime,1);
        List<String> receiverList = new ArrayList<String>();
        receiverList.add(receiverUser);
        MailVo mailVo = new MailVo(title,orderid,userId,receiverList);
        MailSendThread.queue.offer(mailVo);
        return Result.success();
    }
    private void createOrderDetail(String title ,String orderid, String comment,
                                   String receiverUser,String operUser,String ctime,String utime,int detailType) {
        OrderDetail or = new OrderDetail();
        or.setOperTitle(title);
        or.setOrderId(orderid);
        or.setComment(comment);
        or.setOperUser(operUser);
        or.setReceiveUser(receiverUser);
        or.setCreateTime(ctime);
        or.setUpdateTime(utime);
        or.setDetailType(detailType);
        orderDetailMapper.insertSelective(or);
    }

    /**
     * Author ：zhxy
     * 说明：添加工单
     */
    public Map<String,Object> getCurUserList( FilterQueryVo filterQueryVo) {
       String roleId = roleMapper.selectRoleByUserId(filterQueryVo.getUserId());
        filterQueryVo.setRoleId(roleId);
        Page page =  PageHelper.startPage(filterQueryVo.getPageNum(),filterQueryVo.getPageSize());
        Map<String,Object> resultMap  = new HashMap<String, Object>();
        List<OrderQueryVo> list = null ;
        /**choulou的写法*/
        if("13".equals(roleId)||"18".equals(roleId)){//技术支持
            list =    workOrderMapper.selectListByReceiver(filterQueryVo);
        }else if("14".equals(roleId)){//产品
            list =    workOrderMapper.selectListByReceiver(filterQueryVo);
        }else if("15".equals(roleId)){//工程调度
            list =    workOrderMapper.selectListBySender(filterQueryVo);
        }else if("16".equals(roleId)){///运维提单
            list =    workOrderMapper.selectListBySubmitter(filterQueryVo);
        }else if("17".equals(roleId)){//查看人
            list =    workOrderMapper.selectListByViewer(filterQueryVo);
        }
        resultMap.put("data",list);
        resultMap.put("pages",page.getPages());
        resultMap.put("totals",page.getTotal());
        return resultMap;
    }

    /**
     * Author ：zhxy
     * 说明：添加详情
     */
    public Result addWorkOrderDetail(String operUser, String comment,
                                     String title, String orderid,int detailType) {
        String curTime = System.currentTimeMillis()+"";
        createOrderDetail(title,orderid,comment,null,operUser,curTime,curTime,detailType);
        return Result.success();
    }

    /**
     * Author ：zhxy
     * 说明：获取工单状态
     */
    public OrderQueryVo getWorkOrderStatus(String orderid,String userId) {
        String roleId = roleMapper.selectRoleByUserId(userId);
       return  workOrderMapper.selectOrderStatusById(orderid,roleId);
    }

    /**
     * Author ：zhxy
     * 说明：完成工单
     */
    public Result completeWorkOrder(CompleteVo completeVo) {
        String updateTime = System.currentTimeMillis()+"";
        Map<String,String> mapConstants = ConstantsMapUtil.convertConstantsMap(orderConstantMapper.selectAllOrderConstants());
        String  problemTypeName = mapConstants.get(completeVo.getProblemTypeId());
        String comment ="问题类型："+ problemTypeName+"<br/>"+completeVo.getComment();
        completeVo.setComment(comment);
        workOrderMapper.completeWorkOrder(completeVo.getOrderId(),
                Constants.ORDER_OPER_STATUS_FINISH,
                updateTime);
        createOrderDetail(completeVo.getOperTitle(),
                completeVo.getOrderId(),completeVo.getComment(),null,completeVo.getOperUser(),updateTime,updateTime,1);
        List<String> receiverList = new ArrayList<String>();
        receiverList.add("submitter");
        MailVo mailVo = new MailVo(completeVo.getOperTitle(),completeVo.getOrderId(),null,receiverList);
        MailSendThread.queue.offer(mailVo);
        return Result.success();
    }

    public OrderQueryVo selectWorkOrderById(String orderid) {
        return workOrderMapper.selectWorkOrderById(orderid);
    }

    /**
     * Author ：zhxy
     * 说明：需求判定
     * TODO :前端未做处理
     */
    public Result demandJudge(DemandJudgeVo demandJudgeVo) {
        //1为需求 0 非需求，不指定默认状态
        String judgeStatus ="需求判定：";
        if("1".equals(demandJudgeVo.getIsDemand())){
            judgeStatus+="是<br/>";
        }else if("0".equals(demandJudgeVo.getIsDemand())){
            judgeStatus+="否<br/>";
        }else{
            Result.failed("为指定是否为需求，请重新操作");
        }
        workOrderMapper.setDemandStatus(demandJudgeVo.getOrderId(),demandJudgeVo.getIsDemand(),System.currentTimeMillis()+"");
        //更新操作状态
        addWorkOrderDetail(demandJudgeVo.getOperUser(),
                demandJudgeVo.getComment(),demandJudgeVo.getOperTitle(),demandJudgeVo.getOrderId(),0);

        return Result.success();
    }
}
