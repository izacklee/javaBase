package cn.itcast.day05.demo03;

public class Demo06MemoryArea {

    public static void main(String[] args) {
        // 不同包，相同类名的使用方式
        cn.itcast.day05.demo02.Demo06MemoryArea ma =new cn.itcast.day05.demo02.Demo06MemoryArea();
        System.out.println(ma.name); // 内存
    }
}
