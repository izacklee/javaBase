package com.m.service;

import com.m.entity.Blog;

import java.util.List;

public interface BlogService {
    public int insert(Blog blog);
    public int delete(Blog blog);
    public List<Blog> queryByPar(Blog blog);
}
