package com.itheima.domain;

import java.util.List;

/*
* 分页对象
*
* */
public class PageBean<T> {
    //每页条数，默认为5
    private int perCount = 5;
    //总条数
    private int totalCount;
    //总页数
    private int totalPage;
    //当前页数
    private int currentPage;
    //本页返回list对象
    private List<T> bookList;

    public int getPerCount() {
        return perCount;
    }

    public void setPerCount(int perCount) {
        this.perCount = perCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getBookList() {
        return bookList;
    }

    public void setBookList(List<T> bookList) {
        this.bookList = bookList;
    }
}
