package com.zeroten.javales.day72c_designpattern;

public class DazhongFactory implements CarFactory {

    @Override
    public String engine() {
        return "大众引擎";
    }

    @Override
    public String lunzi() {
        return "大众轮子";
    }
}
