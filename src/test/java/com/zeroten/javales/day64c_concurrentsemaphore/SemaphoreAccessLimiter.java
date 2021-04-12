package com.zeroten.javales.day64c_concurrentsemaphore;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量实现流控
 */
public class SemaphoreAccessLimiter {

    private Integer tps = 1;

    private Semaphore semaphore;

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    public SemaphoreAccessLimiter(Integer tps) {

        this.tps = tps;
        // param2 fair [公平性,true:公平;false:非公平
        semaphore = new Semaphore(this.tps);

        // scheduleAtFixedRate() 以固定的频率来执行某项计划
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                Integer permits = tps - semaphore.availablePermits(); // 最大tps - 可用的许可数
//                System.out.println(tps); // 10
//                System.out.println(semaphore.availablePermits()); // 0 最大tps为10 每次10个 所以可用为0
//                System.out.println(permits); // 10
                // 注意不能直接释放tps 否则可能超了（有可能上一秒没有流量 许可就有10 这一秒来了10个 加起来就是20了 超了 ）
                semaphore.release(permits);
            }
            // initialDelay：初始化延时  period：两次开始执行最小间隔时间
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }

    public void access(Integer permits) throws InterruptedException {

        if (permits > tps) throw new IllegalArgumentException();

        semaphore.acquire(permits);

    }

    public static void main(String[] args) {
        // tps可以理解为每秒生成多少个permits
        SemaphoreAccessLimiter semaphoreAccessLimiter = new SemaphoreAccessLimiter(10);
//        Semaphore semaphore = new Semaphore(10);  // 常规方式 错误！！！

        Long startTime = System.currentTimeMillis();
        for (int i=0; i<100; i++) {
            new Thread(()->{

                try {
                    // 先获取1个许可 正常是1 代表一个请求
                    // 为何做为一个变量？因为有可能在并发的时候 它就是1个数据包的大小 比如控制了它的下载量
                    // 带宽不一样 这个值就不一定是1
                    // permits的值为2的时候 耗费的时间比原来多出1倍？
                    // 原因是原来1秒处理10个请求只要耗费1个许可 改为2了 就相当于把10个请求 分2次处理（耗费2个许可）
                    // 1秒只能处理5个了 所以时间上多出了1倍
                    semaphoreAccessLimiter.access(1);

//                    semaphore.acquire(1); // 获取
                    // 目的主要为了保护接口 不能在一次放太多的请求进来 比1秒钟小 所以这个时间实际上可以忽略
                    Thread.sleep(10);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                finally {
//                    semaphore.release(1);  // 释放
//                }

                System.out.println(Thread.currentThread().getName() +
                        "完成时间：" + (System.currentTimeMillis() - startTime));

            }, "biz-thread-"+(i+1)).start(); // biz-thread：业务线程
        }

    }

}
