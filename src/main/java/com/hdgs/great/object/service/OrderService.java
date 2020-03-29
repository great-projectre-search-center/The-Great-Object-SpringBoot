package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Catalog;
import com.hdgs.great.object.domain.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    /**
     * 创建订单
     * @param order 订单数据
     */
    boolean createOrder(Order order);

    /**
     * 修改订单
     * @param order
     * @return
     */
    boolean updateOrder(Order order);

    /**
     * 删除订单
     *
     * @param id 订单id
     */
    void delete(int id);

    /**
     * 订单是否存在
     * @param id
     * @return
     */
   // boolean isExist(int id);

    /**
     * 根据Id查找订单
     *
     * @param id
     * @return 订单数据
     */
    Order getMappingById(int id);

    /**
     * 根据分类分页查找全部订单
     *
     * @param catalog 订单类型
     * @return
     */
    Page<Order> getMappingByCatalog(Catalog catalog,int page ,int size);

    /**
     * 根据订单状态分页查找全部订单
     * @param status
     * @return
     */
    Page<Order> getMappingByStatus(int status,int page ,int size);

}
