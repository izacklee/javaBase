/*
 运算符：进行特定操作的符号，例如：+
 表达式：用运算符连接起来的式子叫做表达式。例如：20 + 5。又例如：a + b
 四则运算：
 加：+
 减：-
 乘：*
 除：/

 取模运算（取余数）：%
 首先计算得到表达式的结果，然后再打印输出这个结果。
 复习一下小学一年级的除法公式：
 被除数 / 除数 = 商 ...余数

 对于一个整数的表达式来说，除法用的是整除，整数除以整数，结果仍然是整数，不看余数。
 只有对于整数的除法来说，取模运算才有意义。

 注意事项：
 	1.一单运算当中有不同类型的数据，那么结果将会是数据类型大的那种。
*/
public class Demo04Operator{
	public static void main(String[] args){
		//两个常量之间可以进行数学运算
		System.out.println(20 + 30); // 50

		//两个变量之间也可以进行数学运算
		int a = 2;
		int b = 3;
		System.out.println(a - b); // -1

		//变量之间也可以混合使用
		System.out.println(a * 5); // 10;

		int x = 10;
		int y = 5;
		int result = x * y; 
		int result1 = x / y;
		int result2 = x % y; //余数，模 0
		System.out.println(result); // 50
		System.out.println(result1); // 2
		System.out.println(result2); // 0

		//int + double --> double + double -->double
		double result3 = x + 2.5;
		System.out.println(result3); //12.5

	}
}