package cn.itcast.day13.demo05;

/*
    通过对象名引用成员方法
    使用前对象名是已经存在的，成员方法也是存在的
    就可以使用对象名来引用成员方法
*/
public class Demo01MethodReference {

    public static void main(String[] args) {
        // 调用printString方法，方法参数传递Lambda表达式
        printString((s)->{
            // 创建MethodRerObject对象
            MethodRerObject mro = new MethodRerObject();
            // 调用MethodRerObject对象中的printUpperCaseString方法，将字符串转为大写输出
            mro.printUpperCaseString(s); // HELLO
        });

        // 使用对象名引用方法，优化Lambda
        printString(new MethodRerObject()::printUpperCaseString); // HELLO

    }

    /*
        定义一个方法
        三要素：
            方法名称：printString
            返回值类型：void
            参数列表：Printable p
     */
    public static void printString(Printable p) {
        p.print("Hello");
    }


}
