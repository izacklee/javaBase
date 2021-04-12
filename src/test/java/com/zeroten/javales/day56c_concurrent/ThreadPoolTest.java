package src.test.java.com.zeroten.javales.day56c_concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池测试
 */
public class ThreadPoolTest {

     // 自定义线程池的创建策略
     static class MyThreadFactory implements ThreadFactory {

         //  高并发的情况下，i++无法保证原子性，往往会出现问题，所以引入AtomicInteger类。
         private AtomicInteger ctl = new AtomicInteger(0);

         private static final String prifx = "mypool-";

         @Override
         public Thread newThread(Runnable r) {
             return new Thread(r, prifx+ctl.incrementAndGet());
         }
     }

     static class MyThreadPoolExecutor extends ThreadPoolExecutor {

        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, MyThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }

         @Override
         protected void beforeExecute(Thread t, Runnable r) {
//             super.beforeExecute(t, r);
             System.out.println(String.format("beforeExecute，线程：[%s]，开始执行...",
                     t.getName()));
         }

         @Override
         protected void afterExecute(Runnable r, Throwable t) {
//             super.afterExecute(r, t);

             if (t != null) {
                t.printStackTrace();
             }

             System.out.println(String.format("beforeExecute，线程：[]，结束执行..."));
         }
     }

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new MyThreadPoolExecutor(
            5, // 核心线程数 每次最大执行数量
            10, // 最大线程数 可创建的最大线程数量
            0, // 不超时 不判断
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1000),  // 阻塞队列 可存放最大的任务数
            new MyThreadFactory(), // 线程工厂
            new RejectedExecutionHandler() {  // 拒绝策略
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                    System.out.println("线程池已满...");
                    
                }
            }
        );

        // 提交5个任务 每个任务执行2秒钟
        for (int i=0; i<5; i++) {

            final int t = i;

            executor.execute(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(2000);  // 执行2秒钟
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(String.format("任务[%s]执行完毕", (t+1)));

                }
            });
            
        }

    }

}
