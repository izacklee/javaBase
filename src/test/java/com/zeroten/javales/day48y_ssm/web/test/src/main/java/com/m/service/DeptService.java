package com.m.service;

import com.m.entity.Dept;

import java.util.List;

public interface DeptService {

    public List<Dept> selectDept(Dept dept);
    public int insertDept(Dept dept);
    public int insertDepts(List<Dept> depts);
}
