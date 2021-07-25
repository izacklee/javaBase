package cn.itcast.day05.demo01;

/*
使用动态初始化数组的时候，其中的元素将会自动拥有一个默认值。规则如下：
    如果是整数类型，那么默认值为0；
    如果是浮点类型，那么默认值为0.0；
    如果是字符类型，那么默认值为'\u0000'； // \u0000 表示空字符串
    如果是布尔类型，那么默认值为false；
    如果是引用类型，那么默认值为null。

注意事项：
    静态初始化其实也有默认值的过程，只不过是系统自动将默认值替换成大括号里的具体数值。
*/

public class Demo05ArrayUse {
    public static void main(String[] args) {
        // 动态初始化一个数组
        int[] arrayA = new int[3];
        System.out.println(arrayA[0]); // 0
        System.out.println(arrayA[1]); // 0
        System.out.println(arrayA[2]); // 0

        System.out.println("=========");
        // 将120赋值给数组当中的1号元素
        arrayA[1] = 120;
        System.out.println(arrayA[0]); // 0
        System.out.println(arrayA[1]); // 120
        System.out.println(arrayA[2]); // 0

    }
}
