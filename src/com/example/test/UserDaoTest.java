package com.example.test;

import com.example.dao.impl.UserDaoImpl;
import com.example.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        if(userDao.queryUserByUsername("admin") == null){
            System.out.println("用户名可用");
        } else{
            System.out.println("用户名已存在");
        }

    }

    @Test
    public void saveUser() {
        User user = new User(null,"root", "root", "root@.com");
        System.out.println(userDao.saveUser(user));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("root","roo2t") ==null){
            System.out.println("用户名或密码错误");
        } else{
            System.out.println("用户名或密码正确");
        }
    }
}