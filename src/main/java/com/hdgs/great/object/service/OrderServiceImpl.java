package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Catalog;
import com.hdgs.great.object.domain.Order;
import com.hdgs.great.object.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public boolean createOrder(Order order) {
        //创建当前时间对象，封装Order属性
        Date now = new Date();
        order.setDate(now);
        //订单在最初创建时默认是未接单状态
        order.setStatus(0);
        int insertNum=orderRepository.insertOrder(order);
        if(insertNum>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public void delete(int id) {
        orderRepository.deleteOrderById(id);
    }

    @Override
    public Order getMappingById(int id) {
        Order data = orderRepository.findOrderById(id);
        return data;
    }

    @Override
    public Page<Order> getMappingByCatalog(Catalog catalog,int page ,int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Order> data = orderRepository.findOrderByCatalog(catalog ,pageable);
        return data;
    }

    @Override
    public Page<Order> getMappingByStatus(int status,int page ,int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Order> data = orderRepository.findOrderByStatus(status,pageable);
        return data;
    }
}
