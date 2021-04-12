package com.m.test3;

import com.m.test3.controller.BaseController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext3.xml");
        BaseController controller = (BaseController) context.getBean(BaseController.class);
        controller.test();
    }
}
