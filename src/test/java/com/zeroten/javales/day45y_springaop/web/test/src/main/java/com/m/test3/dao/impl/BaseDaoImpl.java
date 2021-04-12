package com.m.test3.dao.impl;

import com.m.test3.dao.BaseDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class BaseDaoImpl implements BaseDao {
    @Override
    public int add(String str) throws Exception{// 因为这里只执行SQL，所以异常都要往外抛，在外处理
        System.out.println("3 执行SQL");  // 除了这个3 其它都是公共的 可用aop解决
        return 0;
    }
}
