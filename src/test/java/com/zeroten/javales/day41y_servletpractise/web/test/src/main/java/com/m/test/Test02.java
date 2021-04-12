package com.m.test;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;

public class Test02 {
    public static void main(String[] args) {
        ZooKeeper zk = null;
        try {
            // connectString 三个端口 连哪个都可以
            zk = new ZooKeeper("127.0.0.1:2181", 3000, null);

            // 自定义ACL权限
//            ArrayList<ACL> OPEN_ACL_UNSAFE = new ArrayList<>();
//            new ACL(ZooDefs.Perms.ALL, new Id("world", "anyone"));

//            String result = zk.create(
//                    "/test/test5",
//                    "test5".getBytes(),
//                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
//                    CreateMode.PERSISTENT // 持久节点
//            );
//            System.out.println(result);  // /test/test5  如果节点已存在，提示：NodeExists for /test/test5

//            // 获取节点
//            Stat stat = new Stat();
//            byte[] staRes = zk.getData("/test/test5", null, stat);
//            System.out.println(new String(staRes)); // test5
//            System.out.println(stat); // test5 节点下的信息

            // 可以再写一个对象实现他，实现锁和线程管理
            // 监听是一次性的，操作文件只能获取到一次监听，如果希望始终处于监听，可以将其放入循环，
            // 等待节点变化，然后唤醒后进入下一次监听
            zk.getChildren("/test", new Watcher() { // 监听者，监听目标的变化
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(watchedEvent);
                }
            });

            Thread.sleep(Integer.MAX_VALUE); // 让它停下来

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } finally {
            if (zk != null) {
                try {
                    zk.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
