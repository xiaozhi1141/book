package com.example.test;

import com.example.dao.UserIpDao;
import com.example.dao.impl.UserIpDaoImpl;
import com.example.pojo.UserIp;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserIpDaoTest {

    @Test
    public void createUserIp() {
        UserIpDao userIpDao = new UserIpDaoImpl();
        int i = userIpDao.createUserIp(new UserIp(null, 3, "192.168.1.3", null));
        System.out.println(i);
    }
}