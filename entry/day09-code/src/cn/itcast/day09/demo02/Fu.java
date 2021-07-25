package cn.itcast.day09.demo02;

public class Fu {
    int numFu = 10;
    int num = 100;

    public void methodFu() {
        // 使用本类当中的，不会找子类的
        System.out.println(num);
    }
}
