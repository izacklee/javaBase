package com.zeroten.javales.day69c_netty.client;

import com.zeroten.javales.day69c_netty.EntityEnum;
import com.zeroten.javales.day69c_netty.po.BaseEntity;
import com.zeroten.javales.day69c_netty.po.FsEntity;
import com.zeroten.javales.day69c_netty.po.FsResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    private ClientTypeEnum clientType;
    private String loaderId;

    public ClientHandler(ClientTypeEnum type, String loaderId) {

        this.clientType = type;
        this.loaderId = loaderId;
    }

    private static ChannelHandlerContext channelHandlerContext;

    public static void sendFile(String loaderId) {

        System.out.println("开始发送文件...");

        if (channelHandlerContext != null)
            new Thread(new FsFileSenderTaskWorker(
                    channelHandlerContext,
                    new FsEntity(loaderId)
                    )).start();

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);

        if (clientType == ClientTypeEnum.FILE_SENDER) {

            new Thread(new FsFileSenderTaskWorker(ctx, new FsEntity(loaderId))).start();
        } else  if (clientType == ClientTypeEnum.CLASS_LOADER) {

        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
        BaseEntity baseEntity = (BaseEntity)msg;

        if(baseEntity.getType() == EntityEnum.RESP.getType()) {

            FsResponse response = (FsResponse) msg;

        }

        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}
