package com.example.dao;

import com.example.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    int saveOrderItem(OrderItem orderItem);
    List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
