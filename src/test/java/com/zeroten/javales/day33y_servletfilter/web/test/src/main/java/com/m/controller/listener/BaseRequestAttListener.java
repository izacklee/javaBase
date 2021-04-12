package com.m.controller.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class BaseRequestAttListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("request添加");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("request删除");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("request修改");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
    }
}
