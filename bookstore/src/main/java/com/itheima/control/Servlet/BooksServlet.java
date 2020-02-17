package com.itheima.control.Servlet;

import com.itheima.domain.Books;
import com.itheima.domain.PageBean;
import com.itheima.service.BooksService;
import com.itheima.service.impl.BooksServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/booksServlet/*")
public class BooksServlet extends BaseServlet {
    //分页查找
    public void findPage(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        //获取当前页
        String currentPage1 = request.getParameter("currentPage");
        if (currentPage1 == null || currentPage1 == ""){
            currentPage1 = "1";
        }
        int currentPage = Integer.parseInt(currentPage1);
        if (currentPage <= 0){
            currentPage = 1;
        }
        //封装pagebean对象
        PageBean<Books> pageBean = new PageBean<Books>();
        pageBean.setCurrentPage(currentPage);
        //调用服务层查找
        BooksService booksService = new BooksServiceImpl();
        pageBean = booksService.findPage(pageBean);
        //设置session域
        HttpSession session = request.getSession();
        session.setAttribute("pageBean" , pageBean);
        //跳转回展示页面
       response.sendRedirect(request.getContextPath() + "/product_list.jsp");
    }

    //查找一个对象
    public void findOne(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {
        //获取id
        int id = Integer.parseInt(request.getParameter("id"));
        //获取当前页
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //调用服务层查找book
        BooksService booksService = new BooksServiceImpl();
        Books books = booksService.findbooksByid(id);
        //生成session对象
        HttpSession session = request.getSession();
        session.setAttribute("books" , books);
        session.setAttribute("currentPage" , currentPage);
        //跳转到修改页面
        response.sendRedirect(request.getContextPath()+"/edit.jsp");

    }

    //修改书籍
    public void updateBook(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {
        request.setCharacterEncoding("utf-8");
        try {
            //封装book对象
            Books books = new Books();
            BeanUtils.populate(books , request.getParameterMap());
            //获取currentPage
            int currentPage = Integer.parseInt(request.getParameter("currentPage"));
            //修改
            BooksService booksService = new BooksServiceImpl();
            booksService.updateBooks(books);
            //跳转回当前页面
            response.setContentType("text/html;charset=utf-8");
            response.sendRedirect(request.getContextPath()+"/booksServlet/findPage?currentPage="+currentPage+"");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    //删除图书
    public void deleteBook(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {
        //获取id和名字
        int id = Integer.parseInt(request.getParameter("id"));
        //删除对象
        BooksService booksService = new BooksServiceImpl();
        booksService.deleteBooksById(id);
        //返回list页面
        response.sendRedirect(request.getContextPath() + "/booksServlet/findPage");

    }
}
