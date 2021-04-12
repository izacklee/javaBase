package src.test.java.com.zeroten.javales.day56c_concurrent;

import java.util.concurrent.*;

public class ThreadPoolCoreParamsTest {

    // 固定个数线程池，常用，队列容量：Integer.MAX_VALUE
    // 正常情况下不建议这么创建线程池 原因看源码
    /**
     * 问题：
     *      new ThreadPoolExecutor(nThreads, nThreads,
     *                                       0L, TimeUnit.MILLISECONDS,
     *                                       new LinkedBlockingQueue<Runnable>());
     *     1 最大线程数和核心线程数一样
     *     2 0L不用等待 没任务直接挂了 （当然这里不需要等，因为最大线程数和核心线程数一样）
     *     3 阻塞队列无限，当任务很大时，处理不过来，一直往阻塞队列放，最终会导致内存溢出
     *
     *     或：
     *       问题：
     *          1 Integer.MAX_VALUE 数值很大 启动的线程数太多会造成内存溢出
     *          2 new SynchronousQueue<Runnable>() 一次只能放一个任务 会造成max一直创建
     *      new ThreadPoolExecutor(0, Integer.MAX_VALUE,
     *                                       60L, TimeUnit.SECONDS,
     *                                       new SynchronousQueue<Runnable>());
     *
     */
    ExecutorService executorservice = Executors.newFixedThreadPool(10);

    public static ThreadPoolExecutor buildThreadPool() {

        // 核心线程数
        int coreThreads = 1;

        // 最大线程数
        int maxThreads = 2;

        // 超时时间，单位s
        int keepaliveTime = 10;

        // 阻塞队列大小
        int blockQueueSize = 30;

        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(blockQueueSize);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                coreThreads, maxThreads, keepaliveTime, TimeUnit.SECONDS, blockingQueue);

        // 允许核心线程超时时，当任务都运行结束时，线程池的线程数为0
        // 无任务时，核心线程也会被线程池停止。
//        executor.allowCoreThreadTimeOut(true);

        return executor;
    }

    static class Task implements Runnable {

        private int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(String.format("线程：%s 执行任务：%s 完毕",
                    Thread.currentThread().getName(), taskId));

        }

    }

    public static void main(String[] args) {

        ThreadPoolExecutor executorService = ThreadPoolCoreParamsTest.buildThreadPool();

        // 模拟执行100个任务

        int count = 100;

        while (count>0) {

            try {

                executorService.submit(new Task(count--));

            } catch (RejectedExecutionException e) { // 拒绝策略

                e.printStackTrace();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // getPoolSize() 获取线程中当前线程数量
            System.out.println(String.format("线程中当前线程数量为：[%s]",
                    executorService.getPoolSize()));  // 满的时候为2 100个任务都消费完了线程数量恢复1
        }

        // 等待线程池的任务停止，并不会停止线程池  不常用
//        try {
//            executorService.awaitTermination(10*60, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // 停止线程池
//            executorService.shutdown();
//         System.out.println("线程池停止...");

    }

}
