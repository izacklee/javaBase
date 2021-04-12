package com.zeroten.javales.day69c_netty.client;

import com.zeroten.javales.day57c_concurrentfuture.PrompLogger;
import com.zeroten.javales.day69c_netty.FsManager;
import com.zeroten.javales.day69c_netty.TaskWorker;
import com.zeroten.javales.day69c_netty.po.FsEntity;
import io.netty.channel.ChannelHandlerContext;

public class FsFileSenderTaskWorker extends TaskWorker<FsEntity> {

    private static final PrompLogger logger = PrompLogger.getLogger(FsFileSenderTaskWorker.class);

    public FsFileSenderTaskWorker(ChannelHandlerContext context, FsEntity task) {

        super(context, task);

    }

    @Override
    protected void doTask(FsEntity task) throws Exception {

        FsEntity fsEntity = FsManager.getSingleton().readFromDisk(task);

        getContext().writeAndFlush(fsEntity);

        logger.info("文件发送成功，ID=[{}]", fsEntity.getId());
    }
}
