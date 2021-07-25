package cn.itcast.day08.demo02;

/*
    练习：
        使用递归计算阶乘
        n的阶乘：n! = n*(n-1)*...*3*2*1
    分析：
        5的阶乘：5! = 5(5-1)*(5-2)*(5-3)*(5-4) = 5*4*3*2*1
        递归的条件:
           获取到1的时候结束
        递归的目的：
           获取下一个被乘的数字（n-1）
        方法参数发生变化：
            5,4,3,2,1
*/
public class Demo03RecursionPractise {

    public static void main(String[] args) {
        int res = jc(3);
        System.out.println(res); // 6
    }

    private static int jc(int n) {
        // 如果n等于1，结束递归返回1
        if (n ==1) {
            return 1;
        }
        // 获取下一个被乘的数字(n-1)
        return n * jc(n - 1);
    }

}
