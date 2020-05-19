package com.hdgs.great.object.controller;

import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.Address;
import com.hdgs.great.object.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author jingfeng999
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    /**
     * 添加新的地址
     *
     * @param address
     * @param uid
     * @param username
     * @return
     */
    //本地测试成功
    @PostMapping("/addNew")
    public JSONObject addNew(@RequestParam(value = "address") Address address, @RequestParam(value = "uid") Integer uid, @RequestParam(value = "username") String username) {

        // 调用业务层执行添加
        JSONObject responseObject =addressService.addNew(address, uid, username);
        return responseObject;
    }

    /**
     * 删除地址
     *
     * @param aid
     * @param uid
     * @param username
     * @return
     */
    //本地测试成功
    @DeleteMapping("/{aid}/delete")
    public JSONObject delete(@PathVariable("aid") Integer aid, @RequestParam("uid") Integer uid, @RequestParam("username") String username) {

        //调用业务层执行删除
        addressService.deleteByAid(aid, uid, username);
        JSONObject responseObject = new JSONObject();
        responseObject.put("isOk", true);
        return responseObject;
    }

    /**
     * 获取全部地址页面
     *
     * @param uid
     * @return
     */
    //本地测试成功
    @GetMapping("/")
    public List<Address> getByUid(@RequestParam(value = "uid") Integer uid) {

        // 调用业务层获取收获地址数据集合
        List<Address> data = addressService.getByUid(uid);

        return data;
    }

    /**
     * 更新地址信息
     *
     * @param aid
     * @param uid
     * @param username
     * @param address
     * @return
     */
    //本地测试成功
    @RequestMapping("{aid}/update")
    public String update(@PathVariable("aid") Integer aid,
                         @RequestParam(value = "uid") Integer uid,
                         @RequestParam(value = "username") String username,
                         @RequestParam(value = "address") Address address) {

        //调用业务层执行修改
        addressService.update(aid, uid, username, address);

        //响应
        return "ok";
    }

}
