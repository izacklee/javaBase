package com.zeroten.javales.day08y_reflectexception;

public class Demo04Exception {

    // 异常处理：最好细分处理 不要统一用Exception处理
    public static void main(String[] args) {
        System.out.println("异常发生前");

        try {
            new int[]{1}[10] = 11; // 下标越界异常
            int i = 1 / 0;
            return; // return 都不能阻止finally执行
        } catch (ArrayIndexOutOfBoundsException e) {  // 按异常代码顺序，只会执行匹配上的第一个异常
//            System.exit(1); // 退出虚拟机 不会在执行finally了
            System.out.println("有异常了！~~~");
//            e.printStackTrace();
        } catch (ArithmeticException e) {  // 异常类型匹配
            System.out.println("算数异常了！~~");
//            e.printStackTrace(); // 打印堆栈信息
        } catch (Exception e) {  // 写在最后  先是子异常，再是父异常
            System.out.println("当前面异常都匹配不上的时候，在这里统一处理");
        } finally {
            System.out.println("无论是否发生异常，都一定会执行。");
        }

        System.out.println("异常发生后");
    }
}
