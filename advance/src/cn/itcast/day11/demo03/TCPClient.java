package cn.itcast.day11.demo03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) throws IOException {
        // 1.创建一个本地字节输入流FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("advance/src/cn/itcast/day10/test/newin.txt");
        // 2.创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1",8888);
        // 3.使用Socket中的getOutputStream，获取网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();
        // 4.使用本地字节输入流FileInputStream对象中的方法read，读取本地文件
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            // 5.使用网络字节输出流OutputStream对象中的方法write，把读取到的文件上传到服务器
            os.write(bytes,0,len);
        }
        // void	shutdownOutput() :禁用此套接字的输出流。
        // 对于 TCP 套接字，任何以前写入的数据都将被发送，并且后跟 TCP 的正常连接终止序列。
        // 文件上传完，给服务器写一个结束标记
        // 解决服务器出现死循环无法给客户端回写数据的问题（阻塞）
        socket.shutdownOutput();

        // 6.使用Socket中的方法getInputStream，获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        // 7.使用网络字节输入流InputStream对象中的方法read，读取服务器回写的数据
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
        }
        // 8.释放资源（FileInputStream，Socket）
        fis.close();
        socket.close();
    }

}
