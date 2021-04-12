package com.m.controller.filter;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("被初始化2");
        System.out.println("初始化数据库的连接");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤器2 调用前执行");
        System.out.println("打开数据库连接");
        // 链式调用下一个过滤器，或者servlet
        chain.doFilter(request, response);  // servlet执行
        System.out.println("归还数据库连接");
        System.out.println("过滤器2 调用后执行");

    }

    @Override
    public void destroy() {
        System.out.println("销毁2");
    }
}
