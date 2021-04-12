package com.m.test2.dao.impl;

import com.m.test2.dao.BaseDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class BaseDaoImpl implements BaseDao {
    @Override
    public int add(String str) {
        try {
            System.out.println("1 开启连接");
            System.out.println("2 开启事务");
            System.out.println("3 执行SQL");  // 除了这个3 其它都是公共的 可用aop解决
            System.out.println("4 SQL提交");
//            System.out.println(str);
        } catch(Exception e) {
            System.out.println("5 SQL的回滚");
            
        } finally {
            System.out.println("6 SQL关闭");
        }
        return 0;
    }
}
