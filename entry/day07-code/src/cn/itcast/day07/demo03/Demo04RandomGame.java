package cn.itcast.day07.demo03;

import java.util.Random;
import java.util.Scanner;

/*
题目：用代码模拟猜数字游戏。

思路：
    1.首先要产生一个随机数，并且一旦产生就不再变化。用Random的nextInt方法
    2.需要键盘输入，用到Scanner
    3.获取输入键盘的数字，用Scanner当中的nextInt方法
    4.已经得到了两个数字，用(if)判断一下：
        如果太大了，提示太大，并重试
        如果太小了，提示太小，并重试
        如果猜中了，游戏结束
    5.重试就是再来一次，循环次数不定，用while(true)。
*/
public class Demo04RandomGame {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNum = r.nextInt(100); // [0, 100)
        int i = 0;
        while (true) {
            i++;
            if (i > 10) {
                System.out.println("猜数超过限制，最多只能猜10次。");
                break;
            }
            Scanner sc = new Scanner(System.in);
            int guessNum = sc.nextInt();
            if (guessNum > randomNum) {
                System.out.println("太大了，请重新输入");
            } else if (guessNum < randomNum) {
                System.out.println("太小了，请重新输入");
            } else {
                System.out.println("恭喜你，猜中了");
                break;
            }
        }
        System.out.println("游戏结束！");
    }
}
