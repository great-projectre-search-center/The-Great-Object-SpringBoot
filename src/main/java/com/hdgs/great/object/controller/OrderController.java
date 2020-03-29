package com.hdgs.great.object.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.Catalog;
import com.hdgs.great.object.domain.Order;
import com.hdgs.great.object.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 创建订单
     * @param order 客户端提交的订单信息数据
     */
    @RequestMapping("/edit")
    public JSONObject create(Order order){
        //执行添加
        orderService.create(order);
        //响应
        JSONObject json = new JSONObject();
        json.put("status","OK");
        return json;
    }

    /**
     * 删除订单
     * @param id 订单id
     * @return json数据
     */
    @RequestMapping("/delete")
    public JSONObject delete(int id){
        //执行删除
        orderService.delete(id);
        //响应
        JSONObject json = new JSONObject();
        json.put("status","OK");
        return json;
    }

    /**
     * 根据id查询订单信息
     * @param orderid 订单id
     * @return 返回订单json数据
     */
    @RequestMapping("/list/{orderid}")
    public String getMappingById(@PathVariable("orderid") int orderid){
        //执行查询
        Order data = orderService.getMappingById(orderid);
        //响应
        String jsonOrder = JSON.toJSONString(data);
        return jsonOrder;
    }

    /**
     * 根据订单类型分页查询全部订单信息
     * @param catalog 订单类型
     * @param page 页数
     * @param size 大小
     * @return Order数据总体信息-json
     */
    @RequestMapping("/list_catalog")
    public String getMappingByCatalog(Catalog catalog, int page ,int size){
        //执行查询
        Page<Order> data = orderService.getMappingByCatalog(catalog, page, size);
        //响应
        String jsonOrder = JSON.toJSONString(data);
        return jsonOrder;
    }

    /**
     * 根据订单状态分页查询全部订单信息
     * @param status 订单类型
     * @param page 页数
     * @param size 大小
     * @return Order数据总体信息-json
     */
    @RequestMapping("/list_status")
    public String getMappingByStatus(int status, int page ,int size){
        //执行查询
        Page<Order> data = orderService.getMappingByStatus(status, page, size);
        //响应
        String jsonOrder = JSON.toJSONString(data);
        return jsonOrder;
    }

}
