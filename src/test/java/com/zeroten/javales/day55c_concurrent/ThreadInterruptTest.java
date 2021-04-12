package src.test.java.com.zeroten.javales.day55c_concurrent;

/*
 * 线程中断例子
 */
public class ThreadInterruptTest {

    // 线程中断后退出
    public static void interruptTest() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                int i=0;

                // 判断中断状态
                while(!Thread.currentThread().isInterrupted()) {

                    System.out.println(String.format("线程名称：[%s]，执行第：[%s]次循环",
                            Thread.currentThread().getName(), i+1)); // 线程名称：[1]，执行第：[1]次循环
                    i++;
                }

            }
        }, "thread1");

        thread1.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt(); // 目的是把while循环的 Thread.currentThread().isInterrupted()设置为true

    }

    // 线程中断后不退出
    public static void interruptWithSleepTest() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                int i = 0;

                while(!Thread.currentThread().isInterrupted()) {

                    System.out.println(String.format("线程名称：[%s]，执行第[%s]循环",
                            Thread.currentThread().getName(), i+1));
                    i++;

                    try {
                        /*
                         * 如果线程阻塞，将不会去检查中断信号量stop变量，所 以thread.interrupt()
                         * 会使阻塞线程从阻塞的地方抛出异常，让阻塞线程从阻塞状态逃离出来，并
                         * 进行异常块进行 相应的处理
                         */
                        // 线程阻塞，如果线程收到中断操作信号将抛出异常
                        Thread.sleep(100); // 线程运行中存在sleep 状态会被清理，循环不会终止
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(String.format("[%s] is interrupted",
                                Thread.currentThread().getName()));

                        /*
                         * 如果线程在调用 Object.wait()方法，或者该类的 join() 、sleep()方法
                         * 过程中受阻，则其中断状态将被清除
                         */
//                        System.out.println(Thread.currentThread().isInterrupted());// false

                        //中不中断由自己决定，如果需要真真中断线程，则需要重新设置中断位，如果
                        //不需要，则不用调用
//                        Thread.currentThread().interrupt();
                    }
                }

                System.out.println(String.format("线程名称：[%s]，执行结束",
                        Thread.currentThread().getName()));
            }
        }, "thread1");

        thread1.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();

    }

    public static void main(String[] args) {

        interruptTest();

//        interruptWithSleepTest();

        System.out.println("main thread finished successfully");

    }

}
