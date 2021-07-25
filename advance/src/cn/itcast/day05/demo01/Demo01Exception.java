package cn.itcast.day05.demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
java.lang.Throwable：类是Java语言中所有错误或异常的超类
    Exception：编译期异常，进行编译（写代码）java程序出现的问题
    RuntimeException：运行期间异常，java程序运行过程中出现的问题
        异常就相当于得了一个小毛病（感冒，发烧），把异常处理掉，程序可以继续执行（吃点药，继续工作）
    Error：错误
        错误就相当于程序得了一个无法治愈的毛病（非典），必须修改源代码，程序才能继续执行
*/
public class Demo01Exception {

    public static void main(String[] args) /*throws ParseException*/ {
        // Exception 编译期异常
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse("2019-10-14"); // 编译期异常
        Date date = null;
        try {
             date = sdf.parse("2019-999");
        } catch (Exception e) {
            e.printStackTrace(); // Unparseable date: "2019-999"
        }*/

//        System.out.println(date);

        // RuntimeException 运行期异常
        /*int[] num = {1, 2, 3};
        System.out.println(num[3]); // ArrayIndexOutOfBoundsException*/

        // Error 错误
        // 内存溢出错误，创建的数组太大了，超出了给JVM分配的内存
//        int[] in = new int[1024*1024*1024]; // java.lang.OutOfMemoryError: Java heap space
        // 解决：把数组长度，改小一点
        int[] in = new int[1024*1024];
        System.out.println(in);

        System.out.println("后续代码");

    }

}
