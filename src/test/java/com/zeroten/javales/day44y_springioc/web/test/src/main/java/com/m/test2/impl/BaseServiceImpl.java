package com.m.test2.impl;

import com.m.test2.BaseDao;
import com.m.test2.BaseService;

public class BaseServiceImpl implements BaseService {
    
    private BaseDao dao;
    
    @Override
    public void test() {
        System.out.println("service test ...");
        this.dao.test();
    }

    public BaseDao getDao() {
        return dao;
    }

    public void setDao(BaseDao baseDao) {
        this.dao = baseDao;
    }
}
