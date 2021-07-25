package com.zeroten.javales.day92c_microservicekafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// 调度伪代码
@Component
public class VideoAnalysisDispatcher {

    // 调度队列
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // 调度线程池
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    // 任务调度
    private TaskEqueue taskEqueue;

    // 并行线程池（并行调用）
    private ExecutorService executorService;

    @PostConstruct
    private void init() {

        scheduledExecutorService.scheduleAtFixedRate(() -> {

                    List<String> msgs = taskEqueue.popBatch(100);

                    // 解决调度完了 任务还没来的问题 或者任务太多提交还没完 继续再提交的问题
                    List<Future> futures = new ArrayList<>();

                    for (String msg : msgs) {
                        futures.add(executorService.submit(() -> {

                            // 调用外围分析接口
                        }));
                    }

                    for ( Future future : futures) {

                        try {
                            // Futrue可以监视目标线程调用call的情况，当你调用Future的get()方法以获得结果时，
                            // 当前线程就开始阻塞，直接call方法结束返回结果。
                            future.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }


                } /* 执行线程 */, 1000 /* 初始化延时 */, 1000 /* 两次执行最小时间间隔 */,
                TimeUnit.MILLISECONDS /* 计时单位 */);
    }

    static class TaskEqueue {

        private RedisTemplate redisTemplate;

        public TaskEqueue(RedisTemplate template) {

            redisTemplate = template;
        }

        // 队头push
        public void push(String msg) {

        }

        // 队尾取出
        public String pop() {

            return null;
        }

        // 多条消息写
        public List<String> popBatch(Integer maxSize) {

            return null;
        }

    }
}
