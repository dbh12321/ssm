package com.itheima.service.impl;

import com.itheima.dao.BooksDao;
import com.itheima.dao.impl.BooksDaoImpl;
import com.itheima.domain.Books;
import com.itheima.domain.PageBean;
import com.itheima.service.BooksService;

import java.util.List;

public class BooksServiceImpl implements BooksService {
    private BooksDao booksDao = new BooksDaoImpl();

    @Override
    public PageBean findPage(PageBean pageBean) {
        //获取总记录数
        int totalCount = booksDao.findTotalCount();
        pageBean.setTotalCount(totalCount);
        if (totalCount == 0){
            //若无记录，则返回。
            return pageBean;
        }
        //获取每页记录数
        int perCount = pageBean.getPerCount();
        //计算总页数
        int totalPage = totalCount%perCount == 0 ? totalCount/perCount : (totalCount/perCount + 1);
        pageBean.setTotalPage(totalPage);
        //获取当前页
        int currentPage = pageBean.getCurrentPage();
        //计算起始记录
        int startcount = (currentPage-1)*perCount;
        //获取每页记录
        List<Books> books = booksDao.findBooksByPage(startcount , perCount);
        pageBean.setBookList(books);
        //返回对象
        return pageBean;
    }

    @Override
    public Books findbooksByid(int id) {
        return booksDao.findBookById(id);
    }

    @Override
    public void updateBooks(Books books) {
        booksDao.updateBook(books);
    }

    @Override
    public void deleteBooksById(int id) {
        booksDao.deleteBookById(id);
    }
}
