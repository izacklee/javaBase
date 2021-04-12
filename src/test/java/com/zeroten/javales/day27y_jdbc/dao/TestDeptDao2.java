package com.zeroten.javales.day27y_jdbc.dao;

import com.zeroten.javales.day27y_jdbc.annt.Table;

import java.util.List;

public interface TestDeptDao2 {
    // 用泛型方法 比泛型类更好 省事儿
    public <T> List<T> query(T t);
    public <T> List<T> queryById(Integer id, Class<?> clazz);
    public <T> int insert(T t);
    public <T> int insertList(List<T> ts);
    public <T> int update(T t);
    public <T> int deleteById(Integer id, Class<?> clazz);
}
