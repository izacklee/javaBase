package com.zeroten.javales.day74c_springprinciple;

import org.springframework.stereotype.Component;

@Component
public class  FactoryBeanTest implements FactoryBean {

    private String type = "a";

    @Override
    public Object getObject() throws Exception {

        if ("a".equals(type)) {
            return new A();
        } else {
            return new B();
        }
    }

    @Override
    public Class<?> getObjectType() {

        if ("a".equals(type)) {
            return A.class;
        } else {
            return B.class;
        }
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
