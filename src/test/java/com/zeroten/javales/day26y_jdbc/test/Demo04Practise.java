package com.zeroten.javales.day26y_jdbc.test;

import com.zeroten.javales.day26y_jdbc.dao.TestDeptDao;
import com.zeroten.javales.day26y_jdbc.dao.impl.TestDeptDaoImpl;
import com.zeroten.javales.day26y_jdbc.entity.Dept;

import java.util.List;

public class Demo04Practise {

    public static void main(String[] args) {
        TestDeptDao tdd = new TestDeptDaoImpl();
//        List<Dept> depts = tdd.queryDeptByPar(new Dept()); // 查询获取所有部分信息
        List<Dept> depts = tdd.queryDeptByPar(new Dept()
                .setDname("%SA%")
                .setDeptno(106)
        );
        for (Dept d : depts) {
            System.out.println(d);
        }
    }

}
