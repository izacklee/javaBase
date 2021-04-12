package com.m.dao.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 数据库操作基础类
public abstract class BaseDao {
    private String driver = "com.mysql.jdbc.Driver";
    // url指定编码解决中文乱码问题
    private String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
    private String username = "root";
    private String password = "root";

    private static Connection conn = null;

    public BaseDao() {
        // 加载驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 访问协议和获取数据库连接
    public Connection getConnection() throws SQLException {
        // 不能使用synchronized会出现无法获取到数据库连接
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    // 关闭连接
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
