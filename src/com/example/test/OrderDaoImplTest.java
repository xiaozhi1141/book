package com.example.test;

import com.example.dao.BookDao;
import com.example.dao.OrderDao;
import com.example.dao.impl.BookDaoImpl;
import com.example.dao.impl.OrderDaoImpl;
import com.example.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoImplTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("12345690",new BigDecimal(100),0,1));
    }

    @Test
    public void queryOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        System.out.println(orderDao.queryOrder());
    }

    @Test
    public void changeOrderStatus() {
        OrderDao orderDao = new OrderDaoImpl();
        System.out.println(orderDao.changeOrderStatus("16226311186013",0));
    }

    @Test
    public void queryOrdersByUserId() {
        OrderDao orderDao = new OrderDaoImpl();
        System.out.println(orderDao.queryOrdersByUserId(1));
    }
}