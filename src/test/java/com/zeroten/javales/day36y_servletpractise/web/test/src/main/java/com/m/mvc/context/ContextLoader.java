package com.m.mvc.context;

import com.m.mvc.entity.ContextApplication;
import com.m.mvc.exception.SpringFrameworkLoadListenerException;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 负责加载解析配置文件
public abstract class ContextLoader {
    // 单列和静态等都可以保存到服务器内存中
    // 用于保存对象依存关系的集合（容器）  严格上来说Map<String, ContextApplication>这的String
    // 应该存com.m.mvc.context.ContextLoader的ContextLoader，这里为了简化
    protected static Map<String, ContextApplication> applicationContext = new HashMap<>();

    // 针对web工程
    @SuppressWarnings("unused")
    public void init(String webPath) {
        try {
            this.checkPath(webPath);
            this.build();
//            int i = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 针对java工程
    public void init() {
        
    }

    // 获取上下文
    private Document document;
    private void checkPath(String webPath) throws Exception {
        webPath += "/WEB-INF/application.xml";
        File f = new File(webPath);
        if (!f.exists()) {
            throw new Exception(webPath + "未发现");
        } else {
            SAXReader sax = new SAXReader(); // 读取xml的数据
            this.document = sax.read(f);
        }
    }

    // 解析配置文件
    private void build() throws Exception {
        // 获取根节点
        Element root = this.document.getRootElement();
        // 获取bean元素
        List<Element> beans = root.elements("bean"); 
        for (Element bean : beans) {
            String name = bean.attributeValue("name");
            String clazz = bean.attributeValue("class");
            Object pobj = Class.forName(clazz).newInstance(); // 通过反射获取到bean的实例
            ContextApplication pca = new ContextApplication();
            pca.setObj(pobj);
    
            // 获取需要注入的内容
            List<Element> opts = bean.elements("opt");
            for (Element opt : opts) {
                String cname = opt.attributeValue("name");
                String ref = opt.attributeValue("ref");
                ContextApplication ca = this.applicationContext.get(ref);
                if (ca == null) { // 如果没有找到需要注入的内容，则抛异常
                    throw new SpringFrameworkLoadListenerException(ref + "未找到");
                } else {
                    Object cobj = ca.getObj(); // 需要注入的对象
                    // 获取需要注入的属性
                    Field field = pobj.getClass().getDeclaredField(cname);
                    // 获取属性set方法
//                    String methodName = "set" + field.getName().substring(0,1).toUpperCase()
//                            + field.getName().substring(1);
                    String methodName = "set" + String.valueOf(cname.charAt(0)).toUpperCase()
                            + cname.substring(1);
                    Method setMethod = pobj.getClass().getMethod(methodName, field.getType());

                    // 执行方法完成注入
                    setMethod.invoke(pobj, cobj);
                    
                }
            }
            // 加入依赖关系集合
            this.applicationContext.put(name, pca);

        }
        
    }
}
