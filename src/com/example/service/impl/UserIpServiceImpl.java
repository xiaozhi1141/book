package com.example.service.impl;

import com.example.dao.UserIpDao;
import com.example.dao.impl.UserIpDaoImpl;
import com.example.pojo.UserIp;
import com.example.service.UserIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserIpServiceImpl implements UserIpService {
    @Autowired
    private UserIpDao userIpDao;

    @Override
    public void createUserIp(UserIp userIp) {
        userIpDao.createUserIp(userIp);
    }
}
