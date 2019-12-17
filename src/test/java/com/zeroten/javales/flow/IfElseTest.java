package com.zeroten.javales.flow;

import org.testng.annotations.Test;

import java.util.Random;

public class IfElseTest {

    /**
     * 下面我们来做一个示例：给定一个年龄，然后判断该年龄属于儿童、青年、中年还是老年；
     * 年龄使用 int 类型，只支持整数。年龄段的划分规则如下：
     *
     * 年龄范围	描述
     * 0 ~ 6岁	儿童
     * 7 ~ 17岁	少年
     * 18 ~ 40岁	青年
     * 41 ~ 59岁	中年
     * 60及以上	老年
     */
    @Test
    public void testIfElse() {

        int age = 28;
        if (age < 7) {
            System.out.println(age + "岁，是儿童。");
        } else if (age < 18){
            System.out.println(age + "岁，是少年。");
        } else if (age < 41) {
            System.out.println(age + "岁，是青年。");  // 28岁，是青年。
        } else if (age < 60) {
            System.out.println(age + "岁，是中年。");
        } else {
            System.out.println(age + "岁，是老年。");
        }
    }
}
