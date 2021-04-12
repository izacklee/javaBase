package com.m;

import com.m.dao.DeptDao;
import com.m.dao.impl.DeptDaoImpl;
import com.m.entity.Dept;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        
        DeptDao dao = new DeptDaoImpl();
//        System.out.println(Arrays.toString(dao.query(new Dept()).toArray()));
//        System.out.println(dao.queryById(10).toString());

//        System.out.println(dao.insert(new Dept(50, "BJ", "北京")));

//        System.out.println(dao.update(new Dept(50, "SHANGHAI", "上海")));

//        System.out.println(dao.delete(50));

        //   多条件查询
//        System.out.println(Arrays.toString(dao.query(new Dept(40, "OPERATIONS", null)).toArray()));


        // 批量插入
        System.out.println(dao.insertList(
                Arrays.asList(new Dept[]{
                        new Dept(50, "BJ50", "北京50"),
                        new Dept(60, "BJ60", "北京60"),
                        new Dept(70, "BJ70", "北京70"),
                        new Dept(80, "BJ80", "北京80"),
                        new Dept(90, "BJ90", "北京90")
                })
        ));

        System.out.println(Arrays.toString(dao.query(new Dept()).toArray()));

    }
}
