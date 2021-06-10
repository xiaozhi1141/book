package com.example.service;

import com.example.pojo.Cart;
import com.example.pojo.Order;
import com.example.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    String createOrder(String orderId,Cart cart,Integer userId);
    List<Order> showAllOrders();
    void sendOrder(String orderId);
    List<OrderItem> showOrderDetail(String orderId);
    List<Order> showMyOrders(Integer userId);
    void receiverOrder(String orderId);
}
