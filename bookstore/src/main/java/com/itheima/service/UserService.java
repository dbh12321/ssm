package com.itheima.service;

import com.itheima.domain.User;

public interface UserService {
    //查询用户名密码是否正确
    public boolean login(User user);
}
