package com.m.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 普通的Java工程完整注入案例
 * （学习时用Java工程，实际开发用web工程）
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext2.xml");
        Controller controller = context.getBean(Controller.class);
        controller.test();

    }
}
