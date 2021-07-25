package cn.itcast.day05.demo01;

import java.io.FileNotFoundException;

/*
    Throwable类：是Java语言中所有错误或异常的超类（父类，根类），所以所有错误或异常的子类都可以直接调用Throwable类的方法
    一些查看方法：
         public String getMessage() :获取异常的描述信息,原因(提示给用户的时候,就提示错误原因。信息简短。
         public String toString() :获取异常的类型和异常描述信息(不用)。信息详细。
         public void printStackTrace() :打印异常的跟踪栈信息并输出到控制台。JVM打印异常对象，默认此方法，信息最全。
*/
public class Demo07Throwable {

    public static void main(String[] args) {
        try {
            readFile("d:\\a.txt");
        } catch (FileNotFoundException f) {
//            System.out.println(f.getMessage()); // 传递的文件路径不是c:\a.txt
//            System.out.println(f.toString()); // java.io.FileNotFoundException: 传递的文件路径不是c:\a.txt
            /*
                java.io.FileNotFoundException: 传递的文件路径不是c:\a.txt
	            at cn.itcast.day05.demo01.Demo07Throwable.readFile(Demo07Throwable.java:28)
	            at cn.itcast.day05.demo01.Demo07Throwable.main(Demo07Throwable.java:16)
            */
            f.printStackTrace();
        }
        System.out.println("后续代码执行了！");
    }

    // 文件路径匹配方法
    public static void readFile(String fileName) throws FileNotFoundException {
        if (!fileName.equals("c:\\a.txt")) {
            throw new FileNotFoundException("传递的文件路径不是c:\\a.txt");
        }
    }
}
