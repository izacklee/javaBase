package com.m.dao.impl;

import com.m.dao.FileHistoryDao;
import com.m.dao.base.BaseDao;
import com.m.entity.FileHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileHistoryDaoImpl extends BaseDao implements FileHistoryDao {
    @Override
    public int insertFileHistory(FileHistory fh) {
        Connection conn = null;
        try {
            conn = super.getConnection();
            conn.setAutoCommit(false);

            StringBuffer sql = new StringBuffer();
            sql.append("INSERT INTO file_history ");
            sql.append("(file_name, file_path, file_type, file_size, history_status, appid) ");
            sql.append("VALUES ");
            sql.append("(?, ?, ?, ?, ?, ?) ");

            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setObject(1, fh.getFileName());
            ps.setObject(2, fh.getFilePath());
            ps.setObject(3, fh.getFileType());
            ps.setObject(4, fh.getFileSize());
            ps.setObject(5, 0);
            ps.setObject(6, fh.getAppid());

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
    public int updateFileHistory(FileHistory fh) {

        Connection conn = null;
        try {
            conn = super.getConnection();
            conn.setAutoCommit(false);

            StringBuffer sql = new StringBuffer();
            sql.append("UPDATE file_history ");
            sql.append("SET history_status = ? ");
            sql.append("WHERE appid = ? AND file_name = ? AND file_path = ?");
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setObject(1, fh.getHistoryStatus());
            ps.setObject(2, fh.getAppid());
            ps.setObject(3, fh.getFileName());
            ps.setObject(4, fh.getFilePath());

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
}
