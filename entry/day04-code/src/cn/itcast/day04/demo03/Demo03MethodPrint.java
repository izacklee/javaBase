package cn.itcast.day04.demo03;

/*
题目要求：
    定义一个方法，用来打印指定次数的HelloWorld
*/

public class Demo03MethodPrint {
    public static void main(String[] args) {
        printCount(3);
    }

    /*
     三要素
        返回值类型：只是进行一大堆打印而已，没有计算，也没有结果要告诉调用处
        方法名称：printCount
        参数列表：到底要打印多少次？必须告诉我，否则我没法打印。次数：int
    */

    public static void printCount(int num) {
        for (int i = 1; i <= num; i++) {
            System.out.println("HelloWorld" + i);
        }
    }
}
