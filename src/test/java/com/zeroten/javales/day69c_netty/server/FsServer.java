package com.zeroten.javales.day69c_netty.server;

import com.zeroten.javales.day57c_concurrentfuture.PrompLogger;
import com.zeroten.javales.day69c_netty.FsDecoder;
import com.zeroten.javales.day69c_netty.FsEncoder;
import com.zeroten.javales.day69c_netty.FsManager;
import com.zeroten.javales.day69c_netty.WorkerManager;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class FsServer {

    private int port = 8080;
    private int workerPoolSize = 10;
    private PrompLogger logger = PrompLogger.getLogger(FsServer.class);

    public FsServer() {}

    public FsServer(int port, int workerPoolSize) {

        this.port = port;
        this.workerPoolSize = workerPoolSize;
    }

    private static volatile FsServer singleton;

    public static FsServer getSingleton() {

        if (null == singleton) {

            synchronized(FsServer.class) {

                singleton = new FsServer();
            }

        }

        return singleton;
    }

    public void start() {

        try {
            logger.info("文件同步服务端口：{}", port);

            this.run();
        } catch (Exception e) {

            logger.error("文件同步服务启动失败。。。", e);
        }
    }

    public void run() throws Exception {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // (3)
                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new FsDecoder(), new FsEncoder(), new ServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 1024) // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
            // Bind and start to accept incoming connections.
            ChannelFuture channelFuture = b.bind(port).sync(); // (7)

            // 初始化工作线程池
            WorkerManager.getSingleton().init(workerPoolSize);

            logger.info("fsServer启动成功...");

            channelFuture.channel().closeFuture().sync();

        } finally {

            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();

            logger.info("fsServer关闭成功...");
        }
    }

    public static void main(String[] args) {

        FsManager.getSingleton().init("/Users/app/Downloads/javaproject/" +
                "javatest/basic-code/slsweb/src/com/jinxun/githubmaven/java_demo/" +
                "src/test/java/com/zeroten/javales/day69c_netty/tmp/fstransfer", "/Users/app/Downloads/javaproject/" +
                "javatest/basic-code/slsweb/src/com/jinxun/githubmaven/java_demo/" +
                "src/test/java/com/zeroten/javales/day69c_netty/tmp");
        new FsServer(8080, 5).start();
    }
}
