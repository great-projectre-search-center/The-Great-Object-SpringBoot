package com.hdgs.great.object.controller;


import com.alibaba.fastjson.JSONObject;
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
     *
     * @param id 订单id
     * @return json数据
     */
    @DeleteMapping("/delete")
    public JSONObject delete(@RequestParam(value = "id") Long id) {
        //执行删除
        boolean result = orderService.deleteOrder(id);
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
    public Order getMappingById(@PathVariable("id") Long id) {
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
     *
     * @param orderId
     * @param accepterId
     * @return
     */
    @PostMapping("/accept")
    public JSONObject accept(@RequestParam(value = "orderId") String orderId,
                             @RequestParam(value = "accepterId") String accepterId) {
        Long oorderId=Long.parseLong(orderId);
        boolean result = orderService.acceptOrder(oorderId, accepterId);
        //响应
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("isOK", result);
        return responseJSON;

    }

    /**
     * 修改状态为送货中
     *
     * @param orderId
     * @return
     */
    @PostMapping("/deliver")
    public JSONObject deliver(@RequestParam(value = "orderId") Long orderId) {
        boolean result = orderService.deliveringOrder(orderId);
        //响应
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("isOK", result);
        return responseJSON;
    }

    /**
     * 修改状态为已接收
     *
     * @param orderId
     * @return
     */
    @PostMapping("/receive")
    public JSONObject receive(@RequestParam(value = "orderId") Long orderId) {
        boolean result = orderService.receivedOrder(orderId);
        //响应
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("isOK", result);
        return responseJSON;
    }

//    /*
//     * 修改状态为已评价
//     * @param orderId
//     * @param comment
//     * @return
//     */
//    @PostMapping("/comment")
//    public JSONObject comment(@RequestParam(value = "orderid")Long orderId,@RequestParam(value = "comment")String comment,Integer aid){
//        boolean result=orderService.commentOrder(orderId,);
//        //响应
//        JSONObject responseJSON = new JSONObject();
//        responseJSON.put("isOK", result);
//        return responseJSON;
//    }

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @PostMapping("/cancel")
    public JSONObject cancel(@RequestParam(value = "orderId") Long orderId) {
        boolean result = orderService.cancelOrder(orderId);
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

