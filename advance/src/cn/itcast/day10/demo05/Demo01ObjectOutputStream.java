package cn.itcast.day10.demo05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/*
    java.io.ObjectOutputStream extends OutputStream
    ObjectOutputStream：对象的序列化
        作用：把对象以流的方式写入到文件中保存

    构造方法：
 	    ObjectOutputStream(OutputStream out) ：创建写入指定 OutputStream 的 ObjectOutputStream。
            参数：
                OutputStream out：字节输出流

    特有的成员方法：
        void	writeObject(Object obj) ：将指定的对象写入 ObjectOutputStream。

    使用步骤：
        1.创建ObjectOutputStream对象，构造方法中传递字节输出流
        2.使用ObjectOutputStream对象中的方法，writeObject方法，把对象写入到文件中
        3.释放资源

    想启用序列化功能，被序列化和反序列化的类必须实现Serializable接口，否则将抛出异常 java.io.NotSerializableException
    Serializable接口也叫标记型接口
        要进行序列化和反序列化的类必须实现Serializable接口，就会给类添加一个标记
            有：就可以序列化和反序列化
            没有：抛出异常，NotSerializableException没有序列化异常
    去市场买肉->肉上有一个蓝色章（检测合格）->放心购买->买回来怎么吃随意

    static关键字：静态关键字
        静态优先于非静态加载到内存中（静态优先于对象进入到内存中）
        被static修饰的成员变量不能被序列化的，序列化的都是对象
        private static int age;
        oos.writeObject(new Person("胡歌",28));
        Object o = ois.readObject();
        Person{name='胡歌', age=0}

    transient关键字：瞬态关键字
        被transient修饰的成员变量，不能被序列化
        private transient int age;
        oos.writeObject(new Person("胡歌",28));
        Object o = ois.readObject();
        Person{name='胡歌', age=0}
*/
public class Demo01ObjectOutputStream {

    public static void main(String[] args) throws IOException {
        // 1.创建ObjectOutputStream对象，构造方法中传递字节输出流
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("advance/src/cn/itcast/day10/test/obj.txt"));
        // 2.使用ObjectOutputStream对象中的方法，writeObject方法，把对象写入到文件中
        oos.writeObject(new Person("胡歌",28));
        // 3.释放资源
        oos.close();
    }

}
