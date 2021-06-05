package com.example.test;

import com.example.dao.OrderItemDao;
import com.example.dao.impl.OrderItemDaoImpl;
import com.example.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"mysql",4,new BigDecimal(100),new BigDecimal(400),"12345690"));
        orderItemDao.saveOrderItem(new OrderItem(null,"高等数学",4,new BigDecimal(100),new BigDecimal(400),"12345690"));
        orderItemDao.saveOrderItem(new OrderItem(null,"英语",4,new BigDecimal(100),new BigDecimal(400),"12345690"));
        orderItemDao.saveOrderItem(new OrderItem(null,"C语言",4,new BigDecimal(100),new BigDecimal(400),"12345690"));
    }


    @Test
    public void queryOrderItemsByOrderId(){
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        List<OrderItem> orderItems = orderItemDao.queryOrderItemsByOrderId("16226371847103");
        System.out.println(orderItems);
    }
}