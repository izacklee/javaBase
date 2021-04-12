package com.m.dao.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDao {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/blog?characterEncoding=utf8";
    private String username = "root";
    private String password = "root";

    private static Connection conn = null;

    public BaseDao() {
        try {
            // 加载驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取数据库连接
    protected Connection getConnection() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    // 关闭数据库连接
    protected void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
