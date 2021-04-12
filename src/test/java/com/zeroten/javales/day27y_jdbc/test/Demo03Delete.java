package com.zeroten.javales.day27y_jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// 数据删除
public class Demo03Delete {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 1 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2 访问协议与获取连接
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);
            // 3 组装sql
            String sql = "DELETE FROM dept WHERE deptno = ?";
            // 4 建立查询通道
            PreparedStatement ps = conn.prepareStatement(sql);
            // 5 给占位符填值
            ps.setObject(1, 106);
            // 6 执行sql
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
