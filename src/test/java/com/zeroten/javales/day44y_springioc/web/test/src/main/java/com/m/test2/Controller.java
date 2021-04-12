package com.m.test2;

import com.m.test2.impl.BaseDaoImpl;
import com.m.test2.impl.BaseServiceImpl;

public class Controller {
    private BaseService service;
    
    public void test() {
        System.out.println("controller test ...");
        this.service.test();
    }

    public BaseService getService() {
        return service;
    }

    public void setService(BaseService service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "service=" + service +
                '}';
    }
}
