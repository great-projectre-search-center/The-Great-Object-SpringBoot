package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Order;
import com.hdgs.great.object.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

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
        Long id=now.getTime();
        id=id*10000+ (int)(Math.random()*10000);

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
        Date now = new Date();
        order.setCreate_Date(now);
        order.setModified_Time(now);
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
    public boolean acceptOrder(Long orderId, String accepterId) {
        Order order=orderRepository.findOrderById(orderId);
        Date now = new Date();
        order.setAccept_Date(now);
        order.setAccepter_Id(accepterId);
        order.setStatus(1);
        order.setModified_Time(now);
        int updateNum=orderRepository.updateOrderById(order);
        return updateNum>0?true:false;
    }

    /**
     * 修改状态为送货中
     *
     * @param orderId
     * @return
     */
    @Override
    public boolean deliveringOrder(Long orderId) {
        Date now = new Date();

        Order order=orderRepository.findOrderById(orderId);

        order.setStatus(2);

        order.setModified_Time(now);
        int updateNum=orderRepository.updateOrderById(order);

        return updateNum>0?true:false;
    }

    /**
     * 修改状态为已接收
     *
     * @param orderId
     * @return
     */
    @Override
    public boolean receivedOrder(Long orderId) {
        Date now = new Date();
        Order order=orderRepository.findOrderById(orderId);
        order.setStatus(3);
        order.setModified_Time(now);
        int updateNum=orderRepository.updateOrderById(order);
        return updateNum>0?true:false;
    }

    /**
     * 评价订单
     *
     * @param orderId
     * @param aid 评价id
     * @return
     */
    @Override
    public boolean commentOrder(Long orderId, Integer aid) {
        Date now = new Date();
        Order order=orderRepository.findOrderById(orderId);
        order.setAid(aid);
        order.setStatus(4);
        order.setModified_Time(now);
        int updateNum=orderRepository.updateOrderById(order);
        return updateNum>0?true:false;
    }

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @Override
    public boolean cancelOrder(Long orderId) {
        Date now = new Date();
        Order order=orderRepository.findOrderById(orderId);
        order.setStatus(5);
        order.setModified_Time(now);
        int updateNum=orderRepository.updateOrderById(order);
        return updateNum>0?true:false;
    }

    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    @Override
    public boolean deleteOrder(Long orderId) {
        Date now = new Date();
        Order order=orderRepository.findOrderById(orderId);
        order.setStatus(6);
        order.setModified_Time(now);
        int updateNum=orderRepository.updateOrderById(order);
        return updateNum>0?true:false;
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
    public Order getOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }

}
