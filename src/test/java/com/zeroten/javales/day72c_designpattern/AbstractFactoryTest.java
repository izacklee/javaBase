package com.zeroten.javales.day72c_designpattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 抽象工厂
 */
public class AbstractFactoryTest {

    public static CarFactory getCarFactory(String factoryName) {

        if (factoryName.equals("audi")) {

            return new AudiFactory();
        } else if (factoryName.equals("dazhong")) {

            return new DazhongFactory();
        } else if (factoryName.equals("bmw")) {

            return  new BmwFactory();
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println(AbstractFactoryTest.getCarFactory("audi").engine()); // 奥迪引擎

        // 枚举方式
        System.out.println(CarFactoryEnum.getCarFactory("bmw").lunzi()); // 宝马轮子

    }
}
