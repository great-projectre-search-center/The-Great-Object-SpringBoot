package com.hdgs.great.object.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.Catalog;
import com.hdgs.great.object.domain.Order;
import com.hdgs.great.object.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author jingfeng999
 * @create 2020-03-29 16:52
 * 订单控制器
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 创建或修改订单
     *
     * @param jsonObject
     * @return
     */
    @PostMapping("/edit")
    public JSONObject create(@RequestBody JSONObject jsonObject) {
        Integer id = jsonObject.getInteger("id");
        String user = jsonObject.getString("user");
        String title = jsonObject.getString("title");
        String content = jsonObject.getString("content");
        String catalog = jsonObject.getString("catalog");
        double longitude = jsonObject.getDouble("longitude");
        double latitude= jsonObject.getDouble("latitude");
        int reward= jsonObject.getInteger("reward");
        JSONObject responseJSON = new JSONObject();
        boolean result;
        Order order = new Order();
        order.setUser(user);
        order.setTitle(title);
        order.setDate(new Date());
        order.setContent(content);
        order.setCatalog(catalog);
        order.setLongitude(longitude);
        order.setLatitude(latitude);
        order.setReward(reward);
        order.setStatus(0);
        //判断是修改还是新增
        if (id != null) {//修改
            order.setId(id);
            result=orderService.updateOrder(order);
        } else {//新增
           result=orderService.createOrder(order);
        }
        responseJSON.put("isOK", result);
        return responseJSON;
    }

    /**
     * 删除订单
     *
     * @param id 订单id
     * @return json数据
     */
    @RequestMapping("/delete")
    public JSONObject delete(int id) {
        //执行删除
        boolean result=orderService.delete(id);
        //响应
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("isOK", result);
        return responseJSON;
    }

    /**
     * 根据id查询订单信息
     *
     * @param orderid 订单id
     * @return 返回订单json数据
     */
    @RequestMapping("/list/{orderid}")
    public String getMappingById(@PathVariable("orderid") int orderid) {
        //执行查询
        Order data = orderService.getMappingById(orderid);
        //响应
        String jsonOrder = JSON.toJSONString(data);
        return jsonOrder;
    }

    /**
     * 根据订单类型分页查询全部订单信息
     *
     * @param catalog 订单类型
     * @param page    页数
     * @param size    大小
     * @return Order数据总体信息-json
     */
    @RequestMapping("/list_catalog")
    public String getMappingByCatalog(Catalog catalog, int page, int size) {
        //执行查询
        Page<Order> data = orderService.getMappingByCatalog(catalog, page, size);
        //响应
        String jsonOrder = JSON.toJSONString(data);
        return jsonOrder;
    }

    /**
     * 根据订单状态分页查询全部订单信息
     *
     * @param status 订单类型
     * @param page   页数
     * @param size   大小
     * @return Order数据总体信息-json
     */
    @RequestMapping("/list_status")
    public String getMappingByStatus(int status, int page, int size) {
        //执行查询
        Page<Order> data = orderService.getMappingByStatus(status, page, size);
        //响应
        String jsonOrder = JSON.toJSONString(data);
        return jsonOrder;
    }

}

