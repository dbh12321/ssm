package com.itheima.dao;

import com.itheima.domain.Books;
import com.itheima.domain.PageBean;

import java.util.List;

public interface BooksDao {
    //查询所有书本数量
    int findTotalCount();
    //根据起始页和条数返回对象
    List<Books> findBooksByPage(int startCount , int perCount);
    //根据id查找book对象
    Books findBookById(int id);
    //修改book对象
    void  updateBook(Books books);
    //删除book对象
    void deleteBookById(int id);
}
