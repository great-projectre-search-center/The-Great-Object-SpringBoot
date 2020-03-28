package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.Catalog;
import com.hdgs.great.object.domain.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Mapper
public interface OrderRepository {

    /**
     * 根据Id查找订单
     *
     * @param id
     * @return
     */
    @Select("select (*) from order where id=#{id}")
    Order findOrderById(int id);


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
     * 增加订单
     *
     * @param user
     * @param title
     * @param content
     * @param catalog
     * @param longitude
     * @param latitude
     * @param reward
     */
    @Insert("insert into order(user,title,content,catalog,longtitude,latitude,reward) values(#{user},#{title},#{content},#{catalog},#{longtitude},#{latitude},#{reward})")
    void insertOrder(String user, String title, String content, String catalog, double longitude, double latitude, int reward);

    /**
     * 删除订单
     *
     * @param id
     */
    @Delete("delete from order where id=#{id}")
    void deleteOrder(int id);
}
