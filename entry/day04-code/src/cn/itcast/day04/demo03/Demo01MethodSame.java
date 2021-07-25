package cn.itcast.day04.demo03;

/*
题目要求：
    定义一个方法，用来判断两个数字是否相同。
*/

public class Demo01MethodSame {
    public static void main(String[] args) {
        boolean b = isSame(10, 20);
        System.out.println("结果是：" + b);

        // 答题例子：
       /* int score = 82;
        int integral = 70;
        System.out.println("本次答题得分：" + score);
        System.out.println("你的积分：" + integral);
        if (score > 60 || integral >= 80 && score > 80 && integral >= 70) {
            System.out.println("恭喜您,获奖了!");
        } else {
            System.out.println("很遗憾！");
        }*/
    }

    /*
    三要素：
        返回值类型：boolean
        方法名称：isSame
        参数列表：int a, int b
    */

    public static boolean isSame(int a, int b) {

        // if 的写法
//        boolean same;
//        if (a == b) {
//            same = true;
//        }else{
//            same = false;
//        }

//        // 三元运算写法
//        boolean same = a == b ? true: false;

//        // 直接赋值写法
//        boolean same = a == b;

        return a == b;
    }
}
