package com.m.service;

import com.m.entity.Users;

import java.util.List;

public interface UsersService {
    public int insert(Users users);
    public int update(Users users);
    public int delete(Users users);
    public List<Users> queryByPar(Users users);
}
