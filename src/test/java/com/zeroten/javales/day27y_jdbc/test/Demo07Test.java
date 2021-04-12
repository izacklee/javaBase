package com.zeroten.javales.day27y_jdbc.test;

import com.zeroten.javales.day27y_jdbc.entity.Dept;
import com.zeroten.javales.day27y_jdbc.dao.TestDeptDao2;
import com.zeroten.javales.day27y_jdbc.dao.impl.TestDeptDaoImpl2;
import com.zeroten.javales.day27y_jdbc.entity.Emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.SimpleTimeZone;

public class Demo07Test {
    public static void main(String[] args) throws Exception {
//        Dept d = new Dept();
//        d.setDeptno(20);
//        d.setDname("SALES");
//        d.setLoc("");

        Emp e = new Emp();
//        e.setDeptno(10);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        e.setHiredate(sdf.parse("1981-06-09"));
        TestDeptDao2 tdd = new TestDeptDaoImpl2();
        List<Emp> result = tdd.query(e);
//        System.out.println(result);
        for (Object r : result) {
            System.out.println(r);
        }
    }
}
