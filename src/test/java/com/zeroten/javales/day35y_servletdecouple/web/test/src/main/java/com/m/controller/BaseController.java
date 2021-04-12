package com.m.controller;

import com.m.mvc.web.Controller;
import com.m.service.BaseService;
import com.m.service.impl.BaseServiceImpl;

public class BaseController implements Controller {

//    private BaseService service = new BaseServiceImpl();  // 代码高耦合度
    private BaseService service;

    public void test() {
        System.out.println("controller被调用");
        service.test();
    }

    public BaseService getService() {
        return service;
    }

    public void setService(BaseService service) {
        this.service = service;
    }
}
