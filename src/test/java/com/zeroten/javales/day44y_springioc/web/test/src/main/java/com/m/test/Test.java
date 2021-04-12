package com.m.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
               "applicationContext.xml");
        Controller controller = context.getBean(Controller.class);
        controller.test();

        System.out.println(controller); // Controller{service=com.m.test.Service@1324409e, appName='testApp', appVersion=1}
    }
}
