package cn.itcast.day13.demo04;

/*
     用方法引用改进代码

     分析：
        Lambda表达式的目的，打印参数传递的字符串
        把参数s，传递给了System.out对象，调用out对象中的println方法对字符串进行了输出
        注意：
            1.System.out对象是已经存在的
            2.println方法是已经存在的
        所以我们可以使用方法引用来优化Lambda表达式
        可以使用System.out方法直接引用（调用）println方法
*/
public class Demo01Printable {

    public static void main(String[] args) {
        // 调用printString方法，该方法的参数是一个函数式接口，可传Lambda表达式
        printString(s-> System.out.println(s));

        // 使用System.out方法直接引用（调用）println方法
        printString(System.out::println);
    }

    // 定义一个方法，参数传递Printable接口，对字符串进行打印
    public static void printString(Printable p) {
        p.print("HelloWorld");
    }

}
