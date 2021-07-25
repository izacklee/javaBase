package cn.itcast.day10.demo01;

public class MyInterfacePrivateAImpl implements MyInterfacePrivateA {

    public void methodDefault() {
        // 直接访问了接口当中的默认方法，这样是错误的！
//        methodCommon();
    }
}
