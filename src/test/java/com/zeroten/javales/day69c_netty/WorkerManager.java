package com.zeroten.javales.day69c_netty;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerManager {

    private static volatile WorkerManager singleton;

    private ExecutorService pool;

    private WorkerManager() {

    }

    public static WorkerManager getSingleton() {

        if (null == singleton) {

            synchronized (WorkerManager.class) {

                if (null == singleton) {

                    singleton = new WorkerManager();
                }
            }
        }
        return singleton;
    }

    public void init(int poolSize) {

        pool = Executors.newFixedThreadPool(poolSize);
    }

    public void close() {

        pool.shutdown();
    }

    public void run(TaskWorker worker) {

        if (null == pool) throw new IllegalStateException("pool not init...");

        pool.submit(worker);
    }

}
