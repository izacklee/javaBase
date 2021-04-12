package com.m.controller.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

// ServletContextAttributeListener监视域元素（属性）的变化
public class BaseApplicationAttListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        // 添加元素
        System.out.println("添加元素监听");
        System.out.println(event.getName());
        System.out.println(event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        // 删除元素
        System.out.println("删除元素监听");
        System.out.println(event.getName());
        System.out.println(event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        // 修改元素
        System.out.println("修改元素监听");
        System.out.println(event.getName());
        System.out.println(event.getValue());
    }
}
