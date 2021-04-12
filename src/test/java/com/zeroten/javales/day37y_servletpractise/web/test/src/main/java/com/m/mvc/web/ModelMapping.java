package com.m.mvc.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 放转发或重定向的jsp文件路径
 */
public class ModelMapping {
    
    private Map<String,Object> objs = new HashMap<>();
    public void add(String key, Object value) {
        objs.put(key,value);
    }
    public Object get(String key) {
        return objs.get(key);
    }
    
    public Set<String> getKeys() {
        return objs.keySet();
    }
}
