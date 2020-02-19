package com.zeroten.javales.day02y_io.homework;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

// 作业：写一个简单的文件系统，可以浏览目录和文件，以及对文件的查看和删除
public class FileSystem {

    public static LinkedList fArr = new LinkedList<>();

    public static void main(String[] args) {
        fileOperate();
    }

    public static void fileOperate() {
        System.out.println("---欢迎您使用文件系统---");
        Scanner s = new Scanner(System.in);
        int num = 1;
        String path = "src/test/java/com/zeroten/javales/day02y_io/homework/test";

        File f = new File(path);

        do {
            System.out.println("1.查看目录\n2.查看文件\n3.添加目录\n4.添加文件\n5.删除文件/目录\n6.退出系统");
            System.out.print("请输入要操作的数字：");
            int ynum = s.nextInt();
            num = ynum;
            int[] numArr = {0, 1, 2, 3, 4, 5, 6};
            String[] list = f.list();
            File[] listFiles = f.listFiles();
            switch(num) {
                case 1: // 1.查看目录
                    getFileList(list,listFiles);
                    System.out.print("输入0返回主菜单：");
                    num = s.nextInt();
                    break;
                case 2: // 2.查看文件
                    System.out.print("请输入要查看的文件名：");
                    String name = s.next();
                    if(name == null) {
                        System.out.println("文件名为空，请重新输入");
                        num = 2;
                    }
                    File f2 = fileExists(path, name);
                    InputStream input = null;
                    if(f2 != null) {
                        try {
                            input = new FileInputStream(f2);
                            int len = input.available(); // 获取文件字节长度
                            byte[] bs = new byte[len];
                            int temp = -1;
                            int index = 0;
                            while((temp = input.read()) != -1) {
                                bs[index] = (byte) temp;
                                index++;
                            }
                            String str = new String(bs);
                            System.out.println(str);
                        } catch(Exception e) {
                            e.printStackTrace();
                        } finally {
                            if(input != null) {
                                try {
                                    input.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } else {
                        System.out.print("文件不存在，查看失败");
                        System.out.println();
                    }
                    System.out.print("输入0返回主菜单：");
                    num = s.nextInt();
                    break;
                case 3: // 3.添加目录
                    System.out.print("请输入添加的目录名：");
                    String name3 = s.next();
                    if(name3 == null) {
                        System.out.println("目录名为空，请重新输入");
                        num = 3;
                    }
                    File f3 = notFileExists(path, name3);
                    if(f3 != null) {
                        boolean b = f3.mkdirs();
                        if(b) {
                            System.out.println("添加成功");
                        } else {
                            System.out.println("添加失败");
                        }
                    } else {
                        System.out.println("目录已存在，不能重复添加");
                        System.out.println();
                    }
                    System.out.print("输入0返回主菜单：");
                    num = s.nextInt();
                    break;
                case 4: // 4.添加文件
                    System.out.print("请输入添加的文件名：");
                    String name4 = s.next();
                    if(name4 == null) {
                        System.out.println("文件名为空，请重新输入");
                        num = 4;
                    }
                    File f4 = notFileExists(path, name4);
                    OutputStream out = null;
                    if(f4 != null) {
                        try {
                            boolean b = f4.createNewFile();
                            if(b) {
                                System.out.print("请输入要写入文件的内容：");
                                String content = s.next();
                                // 获取内容的字节数组
                                byte[] bs = content.getBytes();
                                out = new FileOutputStream(f4);
                                for(byte c : bs) {
                                    out.write(c); // 将数据写入文件
                                }
                                out.flush();
                                out.close();
                                System.out.println("文件添加成功");
                            } else {
                                System.out.println("文件添加失败");
                            }
                        } catch(Exception e) {
                            e.printStackTrace();
                        } finally {
                            if(out != null) {
                                try {
                                    out.close();
                                } catch(Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } else {
                        System.out.println("文件已存在，请勿重复添加");
                        System.out.println();
                    }
                    System.out.print("输入0返回主菜单：");
                    num = s.nextInt();
                    break;
                case 5: // 5.删除文件
                    System.out.print("请输入要删除的文件/目录名：");
                    String name5 = s.next();
                    if(name5 == null) {
                        System.out.println("文件/目录名为空，请重新输入");
                        num = 5;
                    }
                    File f5 = fileExists(path, name5);
                    if(f5 != null) {
                        boolean b = f5.delete();
                        if(b) {
                            System.out.println("删除成功");
                        } else {
                            System.out.println("删除失败");
                        }
                    } else {
                        System.out.println("文件/目录不存在，删除失败");
                        System.out.println();
                    }
                    System.out.print("输入0返回主菜单：");
                    num = s.nextInt();
                    break;
                case 6: // 6.退出系统
                    System.out.println("系统已退出，欢迎再次使用。");
                    break;
            }
            // 判断输入操作数字是否有误
            if(Arrays.binarySearch(numArr, num) < 0 || ynum == 0) {
                System.out.println("输入有误，请重新输入");
                num = 0;
            }
        } while (num == 0);

    }

    // 获取目录和文件列表
    public static void getFileList(String[] list, File[] listFiles) {
        if(listFiles.length == 0) {
            System.out.println("数据为空");
        } else {
            for (int i = 0; i < listFiles.length; i++) {
                String flag = "(f)"; // “f”表示文件
                if (listFiles[i].isDirectory()) flag = "(c)"; // “c“表示文件夹
                fArr.add(listFiles[i]);
                System.out.println("a" + i + "-->" + list[i] + flag);
            }
        }
    }

    // 判断文件存在
    public static File fileExists(String path, String name) {
        File f3 = new File(path +"/" + name);
        if(f3.exists()) {
            return f3;
        }
        return null;
    }

    // 判断文件不存在
    public static File notFileExists(String path, String name) {
        File f3 = new File(path +"/" + name);
        if(!f3.exists()) {
            return f3;
        }
        return null;
    }
}
