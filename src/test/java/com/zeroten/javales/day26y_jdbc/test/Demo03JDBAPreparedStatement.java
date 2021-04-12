package com.zeroten.javales.day26y_jdbc.test;

import java.sql.*;

// 预编译
public class Demo03JDBAPreparedStatement {
    public static void main(String[] args) {
        // SQL注入 就是给SQL加入特殊的恒等式后 可以获取所有的数据
//        query("20","MANAGER");
        query("30 OR 1 = 1","MANAGER");
    }

    public static void query(String deptno, String job) {
        // 1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String user = "root";
        String password = "root";
        Connection conn = null;
        try {
            // 2.获取与数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",user, password);
            // 3.获取Statement PreparedStatement防可sql注入
            PreparedStatement ps = conn.prepareStatement("SELECT deptno, job FROM emp WHERE " +
                    "deptno =  ? AND job = ? ");
//            ps.setInt(1, Integer.valueOf(deptno));
            // 4.设置值
            ps.setString(1, deptno);
            ps.setString(2, job);
            // 5.执行sql 并返回结果集
            ResultSet result = ps.executeQuery();
            // 6.遍历查询结果
            while (result.next()) {
                Integer no = result.getInt("deptno");
                System.out.print("部门：" + no + " | ");
                String j = result.getString("job");
                System.out.print("工作：" + j);
            }
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
