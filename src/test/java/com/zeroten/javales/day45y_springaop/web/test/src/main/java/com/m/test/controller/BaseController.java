package com.m.test.controller;

import com.m.test.service.BaseService;

public class BaseController {

    private BaseService service;

    public void test() {

        this.service.addUser("test ...");
        this.service.insertUser("test ...");
        this.service.deleteUser("test ...");
        this.service.queryUser(1);
    }

    public BaseService getService() {
        return service;
    }

    public void setService(BaseService service) {
        this.service = service;
    }
}
