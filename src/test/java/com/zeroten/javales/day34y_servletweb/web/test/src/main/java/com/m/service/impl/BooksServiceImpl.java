package com.m.service.impl;

import com.m.dao.BooksDao;
import com.m.dao.impl.BooksDaoImpl;
import com.m.entity.Books;
import com.m.entity.Page;
import com.m.service.BooksService;

import java.util.List;

public class BooksServiceImpl implements BooksService {

    private BooksDao dao = new BooksDaoImpl();

    @Override
    public int insert(Books books) {
        if (books == null) {
            books = new Books();
        }
        return dao.insert(books);
    }

    @Override
    public int update(Books books) {
        if (books == null) {
            books = new Books();
        }
        return dao.update(books);
    }

    @Override
    public int delete(Books books) {
        if (books == null) {
            books = new Books();
        }
        return dao.delete(books);
    }

    @Override
    public List<Books> queryByPar(Books books, Page page) {
        if (books == null) {
            books = new Books();
        }
        return dao.queryByPar(books,page);
    }

    @Override
    public Page getPage(Books books,Page page) {
        page.setSize(2);
        Integer count = this.queryByPar(books,page).size();
        page.setCount(count);
        page.setPageCount(page.getCount() == 0 ? 1 : (  // 如果总记录数为0当前页为1
                page.getCount() % page.getSize() == 0
                      ? page.getCount() / page.getSize()
                      :  Integer.valueOf(page.getCount() / page.getSize()) + 1)
        );
        page.setOffset((page.getPageNumber() - 1) * page.getSize());
        return page;
    }
}
