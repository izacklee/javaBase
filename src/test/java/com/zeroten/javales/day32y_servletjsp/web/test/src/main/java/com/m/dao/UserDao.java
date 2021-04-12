package com.m.dao;

import com.m.entity.User;

import java.util.List;

// 表的基本数据操作接口
public interface UserDao {
    public int insertUser(User user);
    public int updateUser(User user);
    public int deleteUser(User user);
    public List<User> queryUser(User user);
}
