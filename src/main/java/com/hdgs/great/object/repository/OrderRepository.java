package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.Catalog;
import com.hdgs.great.object.domain.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;


@Mapper
public interface OrderRepository {
    /**
     * 创建订单
     * @param order 订单对象数据
     * @return 数据库中受影响的行数
     */
    @Insert("insert into order(date,user,title,content,catalog,longtitude,latitude,reward,status) values(#{date},#{user},#{title},#{content},#{catalog},#{longtitude},#{latitude},#{reward},#{status})")
    int insertOrder(Order order);

    /**
     * 修改订单
     * @param order 订单对象数据
     * @return 数据库中受影响的行数
     */
    @Insert("update order set date=#{date},user=#{user},title=#{title},content=#{content},catalog=#{catalog},longtitude=#{longtitude},latitude=#{latitude},reward=#{reward},status=#{status}  where id=#{id}")
    int updateOrder(Order order);

    /**
     * 根据Id查找订单
     *
     * @param id
     * @return
     */
    @Select("select * from order where id=#{id}")
    Order findOrderById(int id);

    /**
     * 分页查询两个时间段之间的订单
     * @param date1
     * @param date2
     * @return
     */
    @Select("select * from order where order_")
    Page<Order>findOrderByCreateDateBetweenAnd(Date date1, Date date2, int page , int size);

    /**
     * 根据放单人id分页查询订单
     * @param id
     * @return
     */
    Page<Order>findOrderByCreaterId(String id);

    /**
     * 根据接单人id分页查询订单
     * @param id
     * @return
     */
    Page<Order>findOrderByAccepterId(String id);

    /**
     * 根据分类分页查找全部订单
     *
     * @param catalog
     * @param pageable
     * @return
     */
    @Select("select (*) from order where catalog=#{catalog} limit #{limit}")
    Page<Order> findOrderByCatalog(Catalog catalog, Pageable pageable);

    /**
     * 根据订单状态分页查找全部订单
     * @param status
     * @param pageable
     * @return
     */
    @Select("select (*) from order where status=#{status} limit #{limit}")
    Page<Order> findOrderByStatus(int status, Pageable pageable);






    /**
     * 删除订单
     *
     * @param id 订单id
     * @return 数据库中受影响的行数
     */
    @Update("delete from order where id=#{id}")
    int deleteOrderById(int id);
}
