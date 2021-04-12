package com.m.test;

public class Controller {
    
    private Service service;

    private String appName;
    private Integer appVersion;
    
// 通过构造的注入 就不需要再写这个构造了
//    public Controller() {
//
//    }

    public Controller(Service service, String appName, Integer appVersion) {
        this.service = service;
        this.appName = appName;
        this.appVersion = appVersion;
    }

    public void test() {
        System.out.println("Controller test ...");
        this.service.test();
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(Integer appVersion) {
        this.appVersion = appVersion;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "service=" + service +
                ", appName='" + appName + '\'' +
                ", appVersion=" + appVersion +
                '}';
    }
}
