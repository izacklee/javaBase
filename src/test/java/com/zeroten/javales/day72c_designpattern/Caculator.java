package com.zeroten.javales.day72c_designpattern;

/**
 * 策略模式 计算器的例子
 */
public class Caculator {

    // 原例子
    public static Integer calc(Integer a, Integer b, Integer method) {

        Integer result = -1;

        if (method == 1) {  // 加法

            return a+b;
        } else if (method == 2) { // 减法

            return a-b;
        } else if (method == 3) { // 乘法

            return a*b;
        }

        return result;
    }

    // 策略模式例子
    // 把核心部分的两个数和策略抽出来封装，后续有不同需求时可增加一个一个策略实现
    public static Integer calc(Integer a, Integer b, CalcStrategy calcStrategy) {

        return calcStrategy.calc(a, b);
    }

    static interface CalcStrategy{

        Integer calc(Integer a, Integer b);
    }

    static class AddStrategy implements CalcStrategy {

        @Override
        public Integer calc(Integer a, Integer b) {
            return a+b;
        }
    }

    static class MinusStrategy implements CalcStrategy {

        @Override
        public Integer calc(Integer a, Integer b) {
            return a-b;
        }
    }

    public static void main(String[] args) {

        // 原例子调用 减法
        System.out.println(Caculator.calc(2, 1, 2)); // 1

        // 策略模式调用 加法
        System.out.println(Caculator.calc(1, 2, new AddStrategy())); // 3
        System.out.println(Caculator.calc(5, 2, new MinusStrategy())); // 3
    }
}
