package com.m.dao;

import com.m.entity.Books;
import com.m.entity.Page;

import java.util.List;

public interface BooksDao {
    public int insert(Books books);
    public int update(Books books);
    public int delete(Books book);
    public List<Books> queryByPar(Books book, Page page);

}
