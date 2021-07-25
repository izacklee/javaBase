package cn.itcast.day07.demo04;

import java.util.ArrayList;

/*
如果希望向集合ArrayList里存储基本数据类型，必须使用基本类型的“包装类”。

基本类型    包装类（引用类型，包装类都位于java.lang下）
byte       Byte
short      Short
int        Integer 【特殊】
long       Long
float      Float
double     Double
char       Character 【特殊】
boolean    Boolean

从JDK 1.5+开始，自动装箱，自动拆箱
自动装箱：基本类型 --> 包装类型
自动拆箱：包装类型 --> 基本类型
*/
public class Demo05ArrayListBasic {
    public static void main(String[] args) {
        // 错误写法！泛型只能是引用类型，不能是基本类型
//        ArrayList<int> listA = new ArrayList<>();

        ArrayList<Integer> listA = new ArrayList<>();
        // 向集合添加元素
        listA.add(10);
        listA.add(100);
        System.out.println(listA); // [10, 100]

        // 向集合获取元素
        int num = listA.get(1);
        System.out.println("获取到的第1号元素是：" + num); // 100
    }
}
