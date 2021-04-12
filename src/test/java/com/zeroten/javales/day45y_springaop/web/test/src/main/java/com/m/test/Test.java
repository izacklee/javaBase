package com.m.test;

import com.m.test.controller.BaseController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        BaseController controller = (BaseController) context.getBean("controller");
        controller.test();
    }
}
