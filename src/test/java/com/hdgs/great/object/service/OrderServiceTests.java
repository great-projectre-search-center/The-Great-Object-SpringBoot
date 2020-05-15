package com.hdgs.great.object.service;


import com.hdgs.great.object.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class OrderServiceTests {
    @Autowired
    OrderService orderService;

    @Test
    public void createOrder() {
        Order order = new Order(1L, "kuaidi", "快递", "111", "juxing", "132303015643", 1.1, 1.1, 1.1, 1.1, "111111", new Date(), new Date(), "", "", 100, "备注", 123, 123, 0, "juxing", new Date(), "juxing", new Date());
        orderService.createOrder(order);
    }

    @Test
    public void receivedOrder() {
        orderService.receivedOrder(1L);
    }

    @Test
    public void getOrderByCreaterOrAccepterId() {
//        orderService.getOrderByCreaterOrAccepterId()
    }

    @Test
    public void getOrderByCreaterOraccepterId2() {

    }

    @Test
    public void getOrderByCatalogAndOrderBy() {

    }

    @Test
    public void acceptOrder() {

    }

    @Test
    public void cancelOrder(){

    }

    @Test
    public void commentOrder(){

    }
    @Test
    public void deleteOrder(){

    }
    @Test
    public void deliveringOrder(){

    }
    @Test
    public void getOrderById(){

    }




}

