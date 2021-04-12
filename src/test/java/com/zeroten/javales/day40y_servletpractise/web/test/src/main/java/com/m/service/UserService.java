package com.m.service;

import com.m.entity.User;
import com.m.entity.UserVolume;

public interface UserService {
    public int insertUser(User user);
    public User queryUser(User user);
    public int insertUserVolume(UserVolume userVolume);
}
