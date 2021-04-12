package com.m.test2;

import com.m.test2.controller.BaseController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext2.xml");
        BaseController controller = (BaseController) context.getBean(BaseController.class);
        controller.test();
    }
}
