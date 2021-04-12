package src.test.java.com.zeroten.javales.day55c_concurrent;

/*
* 等待线程执行完毕Join测试
*/
public class ThreadJoinTest {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {

                                for (int i=0; i<10; i++) {
                                    System.out.println(String.format("线程名称：[%s]，执行第[%s]次循环",
                                            Thread.currentThread().getName(), i+1));

                                    try {
                                        Thread.sleep(100);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                }

                            }
                         }, "thread1");

         thread1.start();

        try {
            thread1.join(); // 调用join等待线程执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 等thread1执行完毕，才会执行这里
        System.out.println("main thread finished successfully");

    }

}
