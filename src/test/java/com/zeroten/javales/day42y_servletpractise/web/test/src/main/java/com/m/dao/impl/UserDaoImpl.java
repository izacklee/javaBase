package com.m.dao.impl;

import com.m.dao.UserDao;
import com.m.dao.base.BaseDao;
import com.m.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int insertUser(User user) {

        Connection conn = null;
        try {
            // user表是MyISAM引擎，所以不需要用事务，也不支持事务
           conn = super.getConnection();
           conn.setAutoCommit(false);

           String sql = "INSERT INTO user (username, password, realname, appid) VALUES (?, MD5(?), ?, ?)";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setObject(1, user.getUsername());
           ps.setObject(2, user.getPassword());
           ps.setObject(3, user.getRealname());
           ps.setObject(4, user.getAppid());

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
    public User queryUser(User user) {
        try {
            Connection conn = super.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT id, username, password, realname, appid, create_time " +
                    " update_time FROM user WHERE 1 = 1 ");

            if (user.getId() != null) {
                sql.append(" AND id = ? ");
            }
            if (user.getUsername() != null) {
                sql.append(" AND username = ? ");
            }
            if (user.getPassword() != null) {
                sql.append(" AND password = MD5(?) ");
            }
            if (user.getRealname() != null) {
                sql.append(" AND realname LIKE ? ");
            }
            if (user.getAppid() != null) {
                sql.append(" AND appid = ? ");
            }

            PreparedStatement ps = conn.prepareStatement(sql.toString());
            int index = 0;
            if (user.getId() != null) {
                ps.setObject(++index, user.getId());
            }
            if (user.getUsername() != null) {
                ps.setObject(++index, user.getUsername());
            }
            if (user.getPassword() != null) {
                ps.setObject(++index, user.getPassword());
            }
            if (user.getRealname() != null) {
                ps.setObject(++index, "%" + user.getRealname() + "%");
            }
            if (user.getAppid() != null) {
                ps.setObject(++index, user.getAppid());
            }

            ResultSet rs = ps.executeQuery();

            // 因只有一条数据，所以可以不用循环
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setRealname(rs.getString("realname"));
                user.setAppid(rs.getString("appid"));
//                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                user.setCreateTime(sf.parse(rs.getString("createTime")));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            super.closeConnection();
        }

        return null;
    }
}
