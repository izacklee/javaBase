package com.m.mvc.web;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringEscapeUtils;

import java.util.HashMap;
import java.util.Iterator;
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

    // 转json对象
    public JSONObject toJson() {

        return JSONObject.fromObject(objs);
    }

//    public Set<Map.Entry<String, Object>> entrySet() {
//        return objs.entrySet();
//    };

    @Override
    public String toString() {
//        Iterator<Map.Entry<String, Object>> i = entrySet().iterator();
//        if (! i.hasNext())
//            return "{}";
//
//        StringBuilder sb = new StringBuilder();
//        sb.append('{');
//        for (;;) {
//            Map.Entry<String,Object> e = i.next();
//            String key = e.getKey();
//            Object value = e.getValue();
//            sb.append(key);
//            sb.append('=');
//            sb.append(value);
//            if (! i.hasNext())
//                return sb.append('}').toString();
//            sb.append(',').append(' ');
//        }

        return String.valueOf(objs);
    }
}
