package com.zeroten.javales.day58c_concurrentscheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {

    public static String getCurTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 以固定的任务调度，包括任务执行的时间
     */
    public static void scheduledAtFixRate() {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        // 任务开始执行的延时时间
        int initDelay = 1;

        // 任务循环执行的间隔
        int period = 8;

        scheduledExecutorService.scheduleAtFixedRate(new Task(), initDelay, period, TimeUnit.SECONDS);

    }

    /**
     * 以固定的时间间隔调度，不包括任务执行的时间
     */
    public static void scheduledWithFixDelay() {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        // 任务开始执行的延时时间
        int initDelay = 1;

        // 任务循环执行的间隔
        int period = 5;

        scheduledExecutorService.scheduleWithFixedDelay(new Task(), initDelay, period, TimeUnit.SECONDS);

    }

    static class Task implements Runnable {

        @Override
        public void run() {

            System.out.println(String.format("开始执行任务调度，执行线程：%s，当前时间：[%s]",
                    Thread.currentThread().getName(), getCurTime()));

            try {
                // 模拟任务执行的时间间隔5s
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("执行任务调度完成");
        }
    }

    public static void main(String[] args) {

//        System.out.println(getCurTime());

        // 等待任务执行完了再执行 不含任务执行时间 周期只含任务执行间隔时间
        // 间隔时间比执行时间小时 周期以执行时间为准 否则以间隔时间为准
        ScheduledThreadPoolTest.scheduledAtFixRate(); // 时间间隔结果是8秒

        // 等待任务执行完了再执行 含任务执行时间 周期是任务执行时间+任务间隔时间
//        ScheduledThreadPoolTest.scheduledWithFixDelay();  // 时间间隔结果是10秒
    }

}
