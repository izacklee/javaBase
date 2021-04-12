package src.test.java.com.zeroten.javales.day55c_concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            5, // 核心线程数 每次最大执行数量
            10, // 最大线程数 可创建的最大线程数量
            0, // 不超时 不判断
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(200),  // 阻塞队列 可存放最大的任务数
            new RejectedExecutionHandler() {  // 拒绝策略
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                    // 结果打印10次 因为提交了220个任务 最大任务容量（队列）200，最大线程数是10
                    // 200+10=210 能处理最大的任务数就是210 220-210=10 多出了10个
                    // 所以执行10次拒绝策略，打印10次 
                    // 解决这个问题：把阻塞队列数值增大 大于等于提交的任务数
                    System.out.println("线程池已满...");  // 结果打印10次
                    
                }
            }
        );

        // 提交220个任务 每个任务执行2秒钟
        for (int i=0; i<220; i++) {

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
