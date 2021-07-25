package cn.itcast.day03.demo02;


/*
可变参数：是JDK1.5之后出现的新特性
使用前提：
    当方法的参数列表数据类型已经确定，但是参数个数不确定，就可以使用可变参数
使用格式：
    修饰符 返回值类型 方法名称(数据类型...变量名) {
        // 方法体
    }
可变参数的原理：
    可变参数底层就是一个数组，根据传递参数个数不同，会创建不同长度的数组，来存储这些参数
    传递的参数个数，可以是0个（不传递），1,2...多个

可变参数的注意事项：
    1.一个方法的参数列表，只能有一个可变参数
    2.如果方法的参数有多个，可变参数必须放在参数列表的末尾
    可变参数的【终极】写法：
        public static void method(Object...obj) {}
        Object...obj：表示可以支持任意数据类型
*/
public class Demo03VariableArgs {
    public static void main(String[] args) {
//        String[] arr = {"a", "b", "c"};
        int[] arr = {1, 2, 3};
        int result = add(1.26,arr);
        System.out.println("计算结果：" + result); // 6
    }

     //  错误写法！不能存在多个可变参数
    /*public static void method01(int...arr, int...arr1) {

    }*/

     // 错误写法！可变参数没有放在末尾
    /*public static void method02(int...arr, String name) {

    }*/

    /*
        定义计算（0~n）整数和方法
        已知：计算整数的和，数据类型已经确定int
        但是参数的个数不确定，不知道要计算几个整数的和，就可以使用可变参数
        add()：就会创建一个长度为0的数组，存储传递过来的参数 new int[0]
        add(1)：就会创建一个长度为1的数组，存储传递过来的参数 new int[1]
        add(1, 2)：就会创建一个长度为2的数组，存储传递过来的参数 new int[2]
        ...
    */
    private static int add(double num,int...arr) {
        System.out.println(num);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
