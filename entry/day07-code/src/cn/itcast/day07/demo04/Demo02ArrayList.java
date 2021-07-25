package cn.itcast.day07.demo04;

import java.util.ArrayList;
/*
数组的长度不可发生改变。
但是对于ArrayList集合的长度是可以发生改变的。

对于ArrayList来说，有一个尖括号<E>代表泛型。
泛型：也就是在集合当中所有的元素，都统一一个什么类型。
注意：泛型只能是引用类型，不能是基本类型。

注意事项：
    对于ArrayList集合来说，直接打印得到的不是地址值，是内容。
    如果内容为空，得到的是空的中括号：[]
*/
public class Demo02ArrayList {
    public static void main(String[] args) {
        // 创建了一个ArrayList集合，集合的名称是list，里面的内容为String类型的字符串
        // 备注：从JDK1.7+开始，右边ArrayList后尖括号的可不写内容，但<>还是要写
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list); // []
        list.add("王丽坤");
        list.add("迪丽热巴");
        System.out.println(list); //[王丽坤, 迪丽热巴]

         // 错误写法！因为创建集合的时候尖括号的范型已经指定了字符串，所以添加进去的元素必须是字符串才行
         // list.add(10);
    }
}
