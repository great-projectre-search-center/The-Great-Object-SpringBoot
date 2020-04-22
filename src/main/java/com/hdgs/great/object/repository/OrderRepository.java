package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.Catalog;
import com.hdgs.great.object.domain.Location;
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
    @Insert("insert into `order` (order_id,order_catalog,order_title,order_createdate,order_acceptdate,order_createrid,order_accepterid,order_publicfield1,order_publicfield2,order_estimateworth,order_creater,order_creatertel,order_createrlongtitude,order_createrlatitude,order_shopslongtitude,order_shopslatitude,order_remark,order_comment,order_reward,order_status) values (#{order_Id},#{order_Catalog},#{order_Title},#{order_CreateDate},#{order_AcceptDate},#{order_CreaterId},#{order_AccepterId},#{order_PublicField1},#{order_PublicField2},#{order_EstimateWorth},#{order_Creater},#{order_CreaterTel},#{order_CreaterLocation.longtitude},#{order_CreaterLocation.latitude},#{order_ShopsLocation.longtitude},#{order_ShopsLocation.latitude},#{order_Remark},#{order_Comment},#{order_Reward},#{order_Status})")
    int insertOrder(Order order);

    /**
     * 修改订单
     * @param order 订单对象数据
     * @return 数据库中受影响的行数
     */
    @Insert("update `order` set order_catalog=#{order_Catalog},order_title=#{order_Title},order_createdate=#{order_CreateDate},order_acceptdate=#{order_AcceptDate},order_createrid= #{order_CreaterId},order_accepterid=#{order_AccepterId},order_publicfield1=#{order_PublicField1},order_publicfield2=#{order_PublicField2},order_estimateworth=#{order_EstimateWorth}, order_creater=#{order_Creater},order_creatertel=#{order_CreaterTel},order_createrlongtitude=#{order_CreaterLocation.longtitude},order_createrlatitude=#{order_CreaterLocation.latitude},order_shopslongtitude=#{order_ShopsLocation.longtitude},order_shopslatitude=#{order_ShopsLocation.latitude},order_remark= #{order_Remark},order_comment=#{order_Comment}, order_reward=#{order_Reward}, order_status=#{order_Status} where order_id=#{order_Id}")
    int updateOrder(Order order);




//order_id,order_catalog,order_title,order_createdate,order_acceptdate,order_createrid,order_acctpterid,order_publicfield1,order_publicfield2,order_estimateworth,order_creater,order_creatertel,order_createrlongitude,order_createrlatitude,order_shopslongtitude,order_shopslatitude,order_remark,order_comment,order_reward,order_status
//#{order_Id},#{order_Catalog},#{order_Title},#{order_CreateDate},#{order_AcceptDate},#{order_CreaterId},#{order_AccepterId},#{order_PublicField1},#{order_PublicField2},#{order_EstimateWorth},#{order_Creater},#{order_CreaterTel},#{order_CreaterLocation.longtitude},#{order_CreaterLocation.latitude},#{order_ShopsLocation.longtitude},#{order_ShopsLocation.latitude},#{order_Remark},#{order_Comment},#{order_Reward},#{order_Status}

    /**
     * 根据Id查找订单
     *
     * @param id
     * @return
     */
    @Select("select * from `order` where order_id=#{id}")
    Order findOrderById(Long id);

    /**
     * 分页查询两个时间段之间的订单
     * @param headdate
     * @param taildate
     * @param page
     * @param size
     * @return
     */
    @Select("select * from `order` where order_createdate between #{date1} and #{date2} and order_status=0 order by order_createdate desc limit ${(page-1)*size},${size}")
    Order[] findOrderByCreateDateBetweenAnd(Date headdate, Date taildate, int page , int size);


    /**
     * 根据订单名称模糊查询
     * @param title
     * @param page
     * @param size
     * @return
     */
    @Select("select * from `order` where order_title like #{title} and order_status=0 order by order_createdate desc limit ${(page-1)*size},${size}")
    Order[] findOrderByTitle(String title,int page,int size);

    /**
     * 根据放单人ID和接单人ID以及订单状态查找订单
     * @param id
     * @param status
     * @param page
     * @param size
     * @return
     */
    @Select("select * from `order` where order_createrid=#{id} or order_accepterid=#{id} and order_status=#{status} order by order_createdate desc limit ${(page-1)*size},${size}")
    Order[] findOrderByCreaterIdOrAccepterIdAndStatus(String id,int status,int page,int size);


    /**
     * 根据放单人ID和接单人ID以及订单状态查找订单
     * @param id
     * @param page
     * @param size
     * @return
     */
    @Select("select * from `order` where order_createrid=#{id} or order_accepterid=#{id} order by order_createdate desc limit ${(page-1)*size},${size}")
    Order[] findOrderByCreaterIdOrAccepterId(String id,int page,int size);

    /**
     * 根据分类分页查找全部订单
     * @param catalog
     * @param page
     * @param size
     * @return
     */

    @Select("select * from `order` where order_catalog=#{catalog} and order_status=0 order by #{orderBy} desc limit ${(page-1)*size},${size}")
    Order[] findOrderByCatalog(String catalog,String orderBy,int page,int size);


}
