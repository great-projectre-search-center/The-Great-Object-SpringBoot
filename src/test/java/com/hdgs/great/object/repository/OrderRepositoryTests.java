package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author jingfeng999
 * @create 2020-03-29 21:15
 */
@SpringBootTest
public class OrderRepositoryTests {

    @Autowired
    OrderRepository repository;

    @Test
    public void insert(){
        Order order = new Order();
        order.setDate(new Date());
        int rows=repository.insertOrder(order);
        System.out.println("rows="+rows);
    }
}
