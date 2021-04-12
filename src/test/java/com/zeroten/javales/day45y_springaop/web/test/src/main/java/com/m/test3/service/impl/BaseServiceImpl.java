package com.m.test3.service.impl;

import com.m.test3.dao.BaseDao;
import com.m.test3.service.BaseService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Service("bs")
@Service
@Scope("prototype")
public class BaseServiceImpl implements BaseService {
    
//    @Autowired  // 加了这个之后就会自动按照类型装配 可省去了写getter/setter
    @Resource
    private BaseDao dao;
    
//    @Override
//    public int add(String str) {
//        
//        return this.dao.add(str);
//    }
    
    @Override
    public int addUser(String str) {
        System.out.println("addUser");

        try {
            return this.dao.add(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
