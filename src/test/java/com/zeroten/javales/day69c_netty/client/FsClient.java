package com.zeroten.javales.day69c_netty.client;

import com.zeroten.javales.day69c_netty.FsDecoder;
import com.zeroten.javales.day69c_netty.FsEncoder;
import com.zeroten.javales.day69c_netty.FsManager;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 客户端
 */
public class FsClient {

    private String host;
    private int port;
    private String loaderId;

    public FsClient(String host, int port, String loaderId) {

        this.host = host;
        this.port = port;
        this.loaderId = loaderId;

    }

    public void run() {

        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {

            // Bootstrap 是 Netty 提供的一个便利的工厂类，用来完成netty初始化的
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new FsEncoder(), new FsDecoder(),
                            new ClientHandler(ClientTypeEnum.FILE_SENDER, loaderId));
                }
            });

            // Start the client.
            ChannelFuture f = b.connect(host, port).sync(); // (5)

            // Wait until the connection is closed.
            f.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {

            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {

        FsManager.getSingleton().init("/Users/app/Downloads/javaproject/" +
                "javatest/basic-code/slsweb/src/com/jinxun/githubmaven/java_demo/" +
                "src/test/java/com/zeroten/javales/day69c_netty/tmp/fstransfer", "/Users/app/Downloads/javaproject/" +
                "javatest/basic-code/slsweb/src/com/jinxun/githubmaven/java_demo/" +
                "src/test/java/com/zeroten/javales/day69c_netty/tmp");

        // 等待10秒钟后 自动发一个
        new Thread(() -> {

            try {
                Thread.sleep(10*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 发送文件
            ClientHandler.sendFile("test");

        }).start();

        new FsClient("127.0.0.1", 8080, "test").run();
    }

}
