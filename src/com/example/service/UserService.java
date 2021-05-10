package com.example.service;

import com.example.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    void registUser(User user);

    /**
     * 登陆业务
     * @param user
     * @return 如果返回null说明登陆失败
     */
    User login(User user);

    /**
     * 检查用用户名是否可用
     * @param username
     * @return 返回true表示用户名存在，返回false表示用户名可用
     */
    boolean existsUsername(String username);

}
