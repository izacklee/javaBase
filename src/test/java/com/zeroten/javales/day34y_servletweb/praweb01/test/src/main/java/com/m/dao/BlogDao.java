package com.m.dao;

import com.m.entity.Blog;

import java.util.List;

public interface BlogDao {
    public int insert(Blog blog);
    public int delete(Blog blog);
    public List<Blog> queryByPar(Blog blog);
}
