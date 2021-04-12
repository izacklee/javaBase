package com.m.dao.impl;

import com.m.dao.UserVolumeDao;
import com.m.dao.base.BaseDao;
import com.m.entity.UserVolume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserVolumeDaoImpl extends BaseDao implements UserVolumeDao {
    @Override
    public int insertUserVolume(UserVolume userVolume) {

        Connection conn = null;
        try {
            conn = super.getConnection();
            conn.setAutoCommit(false);

            String sql = "INSERT INTO user_volume (appid) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, userVolume.getAppid());

            int i = ps.executeUpdate();
            conn.commit();

            return i;
        } catch (SQLException throwables) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throwables.printStackTrace();
        } finally {
            super.closeConnection();
        }

        return 0;
    }

    @Override
    public UserVolume queryUserVolume(UserVolume userVolume) {
        try {
            Connection conn = super.getConnection();
            String str = "SELECT `id`, `size`, `def_size`, `max_size`, `expire_time`, `appid` " +
                    "FROM user_volume WHERE 1=1";
            StringBuffer sql = new StringBuffer(str);
            if (userVolume != null) {
                if (userVolume.getId() != null) {
                    sql.append(" AND `id` = ?");
                }
                if (userVolume.getAppid() != null) {
                    sql.append(" AND `appid` = ?");
                }
            }

            PreparedStatement ps = conn.prepareStatement(sql.toString());

            int index = 0;

            if (userVolume != null) {
                if (userVolume.getId() != null) {
                    ps.setInt(++index, userVolume.getId());
                }
                if (userVolume.getAppid() != null) {
                    ps.setString(++index, userVolume.getAppid());
                }
            }

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                userVolume = new UserVolume();
                userVolume.setId(rs.getInt("id"));
                userVolume.setAppid(rs.getString("appid"));
                userVolume.setDefSize(rs.getInt("def_size"));
                userVolume.setMaxSize(rs.getInt("max_size"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                userVolume.setExpireTime(sdf.parse(rs.getString("expire_time")));
                return userVolume;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            super.closeConnection();
        }
        return null;
    }
}
