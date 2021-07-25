package cn.itcast.day10.demo05;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
    练习：序列化集合
        当我们想在文件中保存多个对象的时候
        可以把多个对象存储到一个集合中
        对集合进行序列化和反序列化
    分析：
        1.定义一个存储Person对象的ArrayList集合
        2.往ArrayList集合中存储Person对象
        3.创建一个序列化流ObjectOutputStream对象
        4.使用ObjectOutputStream对象中的writeObject方法，对集合进行序列化
        5.创建一个反序列化流ObjectInputStream对象
        6.使用ObjectInputStream对象中的readWrite方法读取文件中保存的集合
        7.把Object类型的集合转换为ArrayList类型
        8.遍历ArrayList集合
        9.释放资源
*/
public class Demo03Practise {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1.定义一个存储Person对象的ArrayList集合
        ArrayList<Person> list = new ArrayList<>();
        // 2.往ArrayList集合中存储Person对象
        Collections.addAll(
                list,
                new Person("科比",28),
                new Person("詹姆斯", 30),
                new Person("艾弗森",32)
        );
        // 3.创建一个序列化流ObjectOutputStream对象
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("advance/src/cn/itcast/day10/test/practise.txt"));
        // 4.使用ObjectOutputStream对象中的writeObject方法，对集合进行序列化
        oos.writeObject(list);
        // 5.创建一个反序列化流ObjectInputStream对象
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("advance/src/cn/itcast/day10/test/practise.txt"));
        // 6.使用ObjectInputStream对象中的readWrite方法读取文件中保存的集合
        Object o = ois.readObject();
//        System.out.println(o);
        // 7.把Object类型的集合转换为ArrayList类型
        ArrayList<Person> list2 = (ArrayList<Person>)o;
        // 8.遍历ArrayList集合
        for (int i = 0; i < list2.size(); i++) {
            Person p = list2.get(i);
            System.out.println(p.getName() + "=" + p.getAge());
        }
        // 9.释放资源
        ois.close();
        oos.close();

    }

}
