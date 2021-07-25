package cn.itcast.day11.demo04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    创建BS版本TCP服务器

    浏览器解析服务器回写的html页面，页面中如果有图片，那么浏览器就会单独开启一个线程，读取服务器的图片
    我们就得让服务器一直处于监听状态，客户端读一次，服务器就回写一次
*/
public class TCPServer {

    public static void main(String[] args) throws IOException {
        // 创建一个服务器ServerSocket，和系统要指定的端口号
        ServerSocket server = new ServerSocket(8080);
        // 死循环让服务器一直处于监听状态
        while (true) {
            // 使用accept方法，获取到请求客户端的对象（浏览器）
            Socket socket = server.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    InputStream is = null; OutputStream os = null; FileInputStream fis = null;
                    try {
                        // 使用Socket对象中的getInputStream方法，获取到网络字节输入流InputStream对象
                        is = socket.getInputStream();
                        // 使用网络字节输入流InputStream对象中的read方法，读取客户端请求的信息
                        /*byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = is.read(bytes)) != -1) {
                            System.out.println(new String(bytes,0,len));
                        }*/

                        // 把is网络字节输入流对象，转换为字符缓冲输入流
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        // 把客户端请求的第一行读取出来 GET /advance/src/cn/itcast/day11/web/index.html HTTP/1.1
                        String line = br.readLine();
                        System.out.println(line);
                        // 对读取的信息进行切割，只要中间的部分 /advance/src/cn/itcast/day11/web/index.html
                        String[] arr = line.split(" ");
                        // 把路径前面的/去掉 advance/src/cn/itcast/day11/web/index.html
                        String htmlpath = arr[1].substring(1);
                        // 创建本地字节输入流FileInputStream，构造方法中绑定要读取的html路径
                        fis = new FileInputStream(htmlpath);
                        // 使用Socket对象中getOutputStream方法，获取网络字节输出流OutputStream对象
                        os = socket.getOutputStream();

                        // 写入HTTP协议响应头,固定写法
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        // 必须要写入空行,否则浏览器不解析
                        os.write("\r\n".getBytes());

                        // 一读一写复制文件，把服务器读取的html回写到客户端
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = fis.read(bytes)) != -1) {
                            os.write(bytes,0,len);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        // 释放资源
                        try {
                            os.close();
                            is.close();
                            fis.close();
                            socket.close();
//                            server.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

}