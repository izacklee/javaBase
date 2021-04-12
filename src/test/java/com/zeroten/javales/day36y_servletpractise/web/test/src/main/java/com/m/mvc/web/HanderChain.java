package com.m.mvc.web;

import com.m.mvc.context.XMLApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 负责具体的业务调用
 * */
public class HanderChain { // 当前访问的执行流程（调用）
    
    // 拦截器集合
    
    // hander本身
    
    private String name;  // bean的name
    private String method; // bean的方法
    private Class<?>[] partypes;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private ServletContext application;
    private Object hander;
    public HanderChain() {}
    public HanderChain(String name, String method, Class<?>[] partypes,
                       HttpServletRequest hreq, HttpServletResponse hres) {
        this.name = name;
        this.method = method;
        this.partypes = partypes;
        this.request = hreq;
        this.response = hres;
        this.session = hreq.getSession();
        this.application = this.session.getServletContext();
        
    }
    
    public ModelAndView chain() {
        ModelAndView mv = new ModelAndView();
        // 获取所有的请求参数
        Map<String, String[]> requestMap = this.request.getParameterMap();
        XMLApplicationContext ac = new XMLApplicationContext();
        // 获取要操作的hander
        this.hander = ac.getBean(name);
        try {
            // 获取要操作的方法
            Method method = this.hander.getClass().getMethod(this.method, this.partypes);

            // 获取所有参数
            Parameter[] ps = method.getParameters();
            List pars = new ArrayList<>(); // 要执行的参数
            ModelMapping model = new ModelMapping(); // 结果的model
            for (Parameter p : ps) {
                Class<?> partype = p.getType();
                String parname = p.getName();
                // 参数当中可能出现的情况
                // 3大域+response/ModelMapping/UploadFile/参数
            }
            // 执行方法
            method.invoke(this.hander,pars.toArray());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return  mv;
    }
}
