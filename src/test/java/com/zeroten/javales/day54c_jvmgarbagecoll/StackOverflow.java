package src.test.java.com.zeroten.javales.day54c_jvmgarbagecoll;

/*
* 栈溢出测试
*/
public class StackOverflow {

    private int depth = 0;

    public void test() {

        depth++;
        // java.lang.StackOverflowError
        test(); // 这的递归调用 是方法的调用会占用栈空间（不同的压栈出栈）导致栈溢出  死循环是CPU打满

    }

    public static void main(String[] args) {

        StackOverflow stackOverflow = new StackOverflow();

        try {

            stackOverflow.test();

        } catch (Throwable e) {

            e.printStackTrace();

            System.out.println(stackOverflow.depth);

        }
    }

}
