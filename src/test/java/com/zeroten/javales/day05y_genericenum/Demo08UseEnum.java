package com.zeroten.javales.day05y_genericenum;

public class Demo08UseEnum {

    public static void main(String[] args) {
        // 调用一次枚举，相当于调用一次构造器，很耗内存
        System.out.println(Food.A.AA);
        System.out.println(Food.B.BB);
    }
}
