package com.m.dao;

import com.m.entity.User;

import java.util.List;

public interface UserDao {
    public int insertUser(User user);
    public User queryUser(User user);
}
