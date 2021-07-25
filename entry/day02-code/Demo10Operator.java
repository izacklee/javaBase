/*
一元运算符：只要一个数据就可以进行操作的运算符。例如：取反!、自增++、自减--
二元运算符：需要两个数据才可以操作的运算符。例如：加法+、赋值=
三元运算符：需要三个数据才可以进行操作的运算符。

格式：
	数据类型 变量名称 = 条件判断 ？ 表达式A ：表达式B;

流程：
	首先判断条件是否成立：
	   如果成立为true，那么将表达式A的值赋值给左侧变量；
	   如果不成立为false，那么将表达式B的值赋值给左侧变量；
	二者选其一。

注意事项：
	1.必须保证表达式A和表达式B都符合左侧数据类型要求。
	2.三元运算符的结果必须被使用。
*/

public class Demo10Operator{
	public static void main(String[] args){
		int a = 2;
		int b = 3;

		// 判断a > b 是否成立，如果成立则将a赋值给变量max，如果不成立则将变量b赋值给max;
		int max = a > b ? a : b;
		System.out.println("最大值：" + max); // 3 

		// int result = 1 < 2 ? 10 : 12.5; // 错误写法！ 12.5为double类型的值，不能赋值给int类型。
		// System.out.println(result);

		// a > b ? a : b; // 错误写法！运算结果没有被使用。

		// 按位非运算符
//		int c=6;
//		System.out.println("c 非的结果是："+(~c)); // -7
	}
}