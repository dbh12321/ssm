package com.itheima.control.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //1.获取方法名
            String uri = req.getRequestURI();
            String method = uri.substring(uri.lastIndexOf('/')+1);
            //获取方法
            Method method1 = this.getClass().getMethod(method , HttpServletRequest.class , HttpServletResponse.class);
            //执行方法
            method1.invoke(this , req , resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
