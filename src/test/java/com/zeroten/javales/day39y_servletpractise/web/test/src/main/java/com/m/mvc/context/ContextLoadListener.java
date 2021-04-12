package com.m.mvc.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoadListener extends ContextLoader implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 当监听启动时，能够执行XML解析
        String path = sce.getServletContext().getRealPath(""); // 获取工程目录
        super.init(path);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
