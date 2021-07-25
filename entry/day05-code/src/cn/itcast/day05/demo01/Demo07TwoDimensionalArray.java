package cn.itcast.day05.demo01;

/*
    求货架上鸡蛋总数的例子

    考察：变量、数据类型、流程控制、循环、数组。
*/
public class Demo07TwoDimensionalArray {

    public static void main(String[] args) {
        int[][] array = new int[3][6];
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println("------------第" + (i+1) + "层货架------------");
            for (int j = 0; j < array[i].length; j++) {
                int num = (i + 1) * (j + 1);
                total += num;
                System.out.println("第" + (j+1) + "格挡鸡蛋的个数：" + num + "个");
            }
        }
        System.out.println("货架上鸡蛋的总数：" + total);
    }

}
