package com.zeroten.javales.day75c_springprinciple.impl;

import com.zeroten.javales.day75c_springprinciple.service.CalcService;
import org.springframework.stereotype.Component;

@Component("multi")
public class MultiplyServiceImpl implements CalcService {

    @Override
    public Integer calc(Integer a, Integer b) {

        return a * b;
    }
}
