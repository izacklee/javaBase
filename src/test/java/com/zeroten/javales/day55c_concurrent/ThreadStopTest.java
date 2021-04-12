package src.test.java.com.zeroten.javales.day55c_concurrent;

import java.util.Map;

/*
* 线程的停止
*/
public class ThreadStopTest {

    private static volatile boolean flag = false; // 用volatile解决重排序问题

    // 推荐用法
    // 正确的线程退出1
    public static void stopThreadTest() {

        flag = true;

    }

    // 正确的线程退出2
    public static void startThreadTest() {
        Thread thread = new Thread(() -> {

            while (!flag) {

                System.out.println("thread is running");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            System.out.println("thread stop successfully");

        });

        thread.start();
    }
    // 3
    public static Thread startThreadTest2() {
        Thread thread = new Thread(() -> {

            while (!flag) {

                System.out.println("thread is running");

                try {
                    Thread.sleep(10); // 会抛异常 但isInterrupted还是false 所以不能用这个方法判断
                } catch (InterruptedException e) {
//                    e.printStackTrace();

                    System.out.println("thread interrupt stop successfully");
                    return;
                }

            }

            System.out.println("thread stop successfully");

        });

        thread.start();

        return thread;
    }

    public static void main(String[] args) throws InterruptedException {

//        startThreadTest();
        Thread thread2 = startThreadTest2();

        Thread.sleep(10);

//        stopThreadTest(); // 既可以在主线程调用 也可以在任意地方调用停止线程

        new Thread(() -> {

//            stopThreadTest(); // 在线程里调用
            thread2.interrupt();  // 并发阻塞状态下 中断失败 所以还是用flag靠谱

        }).start();

    }

//    public static void main(String[] args) {
//
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                int i = 0;
//
//                while (i++<20) {
//
//                    try {
//                        Thread.sleep(10); // 循环每次暂停10毫秒
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println(String.format("线程名称：[%s]，当前时间：[%s]",
//                            Thread.currentThread().getName(), System.currentTimeMillis()));
//
//                }
//
//            }
//        }, "thread1");
//
//        thread1.start();
//
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // 不建议使用了，要停止线程建议使用标志位
//        thread1.stop();
//
//        // 获取所有栈的信息，并打印
//        Map<Thread, StackTraceElement[]> threadThreadTraceElementMap = Thread.getAllStackTraces();
//
//        for (Map.Entry<Thread, StackTraceElement[]> entry : threadThreadTraceElementMap.entrySet()) {
//
//            System.out.println(entry.getKey().getName());
//
//        }
//    }

}
