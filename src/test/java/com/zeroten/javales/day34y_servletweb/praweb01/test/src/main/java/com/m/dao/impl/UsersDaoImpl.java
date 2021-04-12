package com.m.dao.impl;

import com.m.dao.UsersDao;
import com.m.dao.base.BaseDao;
import com.m.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl extends BaseDao implements UsersDao {
    @Override
    public int insert(Users users) {
        Connection conn = null;
        try {
            conn = super.getConnection();
            // 开启事务
            conn.setAutoCommit(false);

            String sql = "INSERT INTO users (username, `password`, age, sex, nickname," +
                    " mobile, address, supper, picpath) VALUES (?, MD5(?), ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setObject(1, users.getUsername());
            ps.setObject(2, users.getPassword());
            ps.setObject(3, users.getAge());
            ps.setObject(4, users.getSex());
            ps.setObject(5, users.getNickname());
            ps.setObject(6, users.getMobile());
            ps.setObject(7, users.getAddress());
            ps.setObject(8, users.getSupper());
            ps.setObject(9, users.getPicpath());

            int r = ps.executeUpdate();

            // 事务提交
            conn.commit();

            return r;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            if (conn != null) {
                try {
                    // 事务回滚
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            super.closeConnection();
        }
        return 0;
    }

    @Override
    public int update(Users users) {
        Connection conn = null;
        try {
            conn = super.getConnection();
            // 开启事务
            conn.setAutoCommit(false);

            String sql = "UPDATE users SET password = MD5(?) WHERE id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, users.getId());

            int r = ps.executeUpdate();
            // 提交事务
            conn.commit();

            return r;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            // 事务回滚
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    @Override
    public int delete(Users users) {
        Connection conn = null;
        try {
            conn = super.getConnection();
            // 开启事务
            conn.setAutoCommit(false);

            String sql = "DELETE FROM users WHERE id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, users.getId());
            int r = ps.executeUpdate();

            // 提交事务
            conn.commit();

            return r;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            // 事务回滚
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            super.closeConnection();
        }

        return 0;
    }

    @Override
    public List<Users> queryByPar(Users users) {
        List<Users> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = super.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT username, age, sex, nickname, mobile, address," +
                    " supper, picpath FROM users WHERE 1 = 1 ");

            if (users.getUsername() != null) {
                sql.append(" AND username = ? ");
            }
            if (users.getNickname() != null) {
                sql.append(" AND nickname = ? ");
            }
            if (users.getMobile() != null) {
                sql.append(" AND mobile = ? ");
            }
            if (users.getAddress() != null) {
                sql.append(" AND address = ? ");
            }

            PreparedStatement ps = conn.prepareStatement(sql.toString());

            int index = 0;
            if (users.getUsername() != null) {
                ps.setObject(++index, users.getUsername());
            }
            if (users.getNickname() != null) {
                ps.setObject(++index, users.getNickname());
            }
            if (users.getMobile() != null) {
                ps.setObject(++index, users.getMobile());
            }
            if (users.getAddress() != null) {
                ps.setObject(++index, users.getAddress());
            }

           ResultSet rs =  ps.executeQuery();

            while(rs.next()) {
                users = new Users();
                users.setId(rs.getInt("id"));
                users.setUsername(rs.getString("username"));
                users.setNickname(rs.getString("nickname"));
                users.setPicpath(rs.getString("picpath"));
                users.setMobile(rs.getInt("mobile"));
                users.setAddress(rs.getString("address"));
                list.add(users);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            super.closeConnection();
        }
        return list;
    }
}
