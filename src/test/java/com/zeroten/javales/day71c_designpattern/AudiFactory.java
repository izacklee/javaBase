package com.zeroten.javales.day71c_designpattern;

public class AudiFactory implements CarFactory {

    @Override
    public String engine() {
        return "奥迪引擎";
    }

    @Override
    public String lunzi() {
        return "奥迪轮子";
    }
}
