/*
自增运算符：++
自减运算符：--

基本含义：让一个变量增加一个数字1，或者让一个变量减一个数字1
使用格式：写在变量名称之前，或者写在变量名称之后。例如：++num，也可以num--
使用方式：
	1.单独使用：不和其他操作混合，自己独立成为一个步骤。
	2.混合使用：和其他操作混合，例如：与赋值混合，或者与打印操作混合等。

使用区别：
	1.在单独使用的时候，前++和后++没有任何区别。也就是：++num;和num--;是完全一样的。
	2.在混合使用的时候，有【重大区别】
		A.如果是【前++】，那么变量【立刻马上+1】，然后拿着结果进行使用。【先加后用】
		B.如果是【后++】，那么首先使用原来的数值，【然后再让变量+1】。  【先用后加】

注意事项：
	只有变量才可以使用自增、自减的运算符，常量不可以发生改变，所以不能用。
*/

public class Demo06Operator{
	public static void main(String[] args){
		int num1 = 1;
		System.out.println(num1); // 1

		++num1; // 单独使用，前++
		System.out.println(num1); // 2
		num1++; // 单独使用，后++
		System.out.println(num1); // 3

		System.out.println("-------");

		// 与打印操作混合的时候
		int num2 = 2;
		// 混合使用，先++，变量会立马变成21，然后打印输出21
		System.out.println(++num2); // 3
		System.out.println(num2); // 3

		int num3 = 3;
		// 混合使用，后++，首先使用原来变量的3，然后再让变量+1得到4
		System.out.println(num3++); // 3
		System.out.println(num3); // 4

		System.out.println("-------");

		// 和赋值操作混合
		int num4 = 4;
		// 混合使用，前--，变量会立刻-1，变成3，然后再将结果3赋值给result变量
		int result = --num4;
		System.out.println(result); // 3
		System.out.println(num4); // 3

		int num5 = 5;
		// 混合使用，后--，首先使用原来的数值5赋值给result，然后再-1得到4
		int result1 = num5--;
		System.out.println(result1); // 5
		System.out.println(num5); // 4

		// 混合使用，前++与后--，再进行运算
		int x = 1;
		int y = 2;
		// 2 + 2 = 4;
		int result2 = ++x + y--;
		System.out.println(result2); // 4
		System.out.println(x); // 2
		System.out.println(y); // 1

		// 20++; // 错误的写法！常量不可使用++，或者--运算符

	}
}