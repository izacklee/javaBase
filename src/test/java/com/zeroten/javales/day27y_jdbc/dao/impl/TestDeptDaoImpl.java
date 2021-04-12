package com.zeroten.javales.day27y_jdbc.dao.impl;

import com.zeroten.javales.day27y_jdbc.dao.TestDeptDao;
import com.zeroten.javales.day27y_jdbc.dao.base.BaseDeptDao;
import com.zeroten.javales.day27y_jdbc.entity.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TestDeptDaoImpl extends BaseDeptDao implements TestDeptDao {
    public List<Dept> queryDeptByPar(Dept dept) {
        try {
            Connection conn = super.getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT deptno, dname, loc FROM dept WHERE 1 = 1 ");

            // 动态组装sql
            if (dept != null) {
                if (dept.getDeptno() !=null) {
                    sb.append("AND deptno = ?");
                }
                if (dept.getDname() != null) {
                    sb.append(" AND dname like ?");
                }
                if (dept.getLoc() != null) {
                    sb.append(" AND loc like ?");
                }
            }
            // 建立预编译查询通道
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            int index = 0;
            // 动态给占位符赋值
            if (dept != null) {
                if (dept.getDeptno() != null) {
                    ps.setObject(++index, dept.getDeptno());
                }
                if (dept.getDname() != null) {
                    ps.setObject(++index, "%" + dept.getDname() + "%");
                }
                if (dept.getLoc() != null) {
                    ps.setObject(++index, "%" + dept.getLoc() + "%");
                }
            }
            ResultSet rs = ps.executeQuery();
            // 遍历查询结果
            LinkedList<Dept> list = new LinkedList<>();
            while(rs.next()) {
                Dept d = new Dept();
                d.setDeptno(rs.getInt("deptno"));
                d.setDname(rs.getString("dname"));
                d.setLoc(rs.getString("loc"));
                list.add(d);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.closeConnection();
        }
        return null;
    }
}
