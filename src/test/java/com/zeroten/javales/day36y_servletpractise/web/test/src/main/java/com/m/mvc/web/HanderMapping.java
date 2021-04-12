package com.m.mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
