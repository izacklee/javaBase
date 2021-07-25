package cn.itcast.day07.demo06;

/*
    Lambda表达式有参数有返回值的练习
    需求：
        给定一个计算器Calculator接口，内含抽象方法calc可以将两个int数字相加得到和值
        使用Lambda的标准格式调用invokeCalc方法，完成120和130的相加计算
*/
public class Demo01Calculator {

    public static void main(String[] args) {
        int a =120;
        int b = 130;
        // 匿名内部类方式
//        int sum = invokeCalc(120, 130, new Calculator() {
//            @Override
//            public int calc(int a, int b) {
//                return a + b;
//            }
//        });

        // Lambda方式
        // 注：(a1 ,b1)里的a1，b1变量不能和方法invokeCalc里的前两个变量名称相同，否则报错
        int sum = invokeCalc(120, 130, (a1 ,b1) -> a1 + b1);

        System.out.println(sum);

    }

    // invokeCalc方法
    public static int invokeCalc(int a, int b, Calculator c) {
        int sum = c.calc(a, b);
        return sum;
    }

}
