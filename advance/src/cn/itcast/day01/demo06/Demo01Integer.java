package cn.itcast.day01.demo06;

/*
装箱：把基本数据类型，包装到包装类中（基本数据类型 -> 包装类）
    构造方法：
        Integer(int value) ：构造一个新分配的 Integer 对象，它表示指定的 int 值。
        Integer(String s) ：构造一个新分配的 Integer 对象，它表示 String 参数所指示的 int 值。
        传递字符串，必须是基本类型的字符串，否则会抛出异常，"100"正确，"a"抛出异常。
    静态方法：
        static Integer	valueOf(String s) ：返回保存指定的 String 的值的 Integer 对象。
        static Integer	valueOf(String s, int radix) ：返回一个 Integer 对象，
                该对象中保存了用第二个参数提供的基数进行解析时从指定的 String 中提取的值。
拆箱：在包装类中取出基本类型（包装类 -> 基本数据类型）
    成员方法：
        int	intValue()：以 int 类型返回该 Integer 的值。
*/
public class Demo01Integer {

    public static void main(String[] args) {
        // 装箱 基本类型数据 -> 包装类
        // 构造方法
//        Integer in1 = new Integer(1); // 方法上有横线，说明方法【已过时】
//        System.out.println(in1); // 1 覆盖重写了toString方法
//        Integer in2 = new Integer("a"); // 错误写法！NumberFormatException异常
//        Integer in3 = new Integer("1"); // 1

        // 静态方法
        Integer in4 = Integer.valueOf("20");
        System.out.println(in4); // 20

        // 拆箱 包装类 -> 基本数据类型
        Integer int5 = in4.intValue();
        System.out.println("int5：" + int5); // 20

    }

}
