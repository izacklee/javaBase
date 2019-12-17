package com.zeroten.javales.flow;

import org.testng.annotations.Test;

import java.util.Scanner;

public class SwitchTest {

    /**
     * 练习：假如你有一个机器人，你通过输入数字指令来指挥机器人，
     * 比如输入 1 让机器人扫地，输入 2 让机器人打开灯。具体指令如下：
     *
     * 数字指令	执行命令
     * 1	扫地
     * 2	开灯
     * 3	关灯
     * 4	播放音乐
     * 5	关闭音乐
     * 其他数字	不能识别的指令
     */
    @Test(description="测试111")
    public void testSwitch() {
        // 单元测试 不能读取键盘输入
//        Scanner s = new Scanner(System.in);
//        System.out.println("请输入数字，指挥机器人：");
//        int num = s.nextInt();
        int num = 2;
        switch(num) {
            case 1:
                System.out.println("执行1，让机器人扫地");
                break;
            case 2:
                System.out.println("执行2，让机器人开灯"); // 执行2，让机器人开灯
//                break;
            case 3:
                System.out.println("执行3，让机器人关灯"); // 执行3，让机器人关灯
                break;
            case 4:
                System.out.println("执行4，让机器人播放音乐");
                break;
            case 5:
                System.out.println("执行5，让机器人关闭音乐");
                break;
            default:
                System.out.println(num + "是其它数字，不能识别的指令");
                break;

        }
    }
}
