package com.m.mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 拦截器
public interface HanderInterceptor {
    public boolean pre(HttpServletRequest request, HttpServletResponse response);
    public boolean post(HttpServletRequest request, HttpServletResponse response);
    public boolean after(HttpServletRequest request, HttpServletResponse response);
}
