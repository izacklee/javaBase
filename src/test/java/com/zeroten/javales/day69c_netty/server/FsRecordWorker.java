package com.zeroten.javales.day69c_netty.server;

import com.zeroten.javales.day57c_concurrentfuture.PrompLogger;
import com.zeroten.javales.day69c_netty.EntityEnum;
import com.zeroten.javales.day69c_netty.FsManager;
import com.zeroten.javales.day69c_netty.ServerUtil;
import com.zeroten.javales.day69c_netty.TaskWorker;
import com.zeroten.javales.day69c_netty.po.FsEntity;
import com.zeroten.javales.day69c_netty.po.FsResponse;
import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;

public class FsRecordWorker extends TaskWorker<FsEntity> {

    private static PrompLogger logger = PrompLogger.getLogger(FsRecordWorker.class);

    public FsRecordWorker(ChannelHandlerContext context, FsEntity task) {
        super(context, task);

    }

    @Override
    protected void doTask(FsEntity task) throws Exception {

        logger.info("接受到文件， ID=[{}]", task.getId());

        FsEntity fsEntity = task;

        FsResponse fsResponse = new FsResponse();

        fsResponse.setId(task.getId());

        fsResponse.setType(EntityEnum.RESP.getType());

        String host = ServerUtil.getServerIp();

        fsResponse.setLength(host.length() + 1);

        fsResponse.setHost(host);

        try {

            FsManager.getSingleton().writeToDisk(fsEntity);
        } catch (IOException e ) {

            logger.error("写文件异常");
        }
    }
}
