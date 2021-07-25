package cn.itcast.day05.demo01;

import java.io.FileNotFoundException;

/*
    finally代码块
    格式：
        try {
            可能产生异常的代码
        } catch (异常类名 变量名) {
            异常处理逻辑，产生异常之后，怎么处理异常对象
            一般在工作中，会把异常的信息记录到日志中
        }
        ...
        catch (异常类名 变量名) {

        } finally {
            无论是否出现异常都会执行
        }
    注意：
        1.finally不能单独使用，必须和try一起使用
        2.finally一般用于资源释放（资源回收），无论程序是否出现异常，最后都要释放资源（IO）

*/
public class Demo08TryCatchFinally {

    public static void main(String[] args) {
        try {
            readFile("b:\\a.txt");
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } finally {
            // 无论是否出现异常，都会执行
            System.out.println("释放资源");
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
