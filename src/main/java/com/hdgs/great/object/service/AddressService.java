package com.hdgs.great.object.service;

import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.Address;

import java.util.List;

/**
 * 处理收货地址的业务层接口
 *
 * @author jingfeng999
 */
public interface AddressService {

    int ADDRESS_MAX_COUNT = 20;   //最大收货地址数量

    /**
     * 增加新的收货地址
     *
     * @param address  收获地址数据对象
     * @param uid      用户id
     * @param username 用户名
     */
    JSONObject addNew(Address address, String uid, String username);

    /**
     * 根据收货地址id删除对应数据
     *
     * @param aid      收货地址id
     * @param uid      当前登录的用户id
     * @param username 当前登录的用户名
     */
    boolean deleteByAid(Integer aid, String uid, String username);

    /**
     * 根据用户id查询该用户的所有收货地址数据
     *
     * @param uid 用户id
     * @return 返回所有的收货地址数据的集合
     */
    List<Address> getByUid(String uid);

    /**
     * 根据收货地址id修改对应数据
     *
     * @param aid      收货地址id
     * @param uid      当前登录的用户id
     * @param username 当前登录的用户名
     */
    boolean update(Integer aid, String uid, String username, Address address);
}
