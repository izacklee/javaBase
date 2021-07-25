package cn.itcast.day02.demo02;

/*
定义含有泛型的方法：泛型定义在修饰符和返回值类型之间
格式：
    修饰符 <泛型> 返回值类型 方法名称(泛型 参数名) {
        // 方法体
    }
    注意：泛型的字母可随便定义
含有泛型的方法，在调用的时候确定泛型的数据类型
传递什么类型的参数，泛型就是什么类型
*/
public class Demo03GenericMethod {

    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();

        // 调用含有泛型的方法，传递什么数据类型，泛型就是什么类型
        gm.method1("高圆圆"); // String "高圆圆"
        gm.method1(3.14);  // double 3.14

        // 调用含有泛型的静态方法
        // 格式：类名称.方法名称
        GenericMethod.methodStatic(22222); // 22222
        GenericMethod.methodStatic("赵又廷"); // 赵又廷
    }

}
