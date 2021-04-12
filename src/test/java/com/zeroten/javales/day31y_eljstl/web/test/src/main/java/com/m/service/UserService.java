package com.m.service;

import com.m.dao.UserDao;
import com.m.dao.impl.UserDaoImpl;
import com.m.entity.User;

import java.util.List;

public interface UserService {
    public int insertUser(User user);
    public int updateUser(User user);
    public int deleteUser(User user);
    public List<User> queryUser(User user);
}
