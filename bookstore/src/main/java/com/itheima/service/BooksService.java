package com.itheima.service;

import com.itheima.domain.Books;
import com.itheima.domain.PageBean;

public interface BooksService {
    //分页查询
    PageBean findPage(PageBean pageBean);
    //根据id查找对象
    Books findbooksByid(int id);
    //修改对象
    void updateBooks(Books books);
    //删除duixiang
    void deleteBooksById(int id);
}
