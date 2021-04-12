package com.m.service.impl;

import com.m.dao.UserDao;
import com.m.dao.UserVolumeDao;
import com.m.entity.User;
import com.m.entity.UserVolume;
import com.m.service.UserService;

public class UserServiceImpl  implements UserService {
    private UserDao userDao;
    private UserVolumeDao userVolumeDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserVolumeDao getUserVolumeDao() {
        return userVolumeDao;
    }

    public void setUserVolumeDao(UserVolumeDao userVolumeDao) {
        this.userVolumeDao = userVolumeDao;
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User queryUser(User user) {
        return userDao.queryUser(user);
    }

    @Override
    public int insertUserVolume(UserVolume userVolume) {
        return userVolumeDao.insertUserVolume(userVolume);
    }

    @Override
    public UserVolume queryUserVolume(UserVolume userVolume) {
        return userVolumeDao.queryUserVolume(userVolume);
    }
}
