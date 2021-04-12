package com.zeroten.javales.day27y_jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// 批量插入
// 可以批量插入，但不推荐，因为每次都要重新编译一下sql
public class Demo05Batch {

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
            // 3 打开事务管理
            conn.setAutoCommit(false);
            // 4 组装sql
            String sql = "INSERT INTO dept (deptno, dname, loc) VALUES (?, ?, ?)";
            // 5 建立查询通道
            PreparedStatement ps = conn.prepareStatement(sql);
            // 6 批量给占位符设置值
            int j = 0;
            for (int i=120; i<150; i+=10) {
                ps.setObject(1, i);
                ps.setObject(2, "TECHNOLOGY" + i);
                ps.setObject(3, "TECHNOLOGY" + i);
                // 7 执行sql
                int k = 0;
                j += k = ps.executeUpdate(); // 一次执行一条sql语句
                System.out.println(k);
                if (k == 1) {
                    // 8 提交事务
                    conn.commit();
                }
            }
            System.out.println(j);
        } catch (ClassNotFoundException e) {
            rollback(conn);
            e.printStackTrace();
        } catch (SQLException e) {
            rollback(conn);
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

    // 事务回滚
    public static void rollback(Connection conn) {
        if (conn !=null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
