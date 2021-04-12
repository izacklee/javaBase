package com.m.service.impl;

import com.m.dao.BlogDao;
import com.m.dao.impl.BlogDaoImpl;
import com.m.entity.Blog;
import com.m.service.BlogService;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    private BlogDao blogDao = new BlogDaoImpl();
    @Override
    public int insert(Blog blog) {
        if (blog == null) {
            blog = new Blog();
        }
        return blogDao.insert(blog);
    }

    @Override
    public int delete(Blog blog) {
        if (blog == null) {
            blog = new Blog();
        }
        return blogDao.delete(blog);
    }

    @Override
    public List<Blog> queryByPar(Blog blog) {
        if (blog == null) {
            blog = new Blog();
        }
        return blogDao.queryByPar(blog);
    }
}
