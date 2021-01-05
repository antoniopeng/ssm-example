package com.antoniopeng.hello.ssm.service;


import com.antoniopeng.hello.ssm.entity.User;

public interface UserService {

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 用户密码
     * @return
     */
    User login(String username, String password);
}
