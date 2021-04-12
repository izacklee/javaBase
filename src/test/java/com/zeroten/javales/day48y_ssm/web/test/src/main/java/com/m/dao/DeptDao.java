package com.m.dao;

import com.m.entity.Dept;

import java.util.List;

public interface DeptDao {

    public List<Dept> selectDept(Dept dept);
    public int insertDept(Dept dept);
    public int insertDepts(List<Dept> depts);
}
