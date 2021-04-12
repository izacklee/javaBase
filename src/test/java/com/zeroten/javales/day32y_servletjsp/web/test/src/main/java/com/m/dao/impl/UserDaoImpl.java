package com.m.dao.impl;

import com.m.dao.UserDao;
import com.m.dao.base.BaseDao;
import com.m.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 表的基本数据操作实现类

/**
 * 只负责数据的读写
*/
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int insertUser(User user) {
        try {
            Connection conn = super.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO user (username, password, real_name) VALUES (?, MD5(?), ?)");
            PreparedStatement rs = conn.prepareStatement(sql.toString());
            // 设置值
            rs.setObject(1, user.getUsername());
            rs.setObject(2, user.getPassword());
            rs.setObject(3, user.getRealName());
            // 执行sql
            return rs.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            super.closeConnection();
        }
        return 0;
    }

    @Override
    public int updateUser(User user) {

        try {
            // 获取协议与连接数据库
           Connection conn = super.getConnection();
           // 组装sql
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE user SET password = MD5(?) WHERE username = ?");
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setObject(1, user.getPassword());
            ps.setObject(2, user.getUsername());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            super.closeConnection();
        }
        return 0;
    }

    @Override
    public int deleteUser(User user) {
        return 0;
    }

    @Override
    public List<User> queryUser(User user) {
        List<User> list = new ArrayList<>();
        try {
            // 获取协议与连接数据库
            Connection conn = super.getConnection();
            // 组装sql
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT id,  username, real_name FROM user WHERE 1=1 ");
            if (user.getId() != null) {
                sql.append(" AND id = ? ");
            }
            if (user.getUsername() != null) {
                sql.append(" AND username = ? ");
            }
            if (user.getPassword() != null) {
                sql.append(" AND password = MD5(?) ");
            }

            if (user.getRealName() != null) {
                sql.append(" AND real_name like ? ");
            }
            // 建立查询通道
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            // 设置值
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

            if (user.getRealName() != null) {
                ps.setObject(++index, "%" + user.getRealName() + "%");
            }

            // 执行sql，返回结果集
            ResultSet rs = ps.executeQuery();

            // 遍历结果集存入集合
            while(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setRealName(rs.getString("real_name"));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            super.closeConnection();
        }
        return list;
    }
}
