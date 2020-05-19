package com.hdgs.great.object.service;


import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.Address;
import com.hdgs.great.object.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author jingfeng999
 */

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public JSONObject addNew(Address address, Integer uid, String username) {
        //根据参数uid查询该用户的收货地址数量
        Integer count = addressRepository.countByUid(uid);
        JSONObject responseJSON = new JSONObject();
        //判断是否超过上限
        if (count >= ADDRESS_MAX_COUNT) {
            responseJSON.put("isOk", "超过收货地址数量上限");
            return responseJSON;
        }
        //补全数据
        //封装uid
        address.setUid(uid);
        //创建当前时间对象
        Date now = new Date();
        address.setCreated_User(username);
        address.setCreated_Time(now);
        address.setModified_User(username);
        address.setModified_Time(now);
        count = addressRepository.insert(address);
        if (count > 0) {
            responseJSON.put("isOk", true);
            return responseJSON;
        }
        responseJSON.put("isOk", "添加地址失败");
        return responseJSON;
    }

    @Override
    @Transactional
    public boolean deleteByAid(Integer aid, Integer uid, String username) {
        //执行删除
        return addressRepository.deleteByAid(aid) > 0 ? true : false;
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        return addressRepository.findByUid(uid);
    }

    @Override
    public boolean update(Integer aid, Integer uid, String username, Address address) {
        //封装地址id
        address.setAid(aid);
        //创建当前时间对象,更新日志
        Date now = new Date();
        address.setModified_User(username);
        address.setModified_Time(now);
        //执行修改
        return addressRepository.updateByAid(address) > 0 ? true : false;

    }

}
