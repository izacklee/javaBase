package com.zeroten.javales.day28y_jdbc.test;

import com.zeroten.javales.day28y_jdbc.vo.EmpAndDeptVo;

import java.sql.*;

public class Demo01Inner {

    public static void main(String[] args) {
        // 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";
        Connection conn = null;
        try {
            // 获取与数据库连接
            conn = DriverManager.getConnection(url, user, password);
            StringBuilder sql = new StringBuilder("SELECT e.empno, e.ename, d.dname, " +
                    "d.deptno FROM emp e, dept d WHERE e.deptno = d.deptno");
            PreparedStatement ps = conn.prepareStatement(sql.toString());

            // 执行sql 并返回结果集
            ResultSet rs = ps.executeQuery();
            // 遍历查询结果
            while (rs.next()) {
                EmpAndDeptVo vo = new EmpAndDeptVo();
                vo.setEmpno(rs.getInt("empno"));
                vo.setEname(rs.getString("ename"));
                vo.setDname(rs.getString("dname"));
                vo.setDeptno(rs.getInt("deptno"));
                System.out.println(vo);
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
