package com.m;

import com.m.dao.BaseDao;
import com.m.dao.BaseDaoImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Test {

    public static void main(String[] args) {
        
        BeanFactory factory = new XmlBeanFactory(
                new ClassPathResource("applicationContext.xml"));

//        BaseDaoImpl dao = (BaseDaoImpl) factory.getBean("baseDao");
//        dao.test();
//
//        BaseDaoImpl dao2 = factory.getBean(BaseDaoImpl.class);  // 这个的好处不需要强转
//        dao2.test();

        System.out.println("获取bean之前");
        BaseDao dao3 = factory.getBean(BaseDaoImpl.class);  // 推荐这种方式 面相接口编程
        dao3.test();
        System.out.println("获取bean之后");
    }
    
}
