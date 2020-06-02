package com.hdgs.great.object.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.Address;
import com.hdgs.great.object.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
     * @param jsonObject
     * @return
     */
    //本地测试成功
    @PostMapping("/addNew")
    public JSONObject addNew(@RequestBody JSONObject jsonObject) {
//@RequestParam(value = "address") Address address,
// @RequestParam(value = "uid") Integer uid,
// @RequestParam(value = "username") String username
        Integer aid = jsonObject.getInteger("aid");    //收货地址id
        String uid = jsonObject.getString("uid");    //用户id
        String username = jsonObject.getString("username"); //用户username
        String name=jsonObject.getString("name");    //收获人姓名
        String phone=jsonObject.getString("phone");   //手机号码
        String province_Name=jsonObject.getString("province_Name");    //省名称
        String city_Name=jsonObject.getString("city_Name");    //市名称
        String area_Name=jsonObject.getString("area_Name");    //区名称
        String address=jsonObject.getString("address");     //详细收货地址

        Address aaddress = new Address(aid,uid,name,phone,province_Name,city_Name,area_Name,address,null,null,null,null,null);
        // 调用业务层执行添加
        JSONObject responseObject = addressService.addNew(aaddress, uid, username);
        return responseObject;
    }

    /**
     * 删除地址
     * @param aid
     * @param jsonObject
     * @return
     */
    //本地测试成功
    @DeleteMapping("/{aid}/delete")
    public JSONObject delete(@PathVariable("aid") Integer aid, @RequestBody JSONObject jsonObject) {
        String uid=jsonObject.getString("uid");
        String username=jsonObject.getString("username");
//        @RequestParam("uid") Integer uid,
//        @RequestParam("username") String username
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
    @GetMapping
    public List<Address> getByUid(@RequestParam(value = "uid") String uid) {

        // 调用业务层获取收获地址数据集合
        List<Address> data = addressService.getByUid(uid);

        return data;
    }

    /**
     * 更新地址信息
     * @param aid
     * @param jsonObject
     * @return
     */
    //本地测试成功
    @RequestMapping("{aid}/update")
    public String update(@PathVariable("aid") Integer aid,@RequestBody JSONObject jsonObject){

        String uid = jsonObject.getString("uid");    //用户id
        String username = jsonObject.getString("username"); //用户username
        String name=jsonObject.getString("name");    //收获人姓名
        String phone=jsonObject.getString("phone");   //手机号码
        String province_Name=jsonObject.getString("province_Name");    //省名称
        String city_Name=jsonObject.getString("city_Name");    //市名称
        String area_Name=jsonObject.getString("area_Name");    //区名称
        String address=jsonObject.getString("address");     //详细收货地址

        Address aaddress = new Address(aid,uid,name,phone,province_Name,city_Name,area_Name,address,null,null,null,null,null);
        //调用业务层执行修改
        addressService.update(aid, uid, username, aaddress);

        //响应
        return "ok";
    }

}
