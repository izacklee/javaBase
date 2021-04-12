package src.test.java.com.zeroten.javales.day55c_concurrent;

/**
 * 守护线程
 */
public class ThreadDamonTest {

    public static void damonThreadTest() {

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {

                int i = 0;

                while(true) {

                    System.out.println(String.format("线程名称：[%s]，执行第[%s]次循环",
                            Thread.currentThread().getName(), i+1));
                    i++;

                    try {
                        Thread.sleep(100); // 状态清理 线程循环不会终止
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(String.format("[%s] is interrupted",
                                Thread.currentThread().getName()));
                    }

                }

            }
        }, "thread1");

        // 设置为守护线程 （守护线程先执行，其他线程再执行，等其他线程执行完毕，守护线程自动终止）
        thread1.setDaemon(true);

        thread1.start();

    }

    public static void main(String[] args) {

        damonThreadTest();

        new Thread(() -> {
            int count = 0;

            while (count++ < 10) {
                // 不要使用+拼接字符串这种方式，会很慢，要养成用format
                System.out.println(String.format("业务线程运行次数[%s]", count));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        System.out.println("main thread finished successfully");
    }

}
