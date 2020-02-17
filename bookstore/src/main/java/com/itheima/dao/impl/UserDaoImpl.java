package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select* from user where username=? && password=?";
            User user = jdbcTemplate.queryForObject(sql , new BeanPropertyRowMapper<User>(User.class) , username , password);
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
