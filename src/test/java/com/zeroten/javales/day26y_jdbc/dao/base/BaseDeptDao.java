package com.zeroten.javales.day26y_jdbc.dao.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// base层作用：封装数据库的基础操作
public abstract class BaseDeptDao {

    private String driver;
    private String url;
    private String user;
    private String pwd;
    private Connection conn = null;

    public BaseDeptDao() {
        // JDK 提供的读取properties文件的API
        Properties p = new Properties();
        String path = BaseDeptDao.class.getClassLoader().getResource("jdbc.properties").getPath();
        try {
            // 加载配置文件
            p.load(new FileInputStream(new File(path)));
            driver = p.getProperty("DRIVER");
            url = p.getProperty("URL");
            user = p.getProperty("USER");
            pwd = p.getProperty("PASSWORD");
            // 加载驱动
            Class.forName(driver);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // 访问协议获取连接
    protected Connection getConnection() throws SQLException {
        conn = DriverManager.getConnection(url, user, pwd);
        return conn;
    }

    // 关闭连接
    protected void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
