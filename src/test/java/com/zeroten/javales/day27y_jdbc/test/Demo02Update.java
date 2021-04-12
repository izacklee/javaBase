package com.zeroten.javales.day27y_jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// 更新数据
public class Demo02Update {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 1 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "root";
            // 2 访问协议与获取连接
            conn = DriverManager.getConnection(url, user, password);
            // 3 组装sql
            String sql = "Update dept SET dname = ?, loc = ? WHERE deptno = ?";
            // 4 建立查询通道
            PreparedStatement ps = conn.prepareStatement(sql);
            // 5 给占位符设置值
            ps.setObject(1, "TECHNOLOGY");
            ps.setObject(2, "SHANGHAI");
            ps.setObject(3, 108);
            // 6 执行sql 返回影响行数
            int r = ps.executeUpdate();
            System.out.println(r);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
