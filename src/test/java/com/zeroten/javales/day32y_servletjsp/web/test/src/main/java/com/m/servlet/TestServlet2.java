package com.m.servlet;

import javax.servlet.*;
import java.io.IOException;

// Servlet的通用版本，任何情况下都可用 和协议无关
public class TestServlet2 extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletConfig conf = super.getServletConfig();
        // 初始化信息
        ServletContext application = super.getServletContext();
        System.out.println(conf); // org.apache.catalina.core.StandardWrapperFacade@30f0a424
        System.out.println(application); // org.apache.catalina.core.ApplicationContextFacade@485bd05f

    }
}
