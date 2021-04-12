package com.m.service.impl;

import com.m.dao.UserDao;
import com.m.dao.impl.UserDaoImpl;
import com.m.entity.User;
import com.m.service.UserService;

import java.util.List;

// 业务逻辑层
/*
* 正常的业务，或运算，都写在这里
*/
public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public int insertUser(User user) {
        // 判断用户是否为空
        if (user == null) {
            user =  new User();
        }
        return dao.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        if (user == null) {
            user = new User();
        }
        
        return dao.updateUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return 0;
    }

    @Override
    public List<User> queryUser(User user) {
        if (user == null) {
            user = new User();
        }
        return dao.queryUser(user);
    }
}
