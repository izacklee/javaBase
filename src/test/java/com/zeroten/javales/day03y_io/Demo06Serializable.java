package com.zeroten.javales.day03y_io;

import java.io.*;

public class Demo06Serializable {

    public static void main(String[] args) throws Exception {
        Person p = new Person()
                .setId(1)
                    .setName("ZackLee")
                        .setAge(18)
                            .setC(new Car());
        File f = new File("src/test/java/com/zeroten/javales/day03y_io","person.txt");
        // 直接把内存中的数据序列化到文件里
        /*
        // 序列化：把对象序列化成二进制
        ObjectOutputStream obs = new ObjectOutputStream(
                                new FileOutputStream(f)
                            );
        // 写入对象
        obs.writeObject(p);
        obs.flush();
        obs.close();
         */

        // 读取文件里的数据
        // 反序列化：把二进制，反序列化成对象
        ObjectInputStream ois = new ObjectInputStream(
                            new FileInputStream(f)
                        );
        Object o = ois.readObject();
        // 判断是否为Person对象
        if(o instanceof Person) {
            // 强转为Person对象
            Person p2 = (Person) o;
            System.out.println(p2); // Person{id=1, name='ZackLee', age=18}
        }
        ois.close();
    }
}
