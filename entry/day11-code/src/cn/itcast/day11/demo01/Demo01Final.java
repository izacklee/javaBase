package cn.itcast.day11.demo01;

/*
final关键字代表最终，不可改变的。

常见四种用法：
1.可以用来修饰一个类
2.可以用来修饰一个方法
3.还可以用来修饰一个局部变量
4.还可以用来修饰一个成员变量
*/
public class Demo01Final {

    public static void main(String[] args) {
        int num1 = 10;
        System.out.println(num1); // 10
        num1 = 20;
        System.out.println(num1); // 20

        System.out.println("=========");

        // 一旦使用final关键字修饰局部变量，那么将不能再改变
        // “一赋值，终生不变”
        final int num2 = 100;
        System.out.println(num2); // 100
//        num2 = 150; // 错误写法 不能改变
//        num2 = 100; // 也是错误写法 赋原来的值也不行

        // 正确写法！只要保证有唯一一次赋值即可
        final int num3;
        num3 = 300;
        System.out.println(num3); // 300

        // 对于基本类型来说，不可变说的是变量当中的数据值不可变
        // 对于引用类型来说，不可变说的是变量当中的地址值不可变
        Student stu1 = new Student("迪丽热巴");
        System.out.println(stu1); // 5fe5c6f
        System.out.println(stu1.getName()); // 迪丽热巴
        stu1 = new Student("王丽坤");
        System.out.println(stu1); // 6979e8cb
        System.out.println(stu1.getName()); // 王丽坤

        final Student stu2 = new Student("高圆圆");
        // 错误写法！final的引用变量类型，地址值不可改变
//        stu2 = new Student("赵又廷");
        System.out.println(stu2.getName()); // 高圆圆
        // 正确写法 final的引用变量类型，只是地址值不可改变，里面的内容还是可以改变的
        stu2.setName("高圆圆圆圆");
        System.out.println(stu2.getName()); // 高圆圆圆圆
    }
}
