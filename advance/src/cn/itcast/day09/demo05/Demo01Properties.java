package cn.itcast.day09.demo05;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/*
    java.util.Properties集合 extends Hashtable<k,v> implements Map<k,v>
    Properties类表示了一个持久的属性集。Properties可保存在流中或从流中加载。
    Properties集合是一个唯一和IO流相结合的集合
        可以使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
        使用使用Properties集合中的方法load，把硬盘中保存的文件（键值对），读取到集合中使用

    属性列表中每个键及其对应值都是一个字符串。
        Properties集合是一个双列集合，key和value默认都是字符串

*/
public class Demo01Properties {

    public static void main(String[] args) throws IOException {
//        show01();
//        show02();
        show03();
    }

    /*
        可以使用使用Properties集合中的方法load，把硬盘中保存的文件（键值对），读取到集合中使用
        void	load(InputStream inStream) ：从输入流中读取属性列表（键和元素对）。
        void	load(Reader reader) ：按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）。
            参数：
                InputStream inStream：集合对象
                Reader reader：集合对象中的方法load读取保存键值对的文件
            使用步骤：
                1.创建Properties集合对象
                2.创建字节/字符输入流对象，并将创建的对象传入Properties集合的load方法，读取保存键值对的文件
                3.遍历Properties集合
            注意：
                1.存储键值对的文件中，键与值默认的连接符号可以使用=，空格，其他字符
                2.存储键值对的文件中，可以使用#进行注释，被注释的键值对不会再被读取
                3.存储键值对的文件中，键值对默认都是字符串，不用再加引号
    */
    private static void show03() throws IOException {
        Properties prop = new Properties();
        // 创建字符输入流对象 把文件中的字符数据 读取到prop集合中
        prop.load(new FileReader("advance/src/cn/itcast/day09/test/h.txt"));
        // 使用字节输入流的方式读取，出现乱码。一般使用load读取文件，建议使用字符流
//        prop.load(new FileInputStream("advance/src/cn/itcast/day09/test/h.txt"));
        // 把集合中的所有键取出，放到set集合中
        /*
            Set<String>	stringPropertyNames()
                返回此属性列表中的键集，其中该键及其对应值是字符串，如果在主属性列表中未找到同名的键，则还包括默认属性列表中不同的键。
         */
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            // 根据集合的key获取value值
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }

    /*
        可以使用Properties集合中的方法store，把集合中的临时数据，持久化的写入到硬盘中存储
        void	store(OutputStream out, String comments) ：
          以适合使用 load(InputStream) 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流。
        void	store(Writer writer, String comments)：
          以适合使用 load(Reader) 方法的格式，将此 Properties 表中的属性列表（键和元素对）写入输出字符。
            参数：
                OutputStream out：字节输出流对象，不能写入中文
                Writer Writer：字符输出流对象，可以写中文
                String comments：注释，用来解释说明保存的文件是做什么的
                    不能使用中文，会产生乱码，默认Unicode编码
                    一般使用空字符串
           使用步骤：
                1.创建Properties集合对象，添加数据
                2.创建字节流/字符流对象，构造方法中传递要写入的数据源
                3.使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
                4.释放资源
    */
    private static void show02() throws IOException {
        // 1.创建Properties集合对象，添加数据
        Properties prop = new Properties();
        prop.setProperty("科比","198");
        prop.setProperty("詹姆士","192");
        prop.setProperty("姚明","214");
        // 2.创建字节流/字符流对象，构造方法中传递要写入的数据源
        FileWriter fw = new FileWriter("advance/src/cn/itcast/day09/test/h.txt");
        /*// 用字节流写入文件 出现乱码 不能这么用
        FileOutputStream fw = new FileOutputStream("advance/src/cn/itcast/day09/test/h1.txt"); */
        // 3.使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
        prop.store(fw,"Save Data");

        fw.close();
    }

    /*
        使用Properties集合存储数据，遍历取出Properties集合中的数据
        Properties集合是一个双列集合，key和value默认都是字符串
        Properties集合有一些操作字符串的特有方法
            Object setProperty(String key ,String value)：调用Hashtable的put方法
            String getProperty(String Key)：通过key键找value值，相当于Map集合当中的get(key)方法
            Set<String>	stringPropertyNames() ：返回此属性列表中的键集，其中该键及其对应值是字符串，相当于Map集合当中的keySet方法
    */
    private static void show01() {
        // 1.创建Properties集合对象
        Properties prop = new Properties();
        // 2.向集合存储数据
        prop.setProperty("胡歌","28");
        prop.setProperty("王丽坤","26");
        prop.setProperty("迪丽热巴","27");
//        prop.put(1,true); // 不建议使用 推荐用特有的方法

        /*// 3.将集合中的数据写入到硬盘中
        try (FileWriter w = new FileWriter("advance/src/cn/itcast/day09/test/g.txt")) {
            prop.store(w,"save data");
        } catch (IOException e) {
            e.printStackTrace();
        }

*/
        // 使用stringPropertyNames方法把集合中的key取出，放到Set集合中
        Set<String> set = prop.stringPropertyNames();
        // 遍历集合
        for (String key : set) {
            // 遍历key，通过key来获取对应的value值
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
        
    }

}
