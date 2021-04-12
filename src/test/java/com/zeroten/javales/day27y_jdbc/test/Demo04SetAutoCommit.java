package com.zeroten.javales.day27y_jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// JDBC事务管理操作
public class Demo04SetAutoCommit {

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
            ps.setObject(1, 110);
            ps.setObject(2, "SALES50");
            ps.setObject(3,"BEIJING");
            // 返回影响的行数
            int r = ps.executeUpdate();
            if (r == 1) {
//                int i = 1/0; // 假设异常
                // 手动提交
                conn.commit();
            }
            System.out.println(r);
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
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
