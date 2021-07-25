package cn.itcast.day01.junit;

/*
    计算器类
*/
public class Calculator {

    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
//        return 2 / 0; // java.lang.ArithmeticException: / by zero
        return a - b;
//        return a + b;
    }

    /**
     * 减法
     * @param a
     * @param b
     * @return
     */
    public int sub(int a, int b) {
        return a - b;
    }

}
