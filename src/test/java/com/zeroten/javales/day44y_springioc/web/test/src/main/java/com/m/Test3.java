package com.m;

import com.m.dao.BaseDao;
import com.m.dao.BaseDaoImpl;
import com.m.dao.BaseDaoImpl2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        BaseDao dao1 = (BaseDao) context.getBean("baseDao2");
    }

}
