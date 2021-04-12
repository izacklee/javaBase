package com.m.mvc.web;

import com.m.mvc.context.XMLApplicationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 用于生产handerMapping的集合
 */
public class BeanFacotry {
    public static List<HanderInterceptor> getHanderInterceptor() {
        return null;
    }
    
    public static List<HanderMapping> getHanderMapping() {
        List<HanderMapping> hmlist = new ArrayList<>();
        // 1.过滤容器当中的对象
        XMLApplicationContext ac = new XMLApplicationContext();
        Set<String> beanNames = ac.getBeanNames();
        
        // 2.找到容器当中所有的bean
        for (String beanName : beanNames) {
            Object obj = ac.getBean(beanName);
            
            // 3.过滤这些bean，判断是否有Controller接口，有这个接口代表是Controller
            Class<?>[] is = obj.getClass().getInterfaces();
            for (Class i : is) {
//                System.out.println(i.getName()); // com.m.mvc.web.Controller
//                System.out.println(Controller.class.getName()); // com.m.mvc.web.Controller
                if (i.getName().equals(Controller.class.getName())) {
                    // 4.有Controller接口，则获取该Controller的MyRequestMapping.value
                    // 获取注解上的值
                    MyRequestMapping crm = obj.getClass().getAnnotation(MyRequestMapping.class);
                    String crmValue = crm.value();

                    // 5.再获取该Controller所有的方法
                    Method[] ms = obj.getClass().getMethods();
                    for (Method m : ms) {
                        MyRequestMapping mrm = m.getAnnotation(MyRequestMapping.class);
                        if (mrm != null) { // 6.方法上有MyRequestMapping的注解，则需要映射到Mapping
                            String mrmValue = mrm.value();
                            HanderMapping hm = new HanderMapping();
                            hm.setName(beanName); // 获取beanName
                            hm.setMethod(m.getName()); // 获取请求的方法名
                            hm.setPartypes(m.getParameterTypes()); // 该方法的所有参数类型
                            hm.setMapping(crmValue + mrmValue); // 映射rui
                            
                            hmlist.add(hm); // 所有的handerMapping加入映射关系

//                            System.out.println("往容器中加入映射：" + hm.getMapping());
                        }
                    }
                }
            }
    
        }
        

        return hmlist;
    }
}
