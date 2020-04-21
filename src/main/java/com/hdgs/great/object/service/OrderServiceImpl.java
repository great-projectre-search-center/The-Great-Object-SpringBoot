package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Catalog;
import com.hdgs.great.object.domain.Order;
import com.hdgs.great.object.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        order.setOrder_CreateDate(now);
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
        order.setOrder_CreateDate(now);
        int updateNum=orderRepository.updateOrder(order);
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
        Date now = new Date();
        int updateNum=orderRepository.updateOrderStatus(orderId,1,"order_accepterid",accepterId,"order_acceptdate",now.toString());
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
        int updateNum=orderRepository.updateOrderStatus(orderId,2);
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
        int updateNum=orderRepository.updateOrderStatus(orderId,3);
        return updateNum>0?true:false;
    }

    /**
     * 评价订单
     *
     * @param orderId
     * @param comment
     * @return
     */
    @Override
    public boolean commentOrder(Long orderId, String comment) {
        int updateNum=orderRepository.updateOrderStatus(orderId,4,"order_comment",comment);
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
        int updateNum=orderRepository.updateOrderStatus(orderId,5);
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
        int updateNum=orderRepository.updateOrderStatus(orderId,6);
        return updateNum>0?true:false;
    }

    /**
     * 根据订单类型查找订单按照指定字段排序（时间、奖励积分）
     *
     * @param catalog
     * @param orderBy
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Order> getOrderByCatalogAndOrderBy(String catalog, String orderBy, int page, int size) {
        return orderRepository.findOrderByCatalog(catalog,orderBy,page,size);
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
    public Page<Order> getOrderByTitle(String title, int page, int size) {
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
    public Page<Order> getOrderByCreaterOrAccepterId(String id, int status, int page, int size) {
        return orderRepository.findOrderByCreaterIdOrAccepterIdAndStatus(id,status,page,size);
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
