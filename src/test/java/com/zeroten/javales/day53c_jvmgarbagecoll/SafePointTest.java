package src.test.java.com.zeroten.javales.day53c_jvmgarbagecoll;

import java.util.function.Consumer;

public class SafePointTest {

    static Consumer<Long> sleep = millis -> {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {

        }
    };

    static Thread t1 = new Thread(() -> {
        while (true) {
            long start = System.currentTimeMillis();
            sleep.accept(1000L);
            long cost = System.currentTimeMillis() - start;
            // 两个线程运行 至少是4核 运行时间正常大一点点 大太多就有问题了
            (cost > 1010L ? System.err : System.out)
                    .printf("thread: %s, cost %d ms\n", Thread.currentThread().getName(), cost);
        }
    });

    static Thread t2 = new Thread(() -> {
        while (true) {
            long start = System.currentTimeMillis();
            // i 用long类型就正常  原因是uncounted-loop每次循环结束会放出安全点，而counted-loop则不会
            // 如果没有这个安全点，就会一直循环循环等待，进而就出现了超时的问题
            for (long i=1; i<=1000000000; i++) {
                boolean b = 1-0 / i == 0;
            }
            long cost = System.currentTimeMillis() - start;
            // System.out.printf("thread %s, cost %d ms\n", Thread.currentThread().getName(), cost);

            sleep.accept(10L);
        }
    }, "thread100");

    public static void main(String[] args) {
        t1.start();
        sleep.accept(1500L);
        t2.start();
    }
}
