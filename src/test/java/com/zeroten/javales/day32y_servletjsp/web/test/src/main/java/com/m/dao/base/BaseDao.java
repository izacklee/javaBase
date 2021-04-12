package com.m.dao.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 封装数据库的基础操作
public abstract class BaseDao {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test";
    private String user = "root";
    private String password = "root";
    private Connection conn = null;
    
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
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    
    // 关闭数据库连接
    protected void closeConnection() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
}
