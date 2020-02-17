package com.itheima.control.Servlet;

import com.itheima.domain.RetrunMsg;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取User对象
            User user = new User();
            BeanUtils.populate(user , request.getParameterMap());
            //根据user对象验证是否正确
            UserService userService = new UserServiceImpl();
            boolean flag = userService.login(user);
            if (flag){
                //验证正确
                //存入session
                HttpSession session = request.getSession();
                session.setAttribute("user" , user);
                //跳转到产品页面
                response.sendRedirect("booksServlet/findPage?currentPage=1");
                request.getRequestDispatcher("").forward(request , response);
            }else {
                //验证错误
                //设置返回信息
                RetrunMsg retrunMsg = new RetrunMsg();
                retrunMsg.setFlag(false);
                retrunMsg.setError_msg("用户名密码错误");
                request.setAttribute("msg" , retrunMsg);
                //跳转回登录页面
                request.getRequestDispatcher( "/login.jsp").forward(request , response);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
