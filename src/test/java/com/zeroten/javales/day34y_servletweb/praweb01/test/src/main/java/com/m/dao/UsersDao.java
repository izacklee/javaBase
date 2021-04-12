package com.m.dao;

import com.m.entity.Users;

import java.util.List;

public interface UsersDao {
    public int insert(Users users);
    public int update(Users users);
    public int delete(Users users);
    public List<Users> queryByPar(Users users);
}
