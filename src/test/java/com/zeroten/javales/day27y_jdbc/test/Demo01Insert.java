package com.zeroten.javales.day27y_jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// 添加数据
public class Demo01Insert {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 1 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "root";
            // 2 访问协议获取连接
            conn = DriverManager.getConnection(url,user,password);
            // 3 组装sql
            String sql= "INSERT INTO dept (deptno, dname, loc) VALUES (?, ?, ?)";
            // 4 建立查询通道
            PreparedStatement ps = conn.prepareStatement(sql);
            // 5 给占位符填值
            ps.setObject(1, 107);
            ps.setObject(2, "SALES50");
            ps.setObject(3,"BEIJING");
            // 执行sql 返回本次修改影响的行数
            int r = ps.executeUpdate();
            System.out.println(r); // 1
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
