package com.hdgs.great.object.service;


import com.hdgs.great.object.domain.Address;
import com.hdgs.great.object.domain.District;
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

    @Autowired
    private DistrictService districtService;

    @Override
    public void addNew(Address address, Integer uid, String username) {
        //根据参数uid查询该用户的收货地址数量
        Integer count=countByUid(uid);
        //判断是否超过上限
        if(count >= ADDRESS_MAX_COUNT) {
            //TODO
            return;
        }

        //补全数据
        //封装uid
        address.setUid(uid);
        //封装省市区名称
        District province=districtService.getByCode(address.getProvince_Code());
        District city=districtService.getByCode(address.getCity_Code());
        District area=districtService.getByCode(address.getArea_Code());
        if(province==null) {
            address.setProvince_Code(null);
        }else {
            address.setProvince_Name(province.getName());
        }
        if(city==null) {
            address.setCity_Code(null);
        }else {
            address.setCity_Name(city.getName());
        }
        if(area==null) {
            address.setArea_Code(null);
        }else {
            address.setArea_Name(area.getName());
        }

        //创建当前时间对象
        Date now =new Date();
        address.setCreated_User(username);
        address.setCreated_Time(now);
        address.setModified_User(username);
        address.setModified_Time(now);

        insert(address);
    }

    @Override
    @Transactional
    public void deleteByAid(Integer aid, Integer uid, String username) {
        //执行删除
        deleteByAid(aid);

    }

    @Override
    public List<Address> getByUid(Integer uid) {
        return findByUid(uid);
    }

    @Override
    public void update(Integer aid, Integer uid, String username,Address address) {

        //封装地址id
        address.setAid(aid);
        //创建当前时间对象,更新日志
        Date now =new Date();
        address.setModified_User(username);
        address.setModified_Time(now);

        //执行修改
        updateByAid(address);
    }

    /**
     * 插入新的收获地址数据
     * @param address 收获地址数据对象对象
     */
    private void insert(Address address) {
        Integer rows=addressRepository.insert(address);
        if(rows !=1) {
            //TODO
            return;
        }
    }

    /**
     * 根据收货地址id删除收货地址数据
     * @param aid 收货地址的id
     * @return 受影响的行数
     */
    private void deleteByAid(Integer aid){
        Integer rows=addressRepository.deleteByAid(aid);
        if(rows != 1) {
            return;
        }
    }

    /**
     * 根据用户id查询某用户的收获地址数量
     * @param uid 用户id
     * @return 该用户收获地址的数量
     */
    private Integer countByUid(Integer uid) {
        return addressRepository.countByUid(uid);
    }

    /**
     * 根据用户id查询该用户的所有收货地址数据
     * @param uid 用户id
     * @return 返回所有的收货地址数据的集合
     */
    private List<Address> findByUid(Integer uid){
        return addressRepository.findByUid(uid);
    }

    /**
     * 根据收货地址id修改收货地址数据
     * @param aid 收货地址的id
     * @return 受影响的行数
     */
    private void updateByAid(Address address){
        Integer rows=addressRepository.updateByAid(address);
        if(rows !=1) {
            //TODO
            return;
        }
    }
}
