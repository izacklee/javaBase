package com.m.dao;

import com.m.entity.UserVolume;

public interface UserVolumeDao {
    public int insertUserVolume(UserVolume userVolume);
    public UserVolume queryUserVolume(UserVolume userVolume);
}
