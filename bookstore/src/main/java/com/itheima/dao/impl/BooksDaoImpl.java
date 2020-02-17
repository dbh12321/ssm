package com.itheima.dao.impl;

import com.itheima.dao.BooksDao;
import com.itheima.domain.Books;
import com.itheima.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BooksDaoImpl implements BooksDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from books";
        return jdbcTemplate.queryForObject(sql , Integer.class);
    }

    @Override
    public List<Books> findBooksByPage(int startCount, int perCount) {
        String sql = "select * from books limit ? , ?";
        try {
            List<Books> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Books>(Books.class), startCount, perCount);
            return books;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Books findBookById(int id) {
        String sql = "select* from books where id = ?";
        Books books = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Books>(Books.class), id);
        return books;
    }

    @Override
    public void updateBook(Books books) {
        String sql = "update books set name = ? ,price = ?, pnum = ?, category = ? where id = ?";
        int count = jdbcTemplate.update(sql , books.getName() , books.getPrice() , books.getPnum() , books.getCategory() , books.getId());
        return;
    }

    @Override
    public void deleteBookById(int id) {
        String sql = "delete from books where id = ?";
        jdbcTemplate.update(sql , id);
    }
}
