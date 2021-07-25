/*
题目：求出1-100之间的偶数和

思路：
	1.从题目可知范围是1-100，那么我就从1,2,3...100逐一查找出偶数。
	2.范围在100之中并非所有的数都为偶数，那么就需要条件（if语句）判断偶数：num % 2 == 0;
	3.将查找出来的偶数存到一个变量里，并做累加操作，最终得出偶数和。也就好比一个存钱罐。
*/

public class Demo12HundredSum {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			// 如果是偶数
			if (i % 2 == 0) { 
				sum += i; // 将偶数累加求和
			}
		}
		System.out.println("结果是：" + sum); // 2550
	}
}