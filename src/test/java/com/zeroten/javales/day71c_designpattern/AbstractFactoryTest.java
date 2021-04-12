package com.zeroten.javales.day71c_designpattern;

/**
 * 抽象工厂
 */
public class AbstractFactoryTest {

    public static CarFactory getCarFactory(String factoryName) {

        if (factoryName.equals("audi")) {

            return new AudiFactory();
        } else if (factoryName.equals("dazhong")) {

            return new DazhongFactory();
        } else {

            return null;
        }
    }
}
