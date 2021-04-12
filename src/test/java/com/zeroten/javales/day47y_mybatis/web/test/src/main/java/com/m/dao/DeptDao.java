package com.m.dao;

import com.m.entity.Dept;

import java.util.List;

public interface DeptDao {
    public int insert(Dept dept);
    public int insertList(List<Dept> depts);
    public int update(Dept dept);
    public int delete(int deptno);
    public List<Dept> query(Dept dept);
    public Dept queryById(int deptno);
}
