package com.m.dao.impl;

import com.m.dao.FileCloudDao;
import com.m.dao.base.BaseDao;
import com.m.entity.FileCloud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileCloudDaoImpl extends BaseDao implements FileCloudDao {
    @Override
    public int insertFileCloud(FileCloud fc) {
        Connection conn = null;
        try {
            conn = super.getConnection();
            conn.setAutoCommit(false);

            StringBuffer sql = new StringBuffer();
            sql.append("INSERT INTO file_cloud ");
            sql.append("(file_name, file_path, file_type, file_size, file_status, appid) ");
            sql.append("VALUES ");
            sql.append("(?, ?, ?, ?, ?, ? )");
            PreparedStatement ps = conn.prepareStatement(sql.toString());

            ps.setObject(1, fc.getFileName());
            ps.setObject(2, fc.getFilePath());
            ps.setObject(3, fc.getFileType());
            ps.setObject(4, fc.getFileSize());
            ps.setObject(5, fc.getFileStatus());
            ps.setObject(6, fc.getAppid());

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
