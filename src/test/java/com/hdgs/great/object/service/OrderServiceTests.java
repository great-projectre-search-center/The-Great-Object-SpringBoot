package com.hdgs.great.object.service;


import com.hdgs.great.object.domain.Notification;
import com.hdgs.great.object.domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTests {

    @Autowired
    OrderService orderService;

    //成功
    @Test
    public void createOrder() {
        Order order = new Order();
        order.setCatalog("恶心的订单");
        orderService.createOrder(order);
    }

    //成功
    @Test
    public void receivedOrder() {
        orderService.receivedOrder(45776318);
    }
    /*
    //成功
    @Test
    public void getOrderByCreaterOrAccepterId() {
        String accepterId="0000111111";
        Integer status = 0;
        int page = 1;
        int size = 2;
        Order[] data = orderService.getOrderByCreaterOrAccepterId(accepterId,status,page, size);
        for (int i = 0 ;i<data.length ;i++){
            System.out.println("数据: "+ data[i]);
        }
    }

    //忽略
    @Test
    public void getOrderByCreaterOraccepterId2() {

    }

    //成功
    @Test
    public void getOrderByCatalogAndOrderBy() {
        String catalog = "快递";
        String orderBy = "create_Date";
        int page = 2;
        int size = 2;
        Order [] orders=orderService.getOrderByCatalogAndOrderBy(2,10);
        System.out.println(orders.toString());
    }

    //成功
    @Test
    public void getOrderByTitle() {
        String title = "kuaidi";
        int page = 2;
        int size = 2;
        Order[] data = orderService.getOrderByTitle(title, page, size);
        System.out.println("长度:"+data.length);
        for (int i = 0 ;i<data.length ;i++){
            System.out.println("数据: "+ data[i]);
        }
    }
    */
    //成功
    @Test
    public void acceptOrder() {
        orderService.acceptOrder( 45776318,"oV9m45b5S1RGPf6gTCXu3a5dAgF4");
    }

    //成功
    @Test
    public void cancelOrder(){
        Notification notification = orderService.cancelOrder(45776318);
        System.out.println(notification);
    }

    //成功
    @Test
    public void deleteOrder(){
       orderService.deleteOrder(45776318);
    }

    //成功
    @Test
    public void deliveringOrder(){
       orderService.deliveringOrder(45776318);
    }


    //成功
    @Test
    public void getOrderById(){

    }






}

