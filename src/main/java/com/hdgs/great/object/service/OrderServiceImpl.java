package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Notification;
import com.hdgs.great.object.domain.Order;
import com.hdgs.great.object.domain.WxAccount;
import com.hdgs.great.object.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    NotificationService notificationService;

    @Autowired
    WxAccountService wxAccountService;

    /**
     * 创建订单
     *
     * @param order 订单数据
     */
    @Override
    public boolean createOrder(Order order) {
        //创建当前时间对象，封装Order属性
        Date now = new Date();
        //创建id值
        Integer id=null;now.getTime();
        id= (int)(Math.random()*Integer.MAX_VALUE);

        //检查是否已经存在相同id的数据
        Order oorder=orderRepository.findOrderById(id);
        if(oorder!=null){
            return false ;
        }

        order.setOid(id);
        order.setCreate_Date(now);
        //封装日志
        order.setCreated_Time(now);
        order.setModified_Time(now);
        int insertNum=orderRepository.insertOrder(order);
        return insertNum>0?true:false;
    }

    /**
     * 修改订单信息
     *
     * @param order
     * @return
     */
    @Override
    public boolean updateOrderInfo(Order order) {

        //创建时间对象，封装数据
        Date now = new Date();
        order.setCreate_Date(now);
        order.setModified_User(order.getCreater_Name());
        order.setModified_Time(now);

        //判断是否是未接单，若不是，则不能修改
        if(order.getStatus() != 0){
            return false;
        }

        int updateNum=orderRepository.updateOrderById(order);
        return updateNum>0?true:false;
    }

    /**
     * 修改状态为接单
     *
     * @param orderId
     * @param accepterId
     * @return
     */
    @Override
    public Notification acceptOrder(Integer orderId, String accepterId) {
        //查出对应订单信息
        Order order=orderRepository.findOrderById(orderId);

        //判断该订单数据是否存在
        if(order == null){
            return null;
        }

        //判断订单状态是否合法
        if(!isOrderAlive(order.getStatus())){
            return null;
        }

        //创建时间对象
        Date now = new Date();
        //封装数据
        order.setAccept_Date(now);
        order.setAccepter_Id(accepterId);
        order.setStatus(1);
        order.setModified_Time(now);
        orderRepository.updateOrderById(order);

        //获取接单人用户信息
        WxAccount accepter = wxAccountService.getWxAccountByOpenId(accepterId);
        //返回通知数据
        return  createNotification(accepterId , order.getCreater_Id() ,accepter.getNick_Name()+"已接受你的订单");
    }


    /**
     * 修改状态为送货中
     *
     * @param orderId
     * @return
     */
    @Override
    public Notification deliveringOrder(Integer orderId) {
        //查出对应订单信息
        Order order=orderRepository.findOrderById(orderId);

        //判断该订单数据是否存在
        if(order == null){
            return null;
        }

        //判断订单状态是否合法
        if(!isOrderAlive(order.getStatus())){
            return null;
        }

        //创建时间对象
        Date now = new Date();
       //封装数据
        order.setStatus(2);
        order.setModified_Time(now);
        orderRepository.updateOrderById(order);

        //获取接单人用户信息
        WxAccount accepter = wxAccountService.getWxAccountByOpenId(order.getAccepter_Id());

        return createNotification(order.getAccepter_Id() , order.getCreater_Id(), accepter.getNick_Name() + "正在为你送货中");
    }

    /**
     * 修改状态为已接收
     *
     * @param orderId
     * @return
     */
    @Override
    public Notification receivedOrder(Integer orderId) {
        //查出对应订单信息
        Order order=orderRepository.findOrderById(orderId);

        //判断该订单数据是否存在
        if(order == null){
            return null;
        }

        //判断订单状态是否合法
        if(!isOrderAlive(order.getStatus())){
            return null;
        }

        //创建时间对象
        Date now = new Date();
        //封装数据
        order.setStatus(3);
        order.setModified_Time(now);
        orderRepository.updateOrderById(order);

        //获取接单人用户信息
        WxAccount accepter = wxAccountService.getWxAccountByOpenId( order.getCreater_Id());

        return createNotification( order.getCreater_Id(), order.getAccepter_Id() ,accepter.getNick_Name() + "已经接收你完成的订单");
    }


    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @Override
    public Notification cancelOrder(Integer orderId) {
        //查出对应订单信息
        Order order=orderRepository.findOrderById(orderId);

        //判断该订单数据是否存在
        if(order == null){
            return null;
        }

        //判断订单状态是否合法
        if(!isOrderAlive(order.getStatus())){
            return null;
        }

        //创建时间对象
        Date now = new Date();
        //封装数据
        order.setStatus(5);
        order.setModified_Time(now);
        orderRepository.updateOrderById(order);

        //获取接单人用户信息
        WxAccount accepter = wxAccountService.getWxAccountByOpenId( order.getAccepter_Id());

        return createNotification(  order.getAccepter_Id() ,order.getCreater_Id(),accepter.getNick_Name() + "取消了你的订单");

    }

    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    @Override
    public boolean deleteOrder(Integer orderId) {
        //查出对应订单信息
        Order order=orderRepository.findOrderById(orderId);

        //判断该订单数据是否存在
        if(order == null){
            return false;
        }

        //判断订单状态是否合法
        if(!isOrderAlive(order.getStatus())){
            return false;
        }

        //创建时间对象
        Date now = new Date();
        //封装数据
        order.setStatus(6);
        order.setModified_Time(now);
        int row = orderRepository.updateOrderById(order);


        return row == 1 ? true : false ;

    }

    /**
     * 根据订单类型查找订单按照指定字段排序（时间、奖励积分）
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public Order[] getOrderByCatalogAndOrderBy(int page, int size) {
        return orderRepository.findOrderByStatus0(page,size);
    }

    /**
     * 根据订单名称模糊查询
     *
     * @param title
     * @param page
     * @param size
     * @return
     */
    @Override
    public Order[] getOrderByTitle(String title, int page, int size) {
        return orderRepository.findOrderByTitle("%"+title+"%",page,size);
    }

    /**
     * 根据放单人ID和接单人ID以及订单状态查找订单
     *
     * @param id
     * @param status
     * @param page
     * @param size
     * @return
     */
    @Override
    public Order[] getOrderByCreaterOrAccepterId(String id, int status, int page, int size) {
        return orderRepository.findOrderByCreaterIdOrAccepterIdAndStatus(id,status,page,size);
    }

    /**
     * 根据放单人ID和接单人ID查找全部订单
     *
     * @param id
     * @param page
     * @param size
     * @return
     */
    @Override
    public Order[] getOrderByCreaterOrAccepterId(String id, int page, int size) {
        return orderRepository.findOrderByCreaterIdOrAccepterId(id,page,size);
    }

    /**
     * 根据订单Id查找订单
     *
     * @param id
     * @return 订单数据
     */
    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findOrderById(id);
    }

    /**
     * 判断订单是否还可以合法修改订单状态
     * @param status
     * @return
     */
    private boolean isOrderAlive (int status){
        if(status == 6 && status == 5 && status == 4 && status == 3){
            return  false;
        }

        return true;
    }

    /**
     * 创建通知数据
     * @param fromopenid
     * @param toopenid
     * @param msg
     * @return
     */
    private Notification createNotification(String fromopenid , String toopenid, String msg){
        String title = "订单消息";
        //插入通知数据，并获得通知数据
        Notification notification = notificationService.insertNotification(fromopenid, toopenid, title, msg);
        //返回通知数据
        return notification;
    }

}
