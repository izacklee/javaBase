package com.m.service;

import com.m.entity.Books;
import com.m.entity.Page;

import java.util.List;

public interface BooksService {
    public Page getPage(Books books, Page page);
    public int insert(Books books);
    public int update(Books books);
    public int delete(Books books);
    public List<Books> queryByPar(Books books, Page page);

}
