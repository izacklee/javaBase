package com.m.util;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZkSession {
    public static String basePath = "/filecloud/session";
    public static void put(String key, String value) {
        ZooKeeper zk = null;
        try {
            // 连接zookeeper
            // 用永久节点，不要用临时节点，因为zookeeper是会关的，连接一断开临时节点就没有了
            // 2181是zookeeper的默认端口号
            zk = new ZooKeeper("127.0.0.1:2181", 3000, null);
            zk.create(
                    basePath + "/" + key,
                    value.getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, // 默认匿名权限
                    CreateMode.PERSISTENT // 永久节点
            );
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

    public static String get(String key) {
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper("127.0.0.1:2181", 3000, null);
            byte[] r = zk.getData(basePath + "/" + key, null, new Stat());
            return new String(r);
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
        return "";
    }

    public static void remove(String key) {
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper("127.0.0.1:2181", 3000, null);
            zk.delete(basePath + "/" + key, -1); // -1表示不观察版本号
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
