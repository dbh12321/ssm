package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public boolean login(User user) {
        //调用UserDao方法查询对象
        User user1 = userDao.findUserByUsernameAndPassword(user.getUsername() , user.getPassword());
        if (user1 != null){
            //用户名密码错误
            return true;
        }
        return false;
    }
}
