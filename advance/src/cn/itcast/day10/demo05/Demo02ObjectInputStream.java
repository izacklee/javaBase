package cn.itcast.day10.demo05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;

/*
    java.io.ObjectInputStream extends InputStream
    ObjectInputStream：对象的反序列化流
        作用：把文件中保存的对象，以流的方式读取出来使用

    构造方法：
        ObjectInputStream(InputStream in)：创建从指定 InputStream 读取的 ObjectInputStream。
            参数：
                InputStream in：字节输入流

    特有的成员方法：
        Object readObject() 从 ObjectInputStream读取对象

    使用步骤：
        1.创建ObjectInputStream对象，构造方法中传递字节输入流
        2.使用ObjectInputStream对象中的readObject方法，读取保存的对象文件
        3.释放资源
*/
public class Demo02ObjectInputStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1.创建ObjectInputStream对象，构造方法中传递字节输入流
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("advance/src/cn/itcast/day10/test/obj.txt"));
        // 2.使用ObjectInputStream对象中的readObject方法，读取保存的对象文件
        Object o = ois.readObject();
        System.out.println(o); // Person{name='胡歌', age=28}
        // 向下转型
        Person p = (Person) o;
        // 打印输出姓名和年龄值
        System.out.println(p.getName() + "=" + p.getAge());

        // 3.释放资源
        ois.close();
    }

}
