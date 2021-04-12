package com.zeroten.javales.day62c_concurrentlatch;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 */
public class CountDownLatchTest {

    /**
     * 计数器 初始化为0
     */
    private Integer count = 0;

    public Integer getCount() {

        return count;
    }

    /**
     * 执行+1操作
     */
    public void add() {
        count++;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        CountDownLatchTest test = new CountDownLatchTest();

        // 线程个数
        int threadCount = 3;

        // 初始化线程个数，并用CountDownLatch管理
        CountDownLatch latch = new CountDownLatch(threadCount);
        for (int i=0; i<threadCount; i++) {

            new Thread(() -> {
                try {

                    test.add();

                } finally {
                    // 倒计数器 每一个任务执行完毕减1 当latch.countDown()为0时，latch.await()被唤醒
                    latch.countDown(); // 必须放finally 否则抛异常后通知不到 造成永远阻塞
                }

            }, "biz thread=" + (i+1)).start();  // biz 业务
        }

        Long oldTime = System.currentTimeMillis();

        try {
            // 等待所有子线程执行完毕，在所有子线程执行完毕前主线程都会被阻塞
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        latch.countDown();  // 错误！！！ await完之后不能再countDown 会返回false

        System.out.println(test.getCount());

        System.out.println("耗时："+ (System.currentTimeMillis() - oldTime) + "ms");

        for (int i=0; i<5; i++) {
            // 新启动一个线程进行等待 其他线程也是可以await的
            new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 资源够用时，几乎是同时唤醒的
                System.out.println(Thread.currentThread().getName()+"被唤醒，当前时间：" + System.currentTimeMillis());

            }, "wait thread" + (i+1)).start();
        }
    }
}
