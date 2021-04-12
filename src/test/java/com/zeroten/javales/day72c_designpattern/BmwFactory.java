package com.zeroten.javales.day72c_designpattern;

public class BmwFactory implements CarFactory {
    @Override
    public String engine() {
        return "宝马引擎";
    }

    @Override
    public String lunzi() {
        return "宝马轮子";
    }
}
