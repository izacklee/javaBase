package com.m.controller.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class BaseSessionAttListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // 添加元素
        System.out.println("session添加");
        System.out.println(event.getName());
        System.out.println(event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        // 删除元素
        System.out.println("session删除");
        System.out.println(event.getName());
        System.out.println(event.getValue());

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // 修改元素
        System.out.println("session修改");
        System.out.println(event.getName());
        System.out.println(event.getValue());

    }
}
