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
        return false;
    }

    /**
     * 修改订单信息
     *
     * @param order
     * @return
     */
    @Override
    public boolean updateOrderInfo(Order order) {
        return false;
    }

    /**
     * 修改状态为接单
     *
     * @param orderId
     * @param acctpterId
     * @return
     */
    @Override
    public boolean acceptOrder(Long orderId, String acctpterId) {
        return false;
    }

    /**
     * 修改状态为送货中
     *
     * @param orderId
     * @return
     */
    @Override
    public boolean deliveringOrder(Long orderId) {
        return false;
    }

    /**
     * 修改状态为已接收
     *
     * @param orderId
     * @return
     */
    @Override
    public boolean receivedOrder(Long orderId) {
        return false;
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
        return false;
    }

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @Override
    public boolean cancelOrder(Long orderId) {
        return false;
    }

    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    @Override
    public boolean deleteOrder(Long orderId) {
        return false;
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
        return null;
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
        return null;
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
        return null;
    }

    /**
     * 根据订单Id查找订单
     *
     * @param id
     * @return 订单数据
     */
    @Override
    public Order getOrderById(Long id) {
        return null;
    }



    /*

    @Override
    public boolean createOrder(Order order) {
        //创建当前时间对象，封装Order属性
        Date now = new Date();
        order.setDate(now);
        //订单在最初创建时默认是未接单状态
        order.setStatus(0);
        int insertNum=orderRepository.insertOrder(order);
        if(insertNum>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        int delNum=orderRepository.deleteOrderById(id);
        if (delNum>0){
            return true;
        }
        return false;
    }

    @Override
    public Order getMappingById(int id) {
        Order data = orderRepository.findOrderById(id);
        return data;
    }

    @Override
    public Page<Order> getMappingByCatalog(Catalog catalog,int page ,int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Order> data = orderRepository.findOrderByCatalog(catalog ,pageable);
        return data;
    }

    @Override
    public Page<Order> getMappingByStatus(int status,int page ,int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Order> data = orderRepository.findOrderByStatus(status,pageable);
        return data;
    }

 */
}
