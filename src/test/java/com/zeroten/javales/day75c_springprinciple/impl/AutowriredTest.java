package com.zeroten.javales.day75c_springprinciple.impl;

import com.zeroten.javales.day75c_springprinciple.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AutowriredTest {

    // 加了这个之后就会自动按照类型装配 可省去了写getter/setter
    @Autowired // 就按类型装配
//    @Qualifier("addServiceImpl") // 指定装配的是哪个类与方法（不指定的话 运行时装配无法区分 会报错）

    @Resource(name = "multi")  // 优先按名称装配，找不到再按类型
    private CalcService calcService;
}
