package com.m.mvc.context;

public class XMLApplicationContext extends ContextLoader {

    public XMLApplicationContext() {
    }

    public XMLApplicationContext(String path) {
        super.init();
    }

    public Object getBean(String name) {
        return applicationContext.get(name).getObj();
    }
}
