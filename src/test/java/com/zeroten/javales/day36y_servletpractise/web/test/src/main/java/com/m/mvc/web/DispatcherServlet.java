package com.m.mvc.web;

import com.m.mvc.context.XMLApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class DispatcherServlet implements Servlet {
    
    private List<HanderMapping> handerMappingList;
    private void initHanserMapping() {
        // 1.在请求抵达以后，所有的handerMapping已经映射完毕
        this.handerMappingList = BeanFacotry.getHanderMapping();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        initHanserMapping();
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

//        String uri = hreq.getRequestURI();
//        String[] uris = uri.split("/");
//        String controllerName = uris[1];
//        String methodName = uris[2].replaceAll(".do","");
//
//        XMLApplicationContext xmlac = new XMLApplicationContext(); // 从容器当中获取类的方法执行
//        Object obj = xmlac.getBean(controllerName);
//        try {
//            Method method = obj.getClass().getMethod(methodName);
//            method.invoke(obj);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        
        for (HanderMapping hm : handerMappingList) {
            // 获取所有的hander，要匹配出对应的类型
            HanderChain hc = hm.getHander(hreq, hres);
            if (hc != null) {
                ModelAndView mv = hc.chain();
                
                // 完成响应阶段
                // ...
                break;
                
            }
            
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
