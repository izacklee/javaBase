package src.test.java.com.zeroten.javales.day55c_concurrent;

/**
 * 线程异常
 */
public class ThreadExceptionTest {

    public static void main(String[] args) {

        try {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    throw new RuntimeException("exception test"); // 子线程跑运行时异常

                }
            }, "thread1");

            thread1.start();
        } catch (Throwable throwable) {  // 子线程异常不会传到主线程 所以这里是接收不到异常的

            System.out.println("thread1 run exception"); // 不会打印!!!

        }

        System.out.println("main thread finished successfully");

    }

}
