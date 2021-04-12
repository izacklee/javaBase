package com.m.mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责映射到具体的hander  (hander就是Controller）
 * */
public class HanderMapping {
    private String mapping; // Controller + method
    private String name;  // bean的name
    private String method; // bean的方法
    private Class<?>[] partypes;

    public HanderChain getHander(HttpServletRequest hreq, HttpServletResponse hres) {
//        String contextPath = hreq.getServletContext().getContextPath();
        // 如果mapping(Controller + method 从注解中获取的)和访问的路由匹配成功，则才执行该方法

        // 在context装载时（解析bean的XML时），也要解析拦截器XML，存到HanderChain的interceptorList
        List<HanderInterceptor> interceptorList = new ArrayList<>();
        // 过滤所有的拦截器，把符合uri条件的拦截器挑选出来，保存到这个集合当中
        // ... 执行

        if (mapping.equals(hreq.getRequestURI())) {
            HanderChain hander = new HanderChain(name, method, partypes, hreq, hres);
            return hander;
        }
        return null;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Class<?>[] getPartypes() {
        return partypes;
    }

    public void setPartypes(Class<?>[] partypes) {
        this.partypes = partypes;
    }
}
