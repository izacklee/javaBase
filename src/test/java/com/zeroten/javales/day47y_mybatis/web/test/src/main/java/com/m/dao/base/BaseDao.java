package com.m.dao.base;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public abstract class BaseDao {
    private SqlSessionFactory ssf = null;

    public BaseDao() {
        try {
            // 1 读取配置文件
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            // 2 解析配置文件 用过即丢
            SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
            // 3 解析
            this.ssf = ssfb.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SqlSessionFactory getSsf() {
        return ssf;
    }


    
}
