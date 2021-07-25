package cn.itcast.day05.demo03;

import java.util.Scanner;

/*
    要求：我们模拟注册操作，如果用户名已存在，则抛出异常并提示：亲，该用户名已经被注册。

    分析：
        1.使用数组保存已注册过的用户名（数据库）
        2.使用Scanner获取用户输入的注册用户名（前端，页面）
        3.定义一个方法，对用户输入注册的用户名进行判断
            a.遍历存储已经注册过用户名的数组，获取每一个用户名
            b.把输入的用户名和获取到的用户名比较
                true：
                    用户名已存在，抛出RegisterException异常，告知用户"亲，该用户名已被注册"
                false：
                    用户名不存在，继续比较，直到循环结束还找不到已重复的用户名，提示“恭喜您，注册成功”
*/
public class Demo01RegisterException {

    static String[] name = {"王丽坤", "迪丽热巴", "古力娜扎"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入注册用户名：");
        String un = sc.next();
        username(un);
    }

    // 判断用户名是否已存在的方法
    public static void username(String username){

        for (int i = 0; i < name.length; i++) {
            if (name[i].equals(username)) {
                // 交给JVM处理
                // 将RegisterException类改为继承RuntimeException后，放开此行代码不报错了，因是运行期异常，编译期不报错
                throw new RegisterException("亲，该用户名已被注册");

                /*// try...catch自己处理
                try {
                    throw new RegisterException("亲，该用户名已被注册");
                } catch (RegisterException r) {
                    r.printStackTrace();
                    return; // 结束方法
                }*/
            }
        }

        System.out.println("恭喜您，注册成功");
    }


}
