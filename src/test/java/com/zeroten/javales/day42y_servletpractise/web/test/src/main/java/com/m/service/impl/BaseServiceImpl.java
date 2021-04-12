package com.m.service.impl;

import com.m.dao.BaseDao;
import com.m.dao.impl.BaseDaoImpl;
import com.m.service.BaseService;

public class BaseServiceImpl implements BaseService {

//    private BaseDao dao = new BaseDaoImpl();
    private BaseDao dao;

    @Override
    public void test() {
        System.out.println("service被调用");
        dao.test();
    }

    public BaseDao getDao() {
        return dao;
    }

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }
}
