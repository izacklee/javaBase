package com.m.dao.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库基础操作类
 */
public abstract class BaseDao {
    private String driver="com.mysql.jdbc.Driver";
    // url指定编码解决中文乱码问题
    private String url="jdbc:mysql://localhost:3306/file_cloud?characterEncoding=utf8";
    private String username="root";
    private String password="root";

    private static Connection conn = null;

    /**
     * 使用静态代码块注册数据库驱动，保证只注册一次
     */
//    static {
//        try {
//            // 加载驱动
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public BaseDao() {
        try {
            // 加载驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     */
    protected Connection getConnection() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    /**
     * 关闭数据库连接
     */
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

