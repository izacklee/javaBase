package com.m.controller;

import com.m.controller.listener.BaseBindingListener;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BaseServlet2 implements Servlet {
    private ServletContext application;
    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("servlet1业务请求");
        HttpServletRequest hreq = (HttpServletRequest) req;
        application = hreq.getServletContext();
        HttpSession session = hreq.getSession();  // 调用Session监听sessionCreated方法才执行 方法只执行一次
        String username = hreq.getParameter("username");
        session.setAttribute("sessionListener",new BaseBindingListener(username));
        session.setAttribute("sessionListener2",new BaseBindingListener(username));
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
