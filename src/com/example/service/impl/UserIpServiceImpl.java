package com.example.service.impl;

import com.example.dao.UserIpDao;
import com.example.dao.impl.UserIpDaoImpl;
import com.example.pojo.UserIp;
import com.example.service.UserIpService;

public class UserIpServiceImpl implements UserIpService {
    private UserIpDao userIpDao = new UserIpDaoImpl();

    @Override
    public void createUserIp(UserIp userIp) {
        userIpDao.createUserIp(userIp);
    }
}
