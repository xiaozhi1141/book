package com.example.dao;

import com.example.pojo.Order;

import java.util.List;

public interface OrderDao {
    int saveOrder(Order order);
    List<Order> queryOrder();
    int changeOrderStatus(String orderId,int status);
    List<Order> queryOrdersByUserId(Integer userId);
}
