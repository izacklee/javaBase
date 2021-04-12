package com.m.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TestFilter1 implements Filter {
    
    private String charset;
    private ServletContext application;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("被初始化1");
        charset = filterConfig.getInitParameter("charset");
//        application = filterConfig.getServletContext();
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(charset); // 统一字符集设置

        HttpServletRequest hreq = (HttpServletRequest) request;
        HttpServletResponse hres = (HttpServletResponse) response;
        HttpSession session = hreq.getSession();
        application = request.getServletContext();

        // 链式调用下一个过滤器，或者servlet
        System.out.println("过滤器1 调用前执行");
        chain.doFilter(hreq, hres);
        System.out.println("过滤器1 调用后执行");

    }

    @Override
    public void destroy() {
        System.out.println("销毁1");
    }
}
