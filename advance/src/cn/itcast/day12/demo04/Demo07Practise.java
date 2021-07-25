package cn.itcast.day12.demo04;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
    练习：集合信息筛选

    数组当中有多条“姓名+性别”的信息如下，
    String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
    请通过Predicate接口的拼接将符合要求的字符串筛选到集合ArrayList中，
    需要同时满足两个条件：
        1.必须为女生；
        2.姓名为4个字。
    分析：
        1.有两个判断条件，所以需要使用两个Predicate接口，对条件进行判断
        2.必须同时满足两个条件，所以可以使用and连接两个判断条件
*/
public class Demo07Practise {

    public static void main(String[] args) {
        // 定义一个数组
        String[] arr = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
        // 使用Lambda表达式，调用filter方法
        ArrayList<String> list = filter(arr, s ->
            // 必须是女生
            s.split(",")[1].equals("女"),
        s ->
            // 姓名为4个字
            s.split(",")[0].length() == 4
        );

        // 遍历集合输出结果
        for (String s : list) {
            System.out.println(s);
        }
    }
    /*
        定义一个方法
        返回值类型：ArrayList<String>
        参数传递一个字符串数组，和两个Predicate接口，泛型为String
     */
    public static ArrayList<String> filter(String[] arr, Predicate<String> pre1, Predicate<String> pre2) {
        // 定义一个ArrayList集合，存储筛选结果
        ArrayList<String> list = new ArrayList<>();
        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            // 使用and连接两个判断条件
            boolean bool = pre1.and(pre2).test(arr[i]);
            // 结果为true，把当前字符串存储到集合中
            if (bool) {
                list.add(arr[i]);
            }
        }
        return list;
    }

}
