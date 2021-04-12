package com.zeroten.javales.day26y_jdbc.dao;

import com.zeroten.javales.day26y_jdbc.entity.Dept;

import java.util.List;

public interface TestDeptDao {
    public List<Dept> queryDeptByPar(Dept dept);
}
