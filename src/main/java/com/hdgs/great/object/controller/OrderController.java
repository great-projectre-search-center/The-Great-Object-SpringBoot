package com.hdgs.great.object.controller;


import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.Notification;
import com.hdgs.great.object.domain.Order;
import com.hdgs.great.object.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 创建或修改订单
     *
     * @param order
     * @return
     */
    /*
    JSON格式样例
    {
        "order_Id":"",
        "order_Catalog":"",
        "order_Title":"",
        "order_CreateDate":"",
        "order_AcceptDate":"",
        "order_CreaterId":"",
        "order_AccepterId":"",
        "order_PublicField1":"",
        "order_PublicField2":"",
        "order_EstimateWorth":"",
        "order_Creater":"",
        "order_CreaterTel":"",
        "order_CreaterLocation":"",
        "order_ShopsLocation":"",
        "order_Remark":"",
        "order_Comment":"",
        "order_Reward":"",
        "order_Status":"",
    }
     */
    @PostMapping("/edit")
    public JSONObject create(@RequestBody Order order) {
        boolean result;
        JSONObject responseJSON = new JSONObject();

        //判断是修改还是新增
        result = order.getOid() != null ? orderService.updateOrderInfo(order) : orderService.createOrder(order);

        responseJSON.put("isOK", result);
        return responseJSON;
    }

    /**
     * 删除订单
     * @param jsonObject
     * @return
     */
    @DeleteMapping("/delete")
    public JSONObject delete(@RequestBody JSONObject jsonObject) {
        Integer orderId=Integer.parseInt(jsonObject.getString("id"));
        //执行删除
        boolean result = orderService.deleteOrder(orderId);
        //响应
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("isOK", result);
        return responseJSON;
    }

    /**
     * 根据id查询订单信息
     *
     * @param id 订单id
     * @return 返回订单json数据
     */
    @GetMapping("/list/{id}")
    public Order getMappingById(@PathVariable("id") Integer id) {
        //执行查询
        Order data = orderService.getOrderById(id);
        return data;
    }


    /**
     * 分页查询全部未接受订单信息
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/list_status0")
    public Order[] getMappingByCatalog(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") int pageIndex,
                                       @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        //执行查询
        Order[] data = orderService.getOrderByCatalogAndOrderBy(pageIndex, pageSize);
        int a=5;
        return data;
    }

    /**
     * 根据订单状态和id分页查询全部订单信息
     *
     * @param id
     * @param status
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/list_idstatus")
    public Order[] getMappingByIdAndStatus(@RequestParam(value = "id") String id,
                                           @RequestParam(value = "status") int status,
                                           @RequestParam(value = "pageIndex", required = false, defaultValue = "1") int pageIndex,
                                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        //执行查询
        Order[] data = orderService.getOrderByCreaterOrAccepterId(id, status, pageIndex, pageSize);
        return data;
    }

    /**
     * 根据id分页查询全部订单信息
     *
     * @param id
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/list_status")
    public Order[] getMappingById(@RequestParam(value = "id") String id,
                                  @RequestParam(value = "pageIndex", required = false, defaultValue = "1") int pageIndex,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        //执行查询
        Order[] data = orderService.getOrderByCreaterOrAccepterId(id, pageIndex, pageSize);
        return data;
    }


    /**
     * 修改状态为已接单
     * @param jsonObject
     * @return
     */
    @PostMapping("/accept")
    public JSONObject accept(@RequestBody JSONObject jsonObject) {
        Integer oorderId=Integer.parseInt(jsonObject.getString("orderId"));
        Notification notification = orderService.acceptOrder(oorderId, jsonObject.getString("accepterId"));
        //响应
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("isOK", notification);
        return responseJSON;
    }

    /**
     * 修改状态为送货中
     *
     * @param jsonObject
     * @return
     */
    @PostMapping("/deliver")
    public JSONObject deliver(@RequestBody JSONObject jsonObject) {
        Integer oorderId=Integer.parseInt(jsonObject.getString("orderId"));
        Notification result = orderService.deliveringOrder(oorderId);
        //响应
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("isOK", result);
        return responseJSON;
    }

    /**
     * 修改状态为已接收
     * @param jsonObject
     * @return
     */
    @PostMapping("/receive")
    public JSONObject receive(@RequestBody JSONObject jsonObject) {
        Integer orderId=Integer.parseInt(jsonObject.getString("id"));
        Notification result = orderService.receivedOrder(orderId);
        //响应
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("isOK", result);
        return responseJSON;
    }

    /**
     * 取消订单
     * @param jsonObject
     * @return
     */
    @PostMapping("/cancel")
    public JSONObject cancel(@RequestBody JSONObject jsonObject) {
        Integer orderId=Integer.parseInt(jsonObject.getString("id"));
        Notification result = orderService.cancelOrder(orderId);
        //响应
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("isOK", result);
        return responseJSON;
    }

    /**
     * 根据名称模糊查询-
     *
     * @param title
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/search")
    public Order[] search(@RequestParam(value = "title") String title,
                          @RequestParam(value = "pageIndex", required = false, defaultValue = "1") int pageIndex,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Order[] data = orderService.getOrderByTitle(title, pageIndex, pageSize);
        return data;
    }


}

