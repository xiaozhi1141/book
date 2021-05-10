package com.example.dao;

import com.example.pojo.User;

public interface UserDao {


    /**
     * 根据用户名查询用户信息
     * @param username
     * @return  如果返回null说明没有这个用户
     */
    User queryUserByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1表示操作失败，返回其他表示影响行数
     */
    int saveUser(User user);

    /**
     * 根据用户名和密码查询
     * @param username
     * @param password
     * @return 如果返回null说明用户名或密码错误
     */
    User queryUserByUsernameAndPassword(String username,String password);

}
