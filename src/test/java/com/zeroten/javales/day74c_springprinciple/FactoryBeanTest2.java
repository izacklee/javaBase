package com.zeroten.javales.day74c_springprinciple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class FactoryBeanTest2 {

    public static void main(String[] args) {

        // ClassPathXmlApplicationContext  默认路径是当前项目的target/classes目录
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "testBeans.xml");
        String[] names = applicationContext.getBeanDefinitionNames();

        Arrays.stream(names).forEach(e-> System.out.println(e));

        // 此处获取的是类A的实例
        Object realBean = applicationContext.getBean("factoryBeanTest");

        System.out.println(realBean.getClass().getName());

        // 此处获取的是FactoryBeanTest的实例 加个&才是获取本身的对象
        FactoryBeanTest factoryBeanTest = (FactoryBeanTest) applicationContext.getBean("&factoryBeanTest");

        ((ClassPathXmlApplicationContext) applicationContext).close();

    }
}
