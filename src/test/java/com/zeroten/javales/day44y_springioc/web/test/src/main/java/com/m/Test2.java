package com.m;

import com.m.dao.BaseDao;
import com.m.dao.BaseDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        BaseDao dao1 = context.getBean(BaseDaoImpl.class);
        BaseDao dao2 = context.getBean(BaseDaoImpl.class);

        // 判断是否为单例，检查地址是否一致就可以了
        System.out.println(dao1 == dao2);
    }

}
