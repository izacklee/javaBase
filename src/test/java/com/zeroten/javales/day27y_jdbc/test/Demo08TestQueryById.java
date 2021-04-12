package com.zeroten.javales.day27y_jdbc.test;

import com.zeroten.javales.day27y_jdbc.entity.Dept;
import com.zeroten.javales.day27y_jdbc.dao.impl.TestDeptDaoImpl2;
import com.zeroten.javales.day27y_jdbc.entity.Emp;

import java.util.List;

public class Demo08TestQueryById {

    public static void main(String[] args) {
        TestDeptDaoImpl2 tdd = new TestDeptDaoImpl2();
        List<Emp> rs = tdd.queryById(7369, Emp.class);
        System.out.println(rs);
    }
}
