package com.zeroten.javales.day26y_jdbc.test;

import java.sql.*;

// SQL 注入
public class Demo02JDBCCreateStatement {

    public static void main(String[] args) {
        // SQL注入 就是给SQL加入特殊的恒等式后 可以获取所有的数据 存在不安全隐患
        query("73691111 OR 1 = 1");
    }

    public static void query(String emp) {
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
            // 3.获取Statement statement存在安全隐患：sql注入
            Statement stm = conn.createStatement();
            // 4.执行sql 并返回结果集
            ResultSet result = stm.executeQuery("SELECT empno em, ename, hiredate FROM emp WHERE " +
                    "empno = " + emp);
            // 5.遍历查询结果
            while (result.next()) {
                // 以别名为标准获取
//                int empno = result.getInt("em");
                // 通过列名的位置获取
                int empno = result.getInt(1);
                System.out.print("员工号：" + empno + " | ");
                String ename = result.getString("ename");
                System.out.print("姓名：" + ename + " | ");
                Date date = result.getDate("hiredate");
                System.out.println("入职日期：" + date);
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
