package com.m.test.service.impl;

import com.m.test.dao.BaseDao;
import com.m.test.service.BaseService;

public class BaseServiceImpl implements BaseService {
    
    private BaseDao dao; 
    
    
    
//    @Override
//    public int add(String str) {
//        
//        return this.dao.add(str);
//    }

    public BaseDao getDao() {
        return dao;
    }

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }

    @Override
    public int addUser(String str) {
        System.out.println("addUser");
        return 0;
    }

    @Override
    public int insertUser(String str) {
        System.out.println("insertUser");
        return 0;
    }

    @Override
    public int deleteUser(String str) {
        System.out.println("deleteUser");
        return 0;
    }

    @Override
    public String queryUser(int id) {
        System.out.println("queryUser");
        return null;
    }
}
