package com.m.controller;

import com.m.mvc.web.Controller;
import com.m.mvc.web.MyRequestMapping;
import com.m.service.BaseService;
import com.m.service.impl.BaseServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MyRequestMapping("/base")
public class BaseController implements Controller {

//    private BaseService service = new BaseServiceImpl();  // 代码高耦合度
    private BaseService service;

    @MyRequestMapping("/test1.do")
    public void test1(String str, Integer id, HttpServletRequest hreq, HttpServletResponse hres) {
        System.out.println("controller1被调用");
        service.test();
    }

    @MyRequestMapping("/test2.do")
    public void test2(String str, Integer id, HttpServletRequest hreq, HttpServletResponse hres) {
        System.out.println("controller2被调用");
        service.test();
    }

    @MyRequestMapping("/test3.do")
    public void test3(String str, Integer id, HttpServletRequest hreq, HttpServletResponse hres) {
        System.out.println("controller3被调用");
        service.test();
    }

    public BaseService getService() {
        return service;
    }

    public void setService(BaseService service) {
        this.service = service;
    }
}
