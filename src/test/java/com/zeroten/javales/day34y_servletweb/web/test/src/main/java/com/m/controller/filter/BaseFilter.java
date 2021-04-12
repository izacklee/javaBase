package com.m.controller.filter;

import com.m.controller.BooksController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

public class BaseFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hreq = (HttpServletRequest) request;
        HttpServletResponse hres = (HttpServletResponse) response;
        HttpSession session = hreq.getSession();
        String uri = hreq.getRequestURI();

        // 统一设置字符编码
        hreq.setCharacterEncoding("UTF-8");

//        /books/list.do
        String[] uriArr = uri.split("/");
//        System.out.println(Arrays.toString(uriArr));
        String nameSpace = uriArr[1];
        String method = uriArr[2];

        try {
            if ("books".equals(nameSpace)) {
                BooksController books = new BooksController();
                books.setRequest(hreq);
                books.setResponse(hres);
                books.setSession(session);
                if ("list.do".equals(method)) {
                    books.list();
                } else if("insert.do".equals(method)) {
                    books.insert();
                } else if("update.do".equals(method)) {
                    books.update();
                } else if("delete.do".equals(method)) {
                    books.delete();
                } else if("save.do".equals(method)) {
                    books.save();
                }
            } else {
                throw new Exception("404 页面未找到！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
