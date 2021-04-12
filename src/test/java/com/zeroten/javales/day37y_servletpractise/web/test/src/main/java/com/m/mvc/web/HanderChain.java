package com.m.mvc.web;

import com.m.mvc.context.XMLApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 负责具体的业务调用
 * */
public class HanderChain { // 当前访问的执行流程（调用）
    
    // 拦截器集合
    List<HanderInterceptor> interceptorList = new ArrayList<>();
    
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

    public HanderChain(String name, String method, Class<?>[] partypes,
                       HttpServletRequest hreq, HttpServletResponse hres, List<HanderInterceptor> interceptorList) {
        this.name = name;
        this.method = method;
        this.partypes = partypes;
        this.request = hreq;
        this.response = hres;
        this.session = hreq.getSession();
        this.application = this.session.getServletContext();

    }

    private Map<String,String[]> requestMap = new HashMap<>();

    /**
     * 检查是否是文件上传
     * @return true是文件上传/false不是文件上传
     */
    private boolean isFileUpload() {
        return false;
    }

    /**
     * 获取get或者post传递过来的请求参数
     */
    private void getRequestMap() {
        // 获取所有的请求参数
        if (!this.isFileUpload()) { // 获取非文件上传的请求参数
            requestMap = this.request.getParameterMap();
        } else {

        }
    }

    private ModelAndView sendParametersByFileUpload() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    /**
     * 往hander的方法当中，提交参数，这一部分参数，
     * 有的来自于请求 requestMap，
     * 有的来自于服务器本身 3大域+response，
     * 有的来自于框架规则 ModelMapping  
     * * @return
     */
    @SuppressWarnings({"rawtypes","unchecked"})  // 忽略多类型警告
    private ModelAndView sendParametersByNoFileUpload() {
        ModelAndView mv = new ModelAndView();
        try {
            XMLApplicationContext ac = new XMLApplicationContext();
            // 获取要操作的hander
            this.hander = ac.getBean(name);

            // 获取要操作的方法
            Method method = this.hander.getClass().getMethod(this.method, this.partypes);

            // 获取所有参数
            Parameter[] ps = method.getParameters();

            List pars = new ArrayList(); // 要执行的参数
            ModelMapping model = new ModelMapping(); // 结果的model
            for (Parameter p : ps) {
                RequestParam rp = p.getAnnotation(RequestParam.class); // 从注解中获取请求参数名
                String parname = "";
                if (rp != null) {
                    parname = rp.value();
                }
                Class<?> partype = p.getType();
                // 参数当中可能出现的情况
                // 3大域+response/ModelMapping/参数
                if (partype.getName().equals(HttpServletRequest.class.getName())) {
                    pars.add(request);
                } else if (partype.getName().equals(HttpServletResponse.class.getName())) {
                    pars.add(response);
                } else if (partype.getName().equals(HttpSession.class.getName())) {
                    pars.add(session);
                } else if (partype.getName().equals(ServletContext.class.getName())) {
                    pars.add(application);
                } else if (partype.getName().equals(ModelMapping.class.getName())) {
                    pars.add(model); // 给的是该对象地址
                } else {
                    if (partype.getName().equals(Byte.class.getName())) {
                        if (requestMap.get(parname) != null) {
                            // requestMap.get(parname)[0] = Zack
                            // 下面的构造等价于这个new Byte(String str);
                            pars.add(Byte.class.getConstructor(String.class).newInstance(requestMap.get(parname)[0]));
                        } else {
                            pars.add(null);
                        }
                    } else if (partype.getName().equals(Short.class.getName())) {
                        if (requestMap.get(parname) != null) {
                            pars.add(Short.class.getConstructor(String.class).newInstance(requestMap.get(parname)[0]));
                        } else {
                            pars.add(null);
                        }
                    } else if (partype.getName().equals(Integer.class.getName())) {
                        if (requestMap.get(parname) != null) {
                            pars.add(Integer.class.getConstructor(String.class).newInstance(requestMap.get(parname)[0]));
                        } else {
                            pars.add(null);
                        }
                    } else if (partype.getName().equals(Long.class.getName())) {
                        if (requestMap.get(parname) != null) {
                            pars.add(Long.class.getConstructor(String.class).newInstance(requestMap.get(parname)[0]));
                        } else {
                            pars.add(null);
                        }
                    } else if (partype.getName().equals(Float.class.getName())) {
                        if (requestMap.get(parname) != null) {
                            pars.add(Float.class.getConstructor(String.class).newInstance(requestMap.get(parname)[0]));
                        } else {
                            pars.add(null);
                        }
                    } else if (partype.getName().equals(Double.class.getName())) {
                        if (requestMap.get(parname) != null) {
                            pars.add(Double.class.getConstructor(String.class).newInstance(requestMap.get(parname)[0]));
                        } else {
                            pars.add(null);
                        }
                    } else if (partype.getName().equals(Boolean.class.getName())) {
                        if (requestMap.get(parname) != null) {
                            pars.add(Boolean.class.getConstructor(String.class).newInstance(requestMap.get(parname)[0]));
                        } else {
                            pars.add(null);
                        }
                    } else if (partype.getName().equals(String.class.getName())) {
                        if (requestMap.get(parname) != null) {
                            pars.add(requestMap.get(parname)[0]);
                        } else {
                            pars.add(null);
                        }
                    } else if (partype.getName().equals(String[].class.getName())) {
                        if (requestMap.get(parname) != null) {
                            pars.add(requestMap.get(parname)[0]);
                        } else {
                            pars.add(null);
                        }
                    } else if (partype.getName().equals(Date.class.getName())) {
                        if (requestMap.get(parname) != null) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 时间默认格式
                            pars.add(sdf.parse(requestMap.get(parname)[0]));
                        } else {
                            pars.add(null);
                        }
                    }
                }

            }
            // 执行hander之前，要执行所有的拦截器pre
            for (HanderInterceptor interceptor : interceptorList) {
                interceptor.pre(request, response);
            }
            // 执行方法
            Object result = method.invoke(this.hander,pars.toArray());

            // 执行model返回之前，要执行所有的拦截器post
            for (HanderInterceptor interceptor : interceptorList) {
                interceptor.post(request, response);
            }

            // ModelMapping已经有值了
            // result:ModelAndView,View,String,Object
            ResponseBody rb = method.getAnnotation(ResponseBody.class);
            if (rb == null) {
                mv.setModel(model);
                if (result instanceof View) {
                    mv.setView((View) result);
                } else if (result instanceof String) {
                    View view = new View();
                    view.setSendPath((String) result);
                    mv.setView(view);
                } else if (result instanceof ModelAndView) {
                    mv = (ModelAndView) result;
                }
                mv.setRest(false); // 非response响应
            } else {
                mv.setRestObj(result); // 要通过响应流写出去的值
                mv.setRest(true); // response响应
            }

            // 执行model返回之后，要执行所有的拦截器after
            for (HanderInterceptor interceptor : interceptorList) {
                interceptor.after(request, response);
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  mv;
    }

    public ModelAndView chain() {
        this.getRequestMap(); // 获取所有get/post请求参数
        if (this.isFileUpload()) {
            return this.sendParametersByFileUpload(); // 是文件上传的参数封装
        } else {
            return this.sendParametersByNoFileUpload(); // 不是文件上传的参数封装
        }
    }
}
