package cn.itcast.day05.demo01;

/*
    如果finally有return语句，永远返回finally中的结果，避免该情况
*/
public class Demo09FinallyReturn {

    public static void main(String[] args) {
        int num = 10;
        int res = getNum(num);

        System.out.println(res); // 100 结果永远是100
    }

    private static int getNum(int num) {
        try {
            return num;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
             // 一定会执行的代码
            num = 100;
            return num;
        }
    }

}
