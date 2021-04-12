package com.zeroten.javales.day69c_netty;

import io.netty.channel.ChannelHandlerContext;

public abstract class TaskWorker<T> implements Runnable {


    private T task;
    private ChannelHandlerContext channelHandlerContext;

    public  TaskWorker(ChannelHandlerContext context, T task) {

        this.channelHandlerContext = context;
        this.task = task;
    }

    @Override
    public void run() {

        try {
            doTask(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    abstract protected void doTask(T task) throws Exception;

    public ChannelHandlerContext getContext() {

        return channelHandlerContext;
    }
}
