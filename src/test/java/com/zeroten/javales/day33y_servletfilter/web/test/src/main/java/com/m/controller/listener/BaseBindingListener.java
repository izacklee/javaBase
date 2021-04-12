package com.m.controller.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseBindingListener implements HttpSessionBindingListener {
    
    public String username;
    private ServletContext application;
    public BaseBindingListener() {}
    public BaseBindingListener(String username) {
        this.username = username;
    }
    
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 绑定
        System.out.println("绑定");
        application = event.getSession().getServletContext();
        List<String> userList = (List<String>) application.getAttribute("userList");
        
        if (userList == null) {
            userList = new ArrayList<String>();
            application.setAttribute("userList", userList);
        }
        userList.add(username);
        System.out.println(Arrays.toString(userList.toArray()));
        
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // 解绑
        System.out.println("解绑");
        List<String> userList = (List<String>) application.getAttribute("userList");
        userList.remove(username);
        System.out.println(userList == null ? "[]" : Arrays.toString(userList.toArray())); // [zack2]

    }
}
