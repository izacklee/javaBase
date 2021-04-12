package com.m.test2.controller;

import com.m.test2.service.BaseService;
import com.m.test2.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller() // @Controller("controller") 定义了名字就用定义的 否则就是该类的类名 首字母小写 如：baseController
@Scope("prototype") // 作用域
public class BaseController {

//    @Autowired // 加了这个之后就会自动按照类型装配 可省去了写getter/setter
//    @Resource(name="bs", type=BaseServiceImpl.class)
    @Resource
    private BaseService service;

    public void test() {

        this.service.addUser("test ...");
//        this.service.insertUser("test ...");
//        this.service.deleteUser("test ...");
//        this.service.queryUser(1);
    }
}
