package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.pojo.User;
import com.example.service.UserService;

public class UserServiceImpl implements UserService {
   private UserDao Dao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        Dao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return Dao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(Dao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
