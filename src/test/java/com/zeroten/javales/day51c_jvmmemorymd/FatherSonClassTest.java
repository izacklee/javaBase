package src.test.java.com.zeroten.javales.day51c_jvmmemorymd;

public class FatherSonClassTest {

    public String test = "fatherSonTest";

    public FatherSonClassTest() {

        System.out.println(Son.fatherName);

    }

    static class Father {

        Father() {

            System.out.println("father 构造函数");

        }

        static String fatherName = "小头爸爸";

        final static String test = "final static test";

        static {
            System.out.println("father 静态代码块");
        }

    }

    static class Son extends Father {
        Son() {
           super();
            System.out.println("son 构造函数");
        }

        static String sonName = "大头儿子";

        static {

            System.out.println("son 静态代码块");

        }

        public static void test() {

        }
    }

    public static void main(String[] args) {
        // 对于静态字段，只有直接定义这个字段的类才会被初始化（执行静态代码块）
//        System.out.println(Son.fatherName); // 1  执行结果：father 静态代码块  小头爸爸
//
//        System.out.println(Son.sonName); // 2 执行结果：son 静态代码块  大头儿子
//
        // 访问被final修饰的静态变量，不会被初始化（执行静态代码块）
//        System.out.println(Son.test); // 3 执行结果：final static test

        new Son(); // 4 执行结果：father 静态代码块 son 静态代码块  father 构造函数 son 构造函数

//        Son.test(); // 5 执行结果：father 静态代码块 son 静态代码块
    }
}
