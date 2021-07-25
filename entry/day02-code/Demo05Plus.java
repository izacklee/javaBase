/*
四则运算当中的加号“+”有常见的三种用法：

1.对于数值来说，那就是加法。
2.对于char来说，在计算之前先把char提升为int，再进行加法计算。
  char类型字符和int类型数字之间对照表：ASCII和Unicode
3.对于字符串String（首字母大写，因不是关键字）来说，代表字符串连接操作。
  任何数据类型和字符串连接的时候，结果都会变成字符串。
  四则运算优先级当中，只需要记住在小括号里的优先计算就行，其他不用记。
*/

 public class Demo05Plus{
 	public static void main(String[] args){
 		// 1.上一节讲过
 
 		// 2.上一节也讲过

 		// 3.字符串类型的变量基本使用
 		// 数据类型 变量名称 = 数据值;
 		String str1 = "Hello";
 		System.out.println(str1); // Hello

 		// 两字符串拼接
 		System.out.println(str1 + "World"); // HelloWorld

 		//字符串与int类型运算
 		String str2 = "Java";
 		// String + int --> String
 		System.out.println(str2 + 10); // Java10

 		// 优先级问题
 		// String + int + int
 		// String + int
 		// String
 		System.out.println(str2 + 10 +20); // Java1020

 		// 运算中加小括号，优先计算小括号里的数据
 		System.out.println(str2 + (10 + 20)); // Java30
 	}
 }