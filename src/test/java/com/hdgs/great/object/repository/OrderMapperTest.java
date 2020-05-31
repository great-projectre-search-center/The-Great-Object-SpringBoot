package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jingfeng999
 * @create 2020-05-17 12:50
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {

    @Autowired
    OrderRepository orderRepository;

    //成功
    @Test
    public void insertOrder(){
        Order data = new Order();
        data.setCatalog("测试订单");
        Integer rows = orderRepository.insertOrder(data);
        System.out.println("rows="+rows);
    }
}
