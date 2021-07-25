package cn.itcast.day05.demo03;
/*
如：招亲比如与选美的例子
*/
public class Demo05ArrayMax {
    public static void main(String[] args) {
        int[] array = { 10, 20, 30, 40, 100, 10000, 200 };
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            // 如果当前元素值比指定max的大，那么将其赋给max
            if ( array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("最大值为：" + max);
    }
}
