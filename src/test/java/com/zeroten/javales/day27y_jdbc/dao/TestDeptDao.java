package com.zeroten.javales.day27y_jdbc.dao;

import com.zeroten.javales.day27y_jdbc.entity.Dept;

import java.util.List;

public interface TestDeptDao {
    public List<Dept> queryDeptByPar(Dept dept);
}
