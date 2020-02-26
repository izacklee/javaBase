package com.zeroten.javales.day05y_genericenum;

public class Demo07UseEnum {

    public static void main(String[] args) {
        Sex02 sex = Sex02.MALE;
        System.out.println(sex); // MALE
        System.out.println(sex.getValue()); // 1

        // 重写枚举方法的调用
        System.out.println(Sex02.FEMALE.female()); // true
        System.out.println(Sex02.FEMALE.male()); // false
        System.out.println(Sex02.MALE.female()); // false
        System.out.println(Sex02.MALE.male()); // true
    }
}
