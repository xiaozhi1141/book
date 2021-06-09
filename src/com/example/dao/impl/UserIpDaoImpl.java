package com.example.dao.impl;

import com.example.dao.UserIpDao;
import com.example.pojo.UserIp;

public class UserIpDaoImpl extends BaseDao implements UserIpDao {
    @Override
    public int createUserIp(UserIp userIp) {
        String sql = "insert into t_userip(userid,ip) values(?,?)";
        return update(sql,userIp.getUserId(),userIp.getIp());
    }
}
