package com.m.controller.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// ServletContextListener监听域的创建和销毁
public class BaseApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application创建");
        // 可在监听当中获取application
        ServletContext application = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application销毁");
    }   
}
