package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.Address;

import java.util.List;

/**
 * 处理收获地址的持久层接口
 * @author jingfeng999
 */
public interface AddressRepository {

    /**
     * 插入新的收获地址数据
     * @param address 收获地址数据对象对象
     * @return 受影响的行数
     */
    Integer insert(Address address);

    /**
     * 根据收货地址id删除收货地址数据
     * @param aid 收货地址的id
     * @return 受影响的行数
     */
    Integer deleteByAid(Integer aid);

    /**
     * 根据用户id查询某用户的收获地址数量
     * @param uid 用户id
     * @return 该用户收获地址的数量
     */
    Integer countByUid(Integer uid);

    /**
     * 根据用户id查询该用户的所有收货地址数据
     * @param uid 用户id
     * @return 返回所有的收货地址数据的集合
     */
    List<Address> findByUid(Integer uid);

    /**
     * 根据收货地址id修改收货地址数据
     * @param address 新的收货地址数据，封装了aid
     * @return 受影响的行数
     */
    Integer updateByAid(Address address);


    /**
     * 根据收货地址id查该收货地址所归属的用户数据
     * @param aid 收货地址的id
     * @return 该收货地址归属的数据，例如uid,如果没有匹配的数据，则返回null
     */
    Address findByAid(Integer aid);
}
