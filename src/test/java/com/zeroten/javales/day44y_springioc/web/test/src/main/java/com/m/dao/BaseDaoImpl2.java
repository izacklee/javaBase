package com.m.dao;

public class BaseDaoImpl2 implements BaseDao {
    
    public BaseDaoImpl2() {
        super();
        System.out.println("create BaseDaoImpl2");
    }
    
    public static BaseDao instance() {
        System.out.println("使用静态工程");
        return new BaseDaoImpl2();
    }
    
    public void test() {
        System.out.println("test ...");
    }
}
