package com.m.mvc.context;

import java.util.Set;

public class XMLApplicationContext extends ContextLoader {

    public XMLApplicationContext() {
    }

    public XMLApplicationContext(String path) {
        super.init();
    }

    public Object getBean(String name) {
        return applicationContext.get(name).getObj();
    }

    public Set<String> getBeanNames() {
        return applicationContext.keySet();
    }
}
