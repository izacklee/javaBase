package cn.itcast.day11.demo03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
    1.自定义一个文件命名规则：防止同名的文件被覆盖
        规则：域名+毫秒值+随机数

    2.让服务器一直处于监听状态（死循环accept方法）
        有一个客户端上传文件，就保存一个文件

    3.使用多线程技术，提高程序的效率
        有一个客户上传文件，就开启一个线程，完成文件的上传
*/
public class TCPServer {

    public static void main(String[] args) throws IOException {
        // 1.创建一个服务器ServerSocket对象，和系统要指定的端口号
        ServerSocket server = new ServerSocket(8888);
        // 让服务器一直处于监听状态（死循环accept方法）
        while (true) {
            // 2.使用ServerSocket对象中的accept方法，获取到请求的客户端Socket对象
            Socket socket = server.accept();
            // 使用多线程技术，提高程序的效率
            new Thread(new Runnable() {
                // 完成上传文件任务
                @Override
                public void run() {
                    FileOutputStream fos = null;
                    try {
                        // 3.使用Socket对象中的方法getInputStream，获取到网络字节输入流InputStream对象
                        InputStream is = socket.getInputStream();
                        // 4.判断advance/src/cn/itcast/day11/test/upload文件夹是否存在，不存在则创建
                        File file = new File("advance/src/cn/itcast/day11/test/upload");
                        if (!file.exists()) {
                            file.mkdirs(); // 创建多层级文件夹
                        }
                        // 自定义文件命名
                        Random r = new Random(999999);
                        String fileName = "itcast" + System.currentTimeMillis() + r.nextInt() + ".txt";
                        // 5.创建一个本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
                        fos = new FileOutputStream("advance/src/cn/itcast/day11/test/upload/" + fileName);
                        // 6.使用网络字节输入流InputStream对象中的方法read，读取客户端上传的文件
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = is.read(bytes)) != -1) {
                            // 7.使用本地字节输出流FileOutputStream对像中的方法write，把读取到的文件保存到服务器的硬盘上
                            fos.write(bytes,0,len);
                        }
                        // 8.使用Socket对象中的方法getOutputStream，获取网络字节输出流OutputStream对象
                        OutputStream os = socket.getOutputStream();
                        // 9.使用网络字节输出流OutputStream对象中的方法write，给客户端回写“上传成功”
                        os.write("上传成功".getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        // 10.释放资源（FileOutputStream，socket，ServerSocket）
                        try {
                            fos.close();
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

}
