package com.zeroten.javales.day27y_jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

// addBatch批量插入
public class Demo06ExecuteBatch {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url,user,password);

            // 打开事务管理
            conn.setAutoCommit(false); // 不自动提交

            String sql= "INSERT INTO dept (deptno, dname, loc) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i= 150; i<200; i+=10) {
                ps.setObject(1,i);
                ps.setObject(2,"SALES" + i);
                ps.setObject(3, "BEIJING" + i);
                ps.addBatch();
            }
            // 批量处理sql语句
            int[] r = ps.executeBatch();
            conn.commit();
            System.out.println(Arrays.toString(r));
        } catch (Exception e) {
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
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
