package com.example.test;

import com.example.pojo.Cart;
import com.example.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"mysql",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new CartItem(1,"mysql",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new CartItem(2,"mysql2",1,new BigDecimal(10),new BigDecimal(10)));
        System.out.println(cart);

    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"mysql",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new CartItem(1,"mysql",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new CartItem(2,"mysql2",1,new BigDecimal(10),new BigDecimal(10)));
        cart.deleteItem(2);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"mysql",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new CartItem(1,"mysql",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new CartItem(2,"mysql2",1,new BigDecimal(10),new BigDecimal(10)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"mysql",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new CartItem(1,"mysql",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new CartItem(2,"mysql2",1,new BigDecimal(10),new BigDecimal(10)));
        cart.updateCount(2,2);
        System.out.println(cart);
    }
}