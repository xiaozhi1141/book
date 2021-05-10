package com.example.test;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        User user = new User(null,"acd","acd","acd@.com");
        userService.registUser(user);
    }

    @Test
    public void login() {
        User user = new User(null,"acd","acd","acd@.com");
        System.out.println(userService.login(user));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("root")){
            System.out.println("用户名已经存在！");
        } else{
            System.out.println("用户名可用");
        }
    }
}