package cn.itcast.day07.demo05;

import java.util.ArrayList;
import java.util.Random;
/*
题目：用一个大集合存20个随机数，然后筛选其中的偶数元素，放到小集合当中。
要求使用自定义的方法来实现。

分析：
    1.需要创建一个大集合，用来存储int数字，泛型为：<Integer>
    2.随机数用Random nextInt
    3.循环20次，把随机数放到大集合里：for循环 add方法
    4.定义一个方法，用来筛选
        筛选：根据大集合，筛选符合要求的元素，放入到小集合。
        三要素：
            返回值类型 ：ArrayList小集合（里面的个数不确定）
            方法名称：getSmallList
            参数列表：ArrayList大集合（装着20个随机数）
    5.用(if)判断是否为偶数：num % 2 ==0
    6.如果是偶数，就放到小集合当中，否则不放
*/
public class Demo04ArrayListReturn {
    public static void main(String[] args) {
        // 创建一个大集合，装20个随机数
        ArrayList<Integer> bigList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(100) + 1; // 1~100以内的随机数
            bigList.add(num);
        }
        System.out.println("大集合：" + bigList);
        ArrayList<Integer> smallList = getSmallList(bigList);
        System.out.println("小集合：" + smallList);
    }

    // 收集大集合，筛选偶数放到小集合当中，把结果返回
    public static ArrayList<Integer> getSmallList(ArrayList<Integer> bigList) {
        // 创建一个小集合，装偶数
        ArrayList<Integer> smallList = new ArrayList<>();
        for (int i = 0; i < bigList.size(); i++) {
            // 如果是偶数
            if (bigList.get(i) % 2 == 0) {
                smallList.add(bigList.get(i));
            }
        }

        return smallList;
    }
}
