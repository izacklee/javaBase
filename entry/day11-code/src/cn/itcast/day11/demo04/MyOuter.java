package cn.itcast.day11.demo04;

/*
局部内部类，如果希望访问所在方法的局部变量，那么这个局部变量必须是【有效final的】。

备注：从Java 8+开始，只要局部变量事实不变，那么final关键字可以省略。

原因：
1.new出来的对象在堆内存当中。
2.局部变量跟着方法走的，在栈的内存当中。
3.方法运行结束之后，立刻出栈，局部变量就会立刻消失。
4.但new出来的对象会在堆中持续存在，直到垃圾收回消失。
*/
public class MyOuter {

    public void methodOuter() {
        // 必须是固定的常量，方法出栈后，局部内部类中才能继续使用
        int num = 10; // 所在方法的局部变量
        class Inner { // 局部内部类
            public void methodInner() {
                System.out.println(num);
            }
        }
    }
}
