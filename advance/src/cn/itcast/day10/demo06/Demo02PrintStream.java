package cn.itcast.day10.demo06;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
    输出语句，默认控制台输出。
    System.setOut方法可以改变输出语句的目的地（打印流的方向）

    使用System.setOut方法改变输出语句的目的地改为参数中传递的打印流的目的地
        static void	setOut(PrintStream out)：重新分配“标准”输出流。
*/
public class Demo02PrintStream {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("我是在控制台输出");

        PrintStream ps = new PrintStream("advance/src/cn/itcast/day10/test/目的地是打印流.txt");
        System.setOut(ps); // 把输出语句的目的地改为打印流目的地
        System.out.println("我在打印流目的地中输出1");
        System.out.println("我在打印流目的地中输出2");
        System.out.println("我在打印流目的地中输出3");
    }

}
