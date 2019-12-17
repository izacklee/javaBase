package com.zeroten.javales.flow;

import org.testng.annotations.Test;

import java.util.Random;

public class WhileTest {
    /**
     * 练习：随机生成一个 0 ～ 1000 范围的整数，如果不能被30整除，则打印出数字，如果能被30整除则退出循环。
     * 生成 0 ~ 1000 范围的整数使用语句 int r = new Random().nextInt(1000)。
     */
    @Test
    public void testWhile() {
        boolean isContinue = true;
        int times = 0;
        while (isContinue) {
            int r = new Random().nextInt(1000);
            // 如果能被30整除
            if (r % 30 == 0) {
                System.out.println(r + "能被30整除，退出");
                isContinue = false;
            } else {
                System.out.println(r + "不能被30整除，继续");
                times++;
            }
        }
        System.out.println("总共产生了" + times + "次，不能被30整除的数");
    }

    @Test
    public void testBreakWhile() {
        int times = 0;
        while (true) {
            int r = new Random().nextInt(1000);
            if (r % 30 == 0) {
                System.out.println(r + "能被30整除，退出");
                break; // 退出循环
            } else {
                times++;
                System.out.println(r + "不能被30整除，继续");
            }
        }
        System.out.println("随机产生了" + times + "个，不能被30整除的数");
    }

    // do ... while的例子
    @Test
    public void testDoWhile() {
        boolean isContinue = true;
        int times = 0;
        do {
            int r = new Random().nextInt(1000);
            if (r % 30 == 0) {
                isContinue = false;
                System.out.println(r + "能被30整除，退出");
            } else {
                ++times;
                System.out.println(r + "不能被30整除，继续");
            }
        } while (isContinue);

        System.out.println("随机产生了" + times + "次，不能被30整除的数");
    }

}
