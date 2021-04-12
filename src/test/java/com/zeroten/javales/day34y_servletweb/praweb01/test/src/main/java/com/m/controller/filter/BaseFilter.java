package com.m.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BaseFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hreq = (HttpServletRequest) request;
        HttpServletResponse hres = (HttpServletResponse) response;
        HttpSession session = (HttpSession) hreq.getSession();
        ServletContext application = session.getServletContext();

        // 设置字符编码
        hreq.setCharacterEncoding("UTF-8");

        // 获取uri
        String uri = hreq.getRequestURI();
        

    }

    @Override
    public void destroy() {

    }
}
