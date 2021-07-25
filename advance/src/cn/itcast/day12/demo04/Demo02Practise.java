package cn.itcast.day12.demo04;

import java.util.function.Consumer;

/*
    练习：
        字符串数组当中存有多条信息，请按照格式“ 姓名:XX。性别:XX。 ”的格式将信息打印出来。
        要求将打印姓名的动作作为第一个 Consumer 接口的Lambda实例，
        将打印性别的动作作为第二个 Consumer 接口的Lambda实 例，
        将两个 Consumer 接口按照顺序“拼接”到一起。

*/
public class Demo02Practise {

    public static void main(String[] args) {
        // 使用Lambda表达式调用method方法
        String[] arr = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
        printInfo(arr,message->{
                    // 消费方式：对message进行切割，获取姓名信息
                    String name = message.split(",")[0];
                    System.out.print("姓名：" + name + "。");
                },
                message->{
                    // 消费方式：对message进行切割，获取性别信息
                    String sex = message.split(",")[1];
                    System.out.println("性别：" + sex + "。");
        });

    }

    // 定义一个方法，参数传递一个字符串数组，和两个Consumer接口
    public static void printInfo(String[] arr, Consumer<String> con1, Consumer<String> con2) {
        // 遍历数组
        for (String s : arr) {
            // 使用andThen连接，一起消费
            con1.andThen(con2).accept(s);
        }
    }

}
