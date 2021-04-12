package com.m.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BaseServlet1 implements Servlet {
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
//        HttpSession session = hreq.getSession();  // 调用Session监听sessionCreated方法才执行 方法只执行一次
//        session.invalidate();  // 手动销毁session
        
        String att = hreq.getParameter("att");
        String key = hreq.getParameter("key");
        String value = hreq.getParameter("value");

        // application
//        if ("1".equals(att)) { // 添加
//            application.setAttribute(key, value);
//        } else if ("2".equals(att)) { // 删除
//            application.removeAttribute(key);
//        } else {  // 修改
//            application.setAttribute(key,value);
//        }
            
        // session
//        if ("1".equals(att)) {
//            session.setAttribute(key, value);
//        } else if ("2".equals(att)) {
//            session.removeAttribute(key);
//        } else {
//            session.setAttribute(key, value);
//        }
        
        // request
        if ("1".equals(att)) {
            hreq.setAttribute(key, value);
        } else if ("2".equals(att)) {
            hreq.setAttribute(key, value);
            hreq.removeAttribute(key);
        } else {
            hreq.setAttribute(key, value);
        }
        
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
