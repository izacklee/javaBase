package com.m.controller.interceptor;

import com.m.mvc.web.HanderInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HanderInterceptor {
    // 进入hander前
    @Override
    public boolean pre(HttpServletRequest request, HttpServletResponse response) {
        return false;
    }

    // model返回之前
    @Override
    public boolean post(HttpServletRequest request, HttpServletResponse response) {
        return false;
    }

    // model返回之后
    @Override
    public boolean after(HttpServletRequest request, HttpServletResponse response) {
        return false;
    }
}
