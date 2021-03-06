package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Notification;
import com.hdgs.great.object.domain.Order;

public interface OrderService {

    //测试成功
    /**
     * 创建订单
     *
     * @param order 订单数据
     */
    boolean createOrder(Order order);

    //测试成功
    /**
     * 修改订单信息
     *
     * @param order
     * @return
     */
    boolean updateOrderInfo(Order order);

    //测试成功
    /**
     * 修改状态为接单
     *
     * @param orderId
     * @param accepterId
     * @return
     */
    Notification acceptOrder(Integer orderId, String accepterId);

    //测试成功
    /**
     * 修改状态为送货中
     *
     * @param orderId
     * @return
     */
    Notification deliveringOrder(Integer orderId);

    //测试成功
    /**
     * 修改状态为已接收
     *
     * @param orderId
     * @return
     */
    Notification receivedOrder(Integer orderId);

    //测试成功
    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    Notification cancelOrder(Integer orderId);

    //测试成功
    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    boolean deleteOrder(Integer orderId);

    //测试成功

    /**
     * 根据订单类型查找订单按照指定字段排序（时间、奖励积分）
     * @param page
     * @param size
     * @return
     */
    Order[] getOrderByCatalogAndOrderBy(String openId,int page, int size);

    /**
     * 根据订单名称模糊查询
     *
     * @param title
     * @return
     */
    Order[] getOrderByTitle(String title, int page, int size);

    //测试成功
    /**
     * 根据放单人ID和接单人ID以及订单状态查找订单
     *
     * @param id
     * @return
     */
    Order[] getOrderByCreaterOrAccepterId(String id, int status, int page, int size);

    //测试成功
    /**
     * 根据放单人ID和接单人ID查找全部订单
     * @param id
     * @param page
     * @param size
     * @return
     */
    Order[] getOrderByCreaterOrAccepterId(String id, int page, int size);

    //测试成功
    /**
     * 根据订单Id查找订单
     *
     * @param id
     * @return 订单数据
     */
    Order getOrderById(Integer id);


}
