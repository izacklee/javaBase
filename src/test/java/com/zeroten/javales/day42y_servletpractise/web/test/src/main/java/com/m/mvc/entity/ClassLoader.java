package com.m.mvc.entity;

public class ClassLoader {
    private String name; // 存xml中的name
    private String clazz; // 存xml中的class 如：com.m.dao.impl.BaseDaoImpl
    private ClassLoader parent; // 存父亲，结构简单

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public ClassLoader getParent() {
        return parent;
    }

    public void setParent(ClassLoader parent) {
        this.parent = parent;
    }
}
