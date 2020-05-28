package com.hdgs.great.object.service;


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
        Order order = new Order(1L, "kuaidi", "快递", "111", "juxing", "132303015643", 1.1, 1.1, 1.1, 1.1, "111111", new Date(), new Date(), "", "", 100, "备注", 123, 123, 0, "juxing", new Date(), "juxing", new Date());
        orderService.createOrder(order);
    }

    //成功
    @Test
    public void receivedOrder() {
        orderService.receivedOrder(15896927030265915L);
    }

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

    //成功
    @Test
    public void acceptOrder() {
        boolean flag = orderService.acceptOrder(0L,"999");
        System.out.println("成功否?"+flag);
    }

    //成功
    @Test
    public void cancelOrder(){
        boolean flag = orderService.cancelOrder(2L);
        System.out.println("成功否?"+flag);
    }

    //成功
    @Test
    public void deleteOrder(){
        boolean flag = orderService.deleteOrder(2L);
        System.out.println("成功否?"+flag);
    }

    //成功
    @Test
    public void deliveringOrder(){
        boolean flag = orderService.deliveringOrder(2L);
        System.out.println("成功否?"+flag);
    }


    //成功
    @Test
    public void getOrderById(){

    }


    //成功
    @Test
    public void commentOrder(){
        boolean flag = orderService.commentOrder(1L,10);
        System.out.println("成功否?"+flag);
    }




}

