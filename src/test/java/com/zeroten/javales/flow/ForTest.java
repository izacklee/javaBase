package com.zeroten.javales.flow;

import org.testng.annotations.Test;

public class ForTest {
    // 练习：打印 0 ~ 100 范围内的单数并计算范围内单数的总个数。
    @Test
    public void testFor() {
        int times = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                times++;
                System.out.println(i + "是单数");
            }
        }
        System.out.println("总共有" + times + "个单数");
    }

    /**
     * 练习2：编写一个方法 int getMaxNumRem7(int n1, int n2) 找出 0 ~ n2 范围内除以 n1 余 7 的最大的数，
     * 找到则返回该数，如果找不到则返回 -1。
     */
    @Test
    public void testMaxNum() {
        int num = getMaxNumRem7(10, 900);
        System.out.println("n1余7最大的数是：" + num); // 897
    }
    public int getMaxNumRem7(int n1, int n2) {
        for (int i = n2; i >= 0; i--) {
            if (i % n1 == 7) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 练习3：找出 0 ~ 100 范围内能被7整除的数，并计算它们累计相加的结果。
     */
    @Test
    public void testTotal() {
        int total = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 7 != 0) {
                continue;
            }
            System.out.println(i + "能被7整除");
            total += i;
        }
        System.out.println("0~100范围内能被7整除的数的和为：" + total);
    }
}
