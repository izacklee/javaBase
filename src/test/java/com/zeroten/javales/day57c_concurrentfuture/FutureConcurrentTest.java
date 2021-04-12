package com.zeroten.javales.day57c_concurrentfuture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class FutureConcurrentTest {

    static class ResultWrapper {
        
        private Integer id;
        
        private Integer result;
        
        public ResultWrapper() {
            
        }
        
    }

    static class ResultTask implements Callable<Integer> {

        private int executeTime = 10;

        private Integer count = 1;

        public ResultTask(Integer executeTime, Integer count) {

            this.executeTime = executeTime;

            this.count = count;

        }

        @Override
        public Integer call() throws Exception {

            Thread.sleep(executeTime);

            if (count == 2) throw new IllegalStateException();

            return count * count;
        }
    }

    public static void main(String[] args) {

        // 通过控制固定线程池数量来决定是否并行串行 并行为3 串行改为1
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<Integer>> tasks = new ArrayList<>();

        Map<ResultTask, Future<Integer>>  map = new HashMap<>();

        for (int i=0; i<3; i++) {

            ResultTask task = new ResultTask(1000*(i+1),(i+1));

            Future<Integer> submit = executorService.submit(task);
            
            map.put(task, submit);
            
            tasks.add(submit);

        }

        long time = System.currentTimeMillis();

        Integer count = 0;

//        for (Future<Integer> e : tasks) {
//
//            try {
//
//                Integer result = e.get();
//
//                count += result;
//
//                System.out.println(result);
//
//            } catch (InterruptedException interruptedException) {
//                interruptedException.printStackTrace();
//            } catch (ExecutionException executionException) {
//                executionException.printStackTrace();
//            }
//
//        }

        for (Map.Entry<ResultTask, Future<Integer>> e : map.entrySet()) {

            try {

                Integer result = e.getValue().get();

                count += result;

                System.out.println(result);

            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (ExecutionException executionException) {
                executionException.printStackTrace();
            }

        }

        long curTime = System.currentTimeMillis();

        System.out.println(String.format("执行时间为：%s ms", curTime - time));

    }

}
