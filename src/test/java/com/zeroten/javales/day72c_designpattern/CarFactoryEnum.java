package com.zeroten.javales.day72c_designpattern;

public enum CarFactoryEnum {

    // 项目启动时就加载 类似单例
    AUDI_FACTORY("audi", new AudiFactory()),

    DAZHONG_FACTORY("dazhong", new DazhongFactory()),

    BMW_FACTORY("bmw", new BmwFactory())
    ;

    private String factoryName;

    private CarFactory carFactory;

    CarFactoryEnum(String factoryName, CarFactory carFactory) {

        this.factoryName = factoryName;

        this.carFactory = carFactory;
    };

    public static CarFactory getCarFactory(String factoryName) {

        for (CarFactoryEnum carFactoryEnum : CarFactoryEnum.values()) {

            if (carFactoryEnum.getFactoryName().equals(factoryName)) {

                return carFactoryEnum.carFactory;
            }
        }

        return null;

    }

    public String getFactoryName() {
        return factoryName;
    }

}
