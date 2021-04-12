package com.zeroten.javales.day67c_netty;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 习题：
 * 1 计算1+100000000累加？
 */

public class Java8Test2 {

    @Data
    static class Student {

        /**
         * 学号
         */
        private Integer stdNo;

        /**
         * 年级
         */
        private Integer grade;

        /**
         * 年龄
         */
        private Integer age;

        public Integer getStdNo() {
            return stdNo;
        }

        public void setStdNo(Integer stdNo) {
            this.stdNo = stdNo;
        }

        public Integer getGrade() {
            return grade;
        }

        public void setGrade(Integer grade) {
            this.grade = grade;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "stdNo=" + stdNo +
                    ", grade=" + grade +
                    ", age=" + age +
                    '}';
        }
    }

    public static List<Student> getStudents(Integer studentsNum) {

        List<Student> students = new ArrayList<>();

        Random random = new Random();

        Integer maxStdNo = 10000;
        Integer maxGrade = 6;


        for (int i=0; i<studentsNum; i++) {
            Student student = new Student();

            //  idea 使用lombok build项目报错 the method getXXX() is undefined for type xxx
            // 解决办法：检查编译模式，不能使用Eclipse，修改为Javac再次编译通过
            student.setStdNo(1+random.nextInt(maxStdNo));
            student.setGrade(1+random.nextInt(maxGrade));
            student.setAge(6+student.getGrade());

            students.add(student);
        }

        return students;

    }

    public static void calcTest() {

    }

    /**
     * ForkJoinPool将大型复杂任务递归拆解执行，最终把小任务结果汇聚成大任务，得出最初提交大任务的结果
     * ForkJoinPool线程池为了提高任务的并行度和吞吐量做了非常多而且复杂的设计实现，
     * 其中最著名的就是任务窃取机制。
     * ForkJoinPool执行的任务ForkJoinTask类，最终也还是实现了执行者框架提供的Future接口
     * Future可获取线程池执行结果
     */
    private static ForkJoinPool forkJoinPool = new ForkJoinPool(100);

    public void test1(List<Student> students) {
        AtomicInteger stCount = new AtomicInteger(0);
        long curTime = System.currentTimeMillis();
        students.stream().forEach((e) -> {stCount.addAndGet(e.getAge());
            try {
                Thread.sleep(10);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        System.out.println(String.format("count=%s，普通计算流耗时= %s ms",
                stCount, System.currentTimeMillis() - curTime));
    }

    public void test2(List<Student> students) {
        long curTime = System.currentTimeMillis();
        int count2 = students.stream().mapToInt(Student::getAge).sum();

        System.out.println(String.format("count=%s，普通流耗时= %s ms",
                count2, System.currentTimeMillis() - curTime));
    }

    public void test3(List<Student> students) {
        long curTime = System.currentTimeMillis();
        // parallelStream提供了流的并行处理,它是Stream的另一重要特性,
        // 其底层使用Fork/Join框架实现。简单理解就是多线程异步任务的一种实现。
        int count3 = students.parallelStream().mapToInt(Student::getAge).sum();

        System.out.println(String.format("count=%s，并行流耗时= %s ms",
                count3, System.currentTimeMillis() - curTime));
    }

    public void test4(List<Student> students) {

        AtomicInteger stCount = new AtomicInteger(0);

        long curTime = System.currentTimeMillis();

        // 如何设置并行流使用forkJoinPool的大小? （以下代码不行 思考...）
        forkJoinPool.execute(() -> {

            students.parallelStream().forEach(e -> {

                stCount.addAndGet(e.getAge());

                System.out.println("test4：" + Thread.currentThread().getName());

                try {
                    Thread.sleep(10);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            });

            System.out.println(String.format("count=%s，并行流耗时= %s ms",
                    stCount.get(), System.currentTimeMillis() - curTime));
        });

    }

    public void test5(List<Student> students) {

        AtomicInteger stCount = new AtomicInteger(0);

        long curTime = System.currentTimeMillis();

        forkJoinPool.execute(() -> {
            students.parallelStream().forEach((e) -> {

                stCount.addAndGet(e.getAge());

                System.out.println("test5：" + Thread.currentThread().getName());

                try {
                    Thread.sleep(10);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            });

            System.out.println(String.format("count=%s，并行流耗时= %s ms",
                    stCount.get(), System.currentTimeMillis() - curTime));
        });

    }

    public void test6(List<Student> students) {

        AtomicInteger stCount = new AtomicInteger(0);

        long curTime = System.currentTimeMillis();

        students.parallelStream().forEach((e) -> {

            stCount.addAndGet(e.getAge());

            System.out.println("test6：" + Thread.currentThread().getName());

            try {
                Thread.sleep(10);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        System.out.println(String.format("count=%s，并行流耗时= %s ms",
                stCount.get(), System.currentTimeMillis() - curTime));
    }

    public static void main(String[] args) {
//        ForkJoinPool 把大任务拆分成一个个小任务计算 再合并
//        System.out.println(Thread.currentThread().getName());

        List<Student> students = getStudents(200);

//        new Java8Test2().test1(students);
//        new Java8Test2().test2(students);
//        new Java8Test2().test3(students);

        // 计算本质上是耗CPU的操作，用多线程反而不能增加它的吞吐量
        // 耗时的操作（比如：增加Thread.sleep），用多线程才可增加它的吞吐量
//        new Java8Test2().test4(students);
        
        // 并行流用的也是同一个线程池
//        new Java8Test2().test5(students); // test5：ForkJoinPool.commonPool-worker-1

         // 让任务交替执行 有争议的情况下 test5耗时增加了
         // 多个竞争线程并行时 test5的时间接近test4 或者更慢了 造成了bug
         new Thread(() -> {new Java8Test2().test4(students);}).start();
//         new Thread(() -> {new Java8Test2().test4(students);}).start();
//         new Thread(() -> {new Java8Test2().test5(students);}).start();
//         new Thread(() -> {new Java8Test2().test5(students);}).start();
    }

}
