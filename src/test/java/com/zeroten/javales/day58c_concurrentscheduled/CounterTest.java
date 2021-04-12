package com.zeroten.javales.day58c_concurrentscheduled;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import lombok.Data;

/**
 * 统计方法的调用量
 */
public class CounterTest {

    // @Data注解的作用不需要生成getter and setter，而在编译的时候会自动生成getter and setter
    // 通过注解的形式自动生成构造器、getter/setter、equals、hashcode、toString等方法，提高了一定的开发效率
    // 让代码变得简洁，不用过多的去关注相应的方法
    // 属性做修改时，也简化了维护为这些属性所生成的getter/setter方法等
    @Data
    static class MethodKey {

        private String serviceName;

        private String methodName;


        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        @Override
        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            MethodKey methodKey = (MethodKey) o;
//            return Objects.equals(serviceName, methodKey.serviceName) &&
//                    Objects.equals(methodName, methodKey.methodName);

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return ((MethodKey) o).serviceName.equals(serviceName) &&
                    ((MethodKey) o).methodName.equals(methodName);
        }

        /**
         * 注意：使用hashMap的key为自定义对象时，必须覆盖重写hashCode()和equals()方法，
         *      否则将无法统计，因为引用地址都不一样
         */
        @Override
        public int hashCode() {

//            return Objects.hash(serviceName, methodName);

            int code = 0;
            if (serviceName != null) {
                code += serviceName.hashCode();
            }

            if (methodName != null) {
                code += methodName.hashCode();
            }

            return code;
        }

        @Override
        public String toString() {
//            return "MethodKey{" +
//                    "serviceName='" + serviceName + '\'' +
//                    ", methodName='" + methodName + '\'' +
//                    '}';
            StringBuilder sb = new StringBuilder();
            sb.append("serviceName：").append(serviceName).append("#");
            sb.append("methodName：").append(methodName);

            return sb.toString();
        }
    }

    static class Counter {

        private static Map<MethodKey, AtomicLong> counterMap = new ConcurrentHashMap<>();

        public static AtomicLong getCount(MethodKey key) {

            return counterMap.get(key);
        }

        static Long total = 0L;  // 静态的才能在forEach里调用

        public static void print() {
            counterMap.forEach((k, v) -> {

                System.out.println(k.toString() + " : " + v.get());

                total += v.get();
            });

            System.out.println("总调用量：" + total);
        }

        public static void add(MethodKey key) {

            if (counterMap.containsKey(key)) {

                counterMap.get(key).getAndIncrement(); // 相当于i++

            } else {
//                有问题的写法
//                AtomicLong tmp = new AtomicLong(1);
//                counterMap.put(key, tmp);

                synchronized(Counter.class) {

                    if (counterMap.containsKey(key)) {

                        counterMap.get(key).getAndIncrement();

                    } else {

                        AtomicLong tmp = new AtomicLong(1);
                        counterMap.put(key, tmp);

                    }
                }
            }

        }

    }

    public String test(MethodKey user) {

        Counter.add(user);
        return null;
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i=0; i<1000; i++) {

            Random random = new Random();
            int tmp = random.nextInt(100);

            MethodKey key = new MethodKey();
            key.setMethodName("method" + tmp);
            key.setServiceName("serviceName" + tmp);

            executorService.execute(() -> {

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Counter.add(key);

            });

        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Counter.print();

        for (int i=0; i<100; i++) {

            MethodKey key = new MethodKey();
            key.setMethodName("method" + i);
            key.setServiceName("serviceName" + i);

            // 获取统计的方法访问量结果
            System.out.println("method" + i + " 的访问量：" +Counter.getCount(key));
        }

    }

}
