package com.m.mvc.web;

import com.m.mvc.context.XMLApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DispatcherServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        HttpServletRequest hreq = (HttpServletRequest) req;
        HttpServletResponse hres = (HttpServletResponse) res;
        HttpSession session = hreq.getSession();
        ServletContext application = session.getServletContext();

        String uri = hreq.getRequestURI();
        String[] uris = uri.split("/");
        String controllerName = uris[1];
        String methodName = uris[2].replaceAll(".do","");

        XMLApplicationContext xmlac = new XMLApplicationContext(); // 从容器当中获取类的方法执行
        Object obj = xmlac.getBean(controllerName);
        try {
            Method method = obj.getClass().getMethod(methodName);
            method.invoke(obj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
