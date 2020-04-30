package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.Location;
import com.hdgs.great.object.domain.Order;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class OrderRepositoryTests {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void insertTest(){
        Date date=new Date();
        Location createrLocation=new Location(116.38,39.90);
        Location shopsLocation=new Location(121.50,31.24);
        Order order=new Order(20200422190801L,"快递02","帮我取快递，急",date,null,"owh1O5ckqseCFh8ZDmT6mpA7zpPQ",null,"京东快递","JDX00562520419",100,"巨星","13230301653",createrLocation,shopsLocation,"谢谢",null,50,0);
        System.out.println(order.toString());
        int n=orderRepository.insertOrder(order);
        System.out.println(n);
        System.out.println("-----------------");
        System.out.println(orderRepository.findOrderById(20200422190800L).toString());

    }

    @Test
    public void updateTest(){
        Date date=new Date();
        Location createrLocation=new Location(116.38,39.90);
        Location shopsLocation=new Location(121.50,31.24);
        Order order=new Order(20200422190800L,"快递","帮我取快递，谢谢老板",date,null,"owh1O5ckqseCFh8ZDmT6mpA7zpPQ",null,"京东快递","JDX00562520419",100,"巨星","13230301653",createrLocation,shopsLocation,"谢谢",null,50,0);
        System.out.println(order.toString());
        int n=orderRepository.updateOrder(order);
        System.out.println(n);
        System.out.println("-----------------");
        System.out.println(orderRepository.findOrderById(20200422190800L).toString());
    }


    @Test
    public void findOrderByCreateDateBetweenAndTest(){
        Date date=new Date();
        Date date1=new Date(1999);
        System.out.println("---"+date.toString());
        System.out.println("+++++++");
        System.out.println("---"+date1.toString());
        Order[] order= orderRepository.findOrderByCreateDateBetweenAnd(date1,date,1,10);
        for (int i = 0; i < order.length; i++) {
            System.out.println(order[i]);
        }
    }

    @Test
    public void findOrderByTitleTest(){
        Order[] order=orderRepository.findOrderByTitle("快递",1,10);
        for (int i = 0; i < order.length; i++) {
            System.out.println(order[i]);
        }
    }

    @Test
    public void findOrderByIdsTest(){
        Order[] orders=orderRepository.findOrderByCreaterIdOrAccepterId("owh1O5ckqseCFh8ZDmT6mpA7zpPQ",1,10);
        for (int i = 0; i < orders.length; i++) {
            System.out.println(orders[i]);
        }
    }

    @Test
    public void findOrderByCatalogTest(){
        Order[] orders=orderRepository.findOrderByCatalog("快递","order_reward",1,10);
        for (int i = 0; i < orders.length; i++) {
            System.out.println(orders[i]);
        }
    }
}
