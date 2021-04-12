package com.m.service.impl;

import com.m.dao.UsersDao;
import com.m.dao.impl.UsersDaoImpl;
import com.m.entity.Users;
import com.m.service.UsersService;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao = new UsersDaoImpl();
    @Override
    public int insert(Users users) {
        if (users == null) {
            users = new Users();
        }
        return usersDao.insert(users);
    }

    @Override
    public int update(Users users) {
        if (users == null) {
            users = new Users();
        }
        return usersDao.update(users);
    }

    @Override
    public int delete(Users users) {
        if (users == null) {
            users = new Users();
        }
        return usersDao.delete(users);
    }

    @Override
    public List<Users> queryByPar(Users users) {
        if (users == null) {
            users = new Users();
        }
        return usersDao.queryByPar(users);
    }
}
