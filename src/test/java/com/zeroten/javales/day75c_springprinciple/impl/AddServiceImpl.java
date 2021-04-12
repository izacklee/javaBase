package com.zeroten.javales.day75c_springprinciple.impl;

import com.zeroten.javales.day75c_springprinciple.service.CalcService;
import org.springframework.stereotype.Component;

// @Component("add")  // 注释掉就不会装载进容器中
public class AddServiceImpl implements CalcService {

    @Override
    public Integer calc(Integer a, Integer b) {

        return a + b;
    }
}
