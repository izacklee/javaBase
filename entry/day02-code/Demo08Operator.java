/*
比较运算符：
大于：       >
小于：       <
大于等于：    >=
小于等于：    <=
等于：       ==  【两个等号才是相等，一个等号代表赋值】
不等于：     !=

注意事项：
	1.比较结果一定是一个boolean值，成立则为true，不成立则为false。
	2.如果进行多次判断，不能连着写。
	数学当中的写法：1 < x < 3，在程序中不能这么写。
*/

public class Demo08Operator{
	public static void main(String[] args){
		System.out.println(3 > 2); // true
		int num1 = 10;
		int num2 = 20;
		System.out.println(num1 < num2); // true
		System.out.println(num1 >= num2); // false
		System.out.println(num1 <= 10); // true
		System.out.println(num1 != 10); // false
		System.out.println(num2 == 20); // true

		// int x = 2;
		// System.out.println(1 < x < 3); //错误写法，不能连着写。

	}
}