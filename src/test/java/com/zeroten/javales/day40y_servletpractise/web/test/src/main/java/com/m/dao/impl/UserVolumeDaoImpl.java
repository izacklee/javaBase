package com.m.dao.impl;

import com.m.dao.UserVolumeDao;
import com.m.dao.base.BaseDao;
import com.m.entity.UserVolume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserVolumeDaoImpl extends BaseDao implements UserVolumeDao {
    @Override
    public int insertUserVolume(UserVolume userVolume) {
        try {
            Connection conn = super.getConnection();
            String sql = "INSERT INTO user_volume (appid) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, userVolume.getAppid());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            super.closeConnection();
        }

        return 0;
    }
}
