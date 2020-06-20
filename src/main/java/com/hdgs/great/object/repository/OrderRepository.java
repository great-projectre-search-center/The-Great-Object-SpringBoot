package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;


@Mapper
public interface OrderRepository {
    /**
     * 插入新的订单数据
     * @param order 订单对象数据
     * @return 数据库中受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 根据订单id修改订单数据
     * @param order 订单对象数据
     * @return 数据库中受影响的行数
     */
    Integer updateOrderById(Order order);




//order_id,order_catalog,order_title,order_createdate,order_acceptdate,order_createrid,order_acctpterid,order_publicfield1,order_publicfield2,order_estimateworth,order_creater,order_creatertel,order_createrlongitude,order_createrlatitude,order_shopslongtitude,order_shopslatitude,order_remark,order_comment,order_reward,order_status
//#{order_Id},#{order_Catalog},#{order_Title},#{order_CreateDate},#{order_AcceptDate},#{order_CreaterId},#{order_AccepterId},#{order_PublicField1},#{order_PublicField2},#{order_EstimateWorth},#{order_Creater},#{order_CreaterTel},#{order_CreaterLocation.longtitude},#{order_CreaterLocation.latitude},#{order_ShopsLocation.longtitude},#{order_ShopsLocation.latitude},#{order_Remark},#{order_Comment},#{order_Reward},#{order_Status}

    /**
     * 根据订单Id查找订单数据
     * @param oid 订单id
     * @return 订单数据
     */
    Order findOrderById(Integer oid);

    /**
     * 分页查询两个时间段之间的订单
     * @param headdate 头时间点
     * @param taildate 尾时间点
     * @param page 分的页数
     * @param size 每页的数量
     * @return 订单数据集合
     */
    Order[] findOrderByCreateDateBetweenAnd(Date headdate, Date taildate, int page , int size);


    /**
     * 根据订单名称模糊查询
     * @param title 订单名称
     * @param page 页数
     * @param size 每页的数量
     * @return 订单数据集合
     */
    Order[] findOrderByTitle(String title,int page,int size);

    /**
     * 根据放单人ID和接单人ID以及订单状态查找订单
     * @param id 放单人id或接单人id
     * @param status 订单状态
     * @param page 页数
     * @param size 每页的数量
     * @return 订单数据集合
     */
    Order[] findOrderByCreaterIdOrAccepterIdAndStatus(String id,int status,int page,int size);


    /**
     * 根据放单人ID和接单人ID查找订单
     * @param id 放单人id或接单人id
     * @param page 页数
     * @param size 每页的数量
     * @return 订单数据集合
     */
    Order[] findOrderByCreaterIdOrAccepterId(String id,int page,int size);

    /**
     * 根据分类分页查找全部订单
     * @param page 页数
     * @param size 每页的数量
     * @return 订单数据集合
     */
    Order[] findOrderByStatus0(String openId,int page,int size);


}


