package com.m.controller.base;

import com.m.controller.BaseController;
import com.m.controller.BooksController;
import com.m.controller.UserController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

public class BaseServlet implements Servlet {

    public BaseServlet() {
    }

    private String charSetContent;
    private ServletContext application;
    private ServletConfig conf;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        charSetContent = config.getInitParameter("charSetContent");
        application = config.getServletContext();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding(charSetContent); // 动态指定业务字符集
        HttpServletRequest hreq = (HttpServletRequest) req;
        HttpServletResponse hres = (HttpServletResponse) res;
        HttpSession session = hreq.getSession();
        

        String uri = hreq.getRequestURI();
        String[] uriItems = uri.split("/");
        String controllerClass = uriItems[1];
        String method = uriItems[2];
        if ("user".equals(controllerClass)) {
            UserController user = new UserController();
            user.setApplication(application);
            user.setHreq(hreq);
            user.setHres(hres);
            user.setSession(session);
            
            if ("insert.do".equals(method)) {
                user.insert();
            } else if ("update.do".equals(method)) {
                user.update();
            } else if ("delete.do".equals(method)) {
                user.delete();
            } else if ("select.do".equals(method)) {
                user.select();
            } else if ("ajax.do".equals(method)) {
                user.ajax();
            }
        } else if ("books".equals(controllerClass)) {
            BooksController books = new BooksController();
        }

    }

    // 可选方法
    @Override
    public ServletConfig getServletConfig() {
        return this.conf;
    }

    // 可选方法
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
