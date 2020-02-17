package com.itheima.control.filter;

import com.itheima.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/product_list.jsp")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        //获取session
        HttpSession session = request.getSession();
        //查看有无用户
        User user = (User)session.getAttribute("user");
        if (user == null){
            //没有登录，跳转到登录页面
            request.getRequestDispatcher("login.jsp").forward(request , response);

        }else {
            //已经登录,跳转
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
