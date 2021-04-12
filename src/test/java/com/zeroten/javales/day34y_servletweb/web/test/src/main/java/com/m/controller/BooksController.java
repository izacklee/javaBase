package com.m.controller;

import com.m.controller.base.BaseController;
import com.m.entity.Books;
import com.m.entity.Page;
import com.m.service.impl.BooksServiceImpl;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class BooksController extends BaseController {
    private BooksServiceImpl service = new BooksServiceImpl();

    // 列表
    public void list() throws Exception {
        Books books = new Books();
        Page page = new Page();
        // 计算page条件
        String pageNumberStr = super.getRequest().getParameter("pageNumber");
        if (pageNumberStr == null) {
            pageNumberStr = "1";
        }
//        books.setAuthor("Zack");
        page.setPageNumber(Integer.valueOf(pageNumberStr));
        page = service.getPage(books, page); // 获取page  传books的目的为了方便增加过滤条件

        List<Books> booksList = service.queryByPar(books, page);
        super.getRequest().setAttribute("booksList", booksList);
        super.getRequest().setAttribute("page", page);
        super.getRequest().getRequestDispatcher("/jsp/booksList.jsp")
                .forward(super.getRequest(),super.getResponse());
    }

    // 新增
    public void insert() throws Exception {
        super.getRequest().getRequestDispatcher("/jsp/post.jsp")
                .forward(super.getRequest(),super.getResponse());
    }

    // 修改
    public void update() throws Exception {
        String id = super.getRequest().getParameter("id");
        Books books = new Books();
        if (id != null) {
            books.setId(Integer.valueOf(id));
            List<Books> booksList = service.queryByPar(books, null);
            if (booksList.size() == 1) {
                books = booksList.get(0);
                super.getRequest().setAttribute("books", books);
                super.getRequest().getRequestDispatcher("/jsp/post.jsp")
                        .forward(super.getRequest(), super.getResponse());
                return; // 防止重复转发
            } else {
                super.getRequest().setAttribute("result", "error");
            }

        } else {
            super.getRequest().setAttribute("result", "error");
        }
        super.getResponse().sendRedirect("/books/list.do");

    }

    // 删除
    public void delete() throws Exception {
        String id = super.getRequest().getParameter("id");
        Books books = new Books();
        if (id != null) {
            books.setId(Integer.valueOf(id));
            int r = service.delete(books);
            if (r == 1) {
                super.getRequest().setAttribute("result", "success");
            } else {
                super.getRequest().setAttribute("result", "error");
            }
        } else {
            super.getRequest().setAttribute("result", "error");
        }

        super.getResponse().sendRedirect("/books/list.do");
    }

    // 保存数据
    public void save() throws Exception {
        String id = super.getRequest().getParameter("id");
        String name = super.getRequest().getParameter("name");
        String author = super.getRequest().getParameter("author");
        Books books = new Books();
        books.setName(name);
        books.setAuthor(author);
        int r = 0;
        if (!"".equals(id)) {  // 修改
            books.setId(Integer.valueOf(id));
            r = service.update(books);
        } else {  // 新增
            r = service.insert(books);
        }
        if (r == 1) {
            super.getRequest().setAttribute("result", "success");
            super.getResponse().sendRedirect("/books/list.do");
            return;
        }
        super.getRequest().setAttribute("result","error");
        super.getRequest().getRequestDispatcher("/jsp/post.jsp")
                .forward(super.getRequest(),super.getResponse());
    }


}
