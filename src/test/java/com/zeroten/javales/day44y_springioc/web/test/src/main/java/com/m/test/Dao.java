package com.m.test;

import java.util.Map;
import java.util.Properties;

public class Dao {

    private Map<String, String> map;
    private Properties pro; // 是Java 语言的配置文件所使用的类

    public void test() {
        System.out.println("Dao test ...");
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getPro() {
        return pro;
    }

    public void setPro(Properties pro) {
        this.pro = pro;
    }
}
