package com.hdgs.great.object.controller.auth;

import com.hdgs.great.object.domain.Address;
import com.hdgs.great.object.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author jingfeng999
 */
@RestController
@RequestMapping("addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping("addNew")
    public String addNew(Address address, Integer uid, String username) {

        // 调用业务层执行添加
        addressService.addNew(address, uid, username);

        return "ok";
    }

    @RequestMapping("{aid}/delete")
    public String delete(@PathVariable("aid") Integer aid,Integer uid,String username){

        //调用业务层执行删除
        addressService.deleteByAid(aid, uid, username);

        return "ok";
    }

    @GetMapping("/")
    public List<Address> getByUid(Integer uid) {

        // 调用业务层获取收获地址数据集合
        List<Address> data = addressService.getByUid(uid);

        return data;
    }

    @RequestMapping("{aid}/update")
    public  String update(@PathVariable("aid") Integer aid,Integer uid,String username,Address address){

        //调用业务层执行修改
        addressService.update(aid, uid, username, address);

        //响应
        return "ok";
    }

}
