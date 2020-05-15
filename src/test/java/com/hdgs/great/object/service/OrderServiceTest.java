package com.hdgs.great.object.service;


import com.hdgs.great.object.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    OrderService orderService;

    @Test
    public void create() {
        Order order = new Order(1L, "kuaidi", "快递", "111", "juxing", "132303015643", 1.1, 1.1, 1.1, 1.1, "111111", new Date(), new Date(), "", "", 100, "备注", 123, 123, 0, "juxing", new Date(), "juxing", new Date());
        orderService.createOrder(order);
    }


}

