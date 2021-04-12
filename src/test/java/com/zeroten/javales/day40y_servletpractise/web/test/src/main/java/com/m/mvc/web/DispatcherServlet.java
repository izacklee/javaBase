package com.m.mvc.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m.mvc.context.XMLApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class DispatcherServlet implements Servlet {
    
    private List<HanderMapping> handerMappingList;
    private List<HanderInterceptor> interceptorList;
    
    private void initHanserMapping() {
        // 1.在请求抵达以后，所有的handerMapping已经映射完毕
        this.handerMappingList = BeanFacotry.getHanderMapping();
        this.interceptorList = BeanFacotry.getHanderInterceptor();
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
    public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
        HttpServletRequest hreq = (HttpServletRequest) req;
        HttpServletResponse hres = (HttpServletResponse) res;
        HttpSession session = hreq.getSession();
        ServletContext application = session.getServletContext();

        // 统一设置字符编码
        hreq.setCharacterEncoding("UTF-8");

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
                if (!mv.isRest()) {
                    ModelMapping mp = mv.getModel();
                    // 往request属性添加值
                    for (String key : mp.getKeys()) {
                        hreq.setAttribute(key, mp.get(key));
                    }
                    View view = mv.getView();
                    boolean isForward = true;
                    String path = view.getSendPath();
                    if (path.indexOf("forward:") != -1) {
                        // 1.正常转发
                        isForward = true;
                        path = path.replaceAll("forward:", "");
                    } else if (path.indexOf("redirect:") != -1) {
                        // 2.转发/重定向
                        isForward = false;
                        path = path.replaceAll("redirect:", "");
                    }
                    
                    if (isForward) {
                        hreq.getRequestDispatcher(path).forward(hreq, hres);
                    } else {
                        hres.sendRedirect(path);
                    }
                  
                } else {
                    // 3.rest:json输出  // 往外写
                    ObjectMapper om = new ObjectMapper();
                    String omStr = om.writeValueAsString(mv.getRestObj()); // 将对象转为字符串
                    hres.setContentType("text/html; charset=UTF-8");
                    PrintWriter writer = hres.getWriter();
                    writer.write(omStr);
                    writer.close();
                }

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
