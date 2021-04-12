package com.m.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TestServlet1 implements Servlet {

    public TestServlet1() {
        System.out.println("Servlet实例化");
    }

    private String charSetContent;
    private ServletContext application;
    private ServletConfig conf;
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("servlet被初始化");
        charSetContent = config.getInitParameter("charSetContent");
//        System.out.println(charSetContent); // utf-8
        application = config.getServletContext();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("业务调用");
        req.setCharacterEncoding(charSetContent); // 动态指定业务字符集
        HttpServletRequest hreq = (HttpServletRequest) req;
        HttpServletResponse hres = (HttpServletResponse) res;
        HttpSession session = hreq.getSession();

        System.out.println(hreq.getMethod()); // 获取请求类型  GET
        System.out.println(hreq.getRequestURI()); // /test1.do
        System.out.println(hreq.getRequestURL()); // http://localhost:8093/test1.do
    }

    // 可选方法
    @Override
    public ServletConfig getServletConfig() {
        return this.conf;
    }

    // 可选方法
    @Override
    public String getServletInfo() {
        return "Author: Zack";
    }

    @Override
    public void destroy() {
        try {
            Thread.sleep(3000);
            System.out.println("servlet被销毁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
