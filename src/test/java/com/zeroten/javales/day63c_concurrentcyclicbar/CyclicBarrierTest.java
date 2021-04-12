package com.zeroten.javales.day63c_concurrentcyclicbar;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 跑步的例子
 */
public class CyclicBarrierTest {

    /**
     * 跑步总圈数
     */
    private static final Integer totalRound = 3;

    private Integer curRound = 1;

    /**
     * 运动员个数
     */
    private static final Integer sporterNum = 3;

    private volatile boolean stopFlag = false;

    private void back() {

        cyclicBarrier.reset();  // 将屏障重置为初始状态 回退

    }

    private void rollback() {

        System.err.println(Thread.currentThread().getName() + "：执行顺序回滚操作");

    }

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(sporterNum, () -> {

        try {

            if (curRound == totalRound) {

                stopFlag = true;

                System.out.println(String.format("跑步结束，执行线程：%s",
                        Thread.currentThread().getName()));
            } else {

                if (curRound == 1) {
                    // 执行过程中发生异常必须用catch处理 否则线程无法停止
//                    throw new RuntimeException("第1圈发生异常！");

                    rollback();

                    back();
                }

                System.out.println(String.format("第 %s 圈结束，执行线程：%s",
                        curRound,
                        Thread.currentThread().getName()));
            }
        }
//        catch (RuntimeException e) {
//            System.out.println("第1圈发生异常catch处理");
//
//        }
        finally {
            curRound++;
        }
    });

    public void sporterRunTest() {

        for (int i=0; i<sporterNum; i++) {

            new Thread(new Runner(), "thread-" + (i+1)).start();

        }

    }

    class Runner implements Runnable{

        @Override
        public void run() {

            while (!stopFlag) {

                int time = new Random().nextInt(1000);
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(String.format("运动员：%s，第 %s 圈结束，花费时间：%s ms",
                        Thread.currentThread().getName(),
                        curRound,
                        time));

                try {

//                    // 让第二个线程抛异常
//                    if (Thread.currentThread().getName().equals("thread-2")) {
//                        throw new Exception("thread-2 发生异常");
//                    }

                    int index = cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "：执行顺序：" + (sporterNum - index));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
                    rollback();
                } catch (Exception e) {
//                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName() + "执行异常");

                }
            }

        }
    }

    public static void main(String[] args) {

        new CyclicBarrierTest().sporterRunTest();

    }

}
