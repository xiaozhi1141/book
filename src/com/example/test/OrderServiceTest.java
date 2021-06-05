package com.example.test;

import com.example.pojo.Cart;
import com.example.pojo.CartItem;
import com.example.service.OrderService;
import com.example.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"mysql",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new CartItem(1,"mysql",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new CartItem(2,"mysql2",1,new BigDecimal(10),new BigDecimal(10)));
        OrderService orderService = new OrderServiceImpl();
        System.out.println(orderService.createOrder(cart,1));
    }
}