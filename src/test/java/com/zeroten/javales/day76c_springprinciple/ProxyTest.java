package com.zeroten.javales.day76c_springprinciple;

import com.zeroten.javales.day76c_springprinciple.anno.ParamPrintAnno;
import org.springframework.stereotype.Component;

/**
 * 目标类
 */
@Component
public class ProxyTest implements ProxyTestInterface {


    @ParamPrintAnno
    @Override
    public Integer add(Integer a, Integer b) {

        return a + b;
    }
}
