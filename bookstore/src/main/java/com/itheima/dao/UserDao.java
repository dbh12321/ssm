package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {
    //根据用户名密码查找用户对象
    User findUserByUsernameAndPassword(String username , String password);
}
