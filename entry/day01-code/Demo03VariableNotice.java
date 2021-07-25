/*
使用变量的时候，有一些注意事项

1、创建多个变量，那么变量的名称不能重复。
2、对于float和long，字母后缀F和L不要丢掉。
3、如果使用byte和short类型变量，右侧的赋值不能超过左侧数据类型的取值范围。
4、没有赋值的变量不能使用，一定要赋值后才能使用。
5、变量的使用不能超过作用域的范围。
   作用域：从定义变量的一行开始，一直到直接所属的大括号结束为止。
6、可以通过一个语句来创建多个变量，但一般情况不推荐这么写。
*/
public class Demo03VariableNotice{
	public static void main(String[] args){
		//1
		int num1 = 10; //创建了一个新的变量
		// int num1 = 20; //又创建了一个同名的变量，错误！
        
        //3
		// int num2;
		// System.out.println(num2); //定义的变量没赋值 不能直接用

      	//5
      	int num3 = 50;
      	System.out.println(num3);

      	{
      		int num4 = 200;
      		System.out.println(num4);
      	}
      	// System.out.println(num4); //在定义的变量作用域外使用，错误！

      	//6
      	//同时创建3个分别为int型的变量 --- 不推荐
      	int a, b, c;
      	//分别给各个变量赋值
      	a = 10;
      	b = 20;
      	c = 30;
      	System.out.println(a); // 10
      	System.out.println(b); // 20
      	System.out.println(c); // 30

      	//同时创建3个int型的变量，并直接赋值 --- 不推荐
      	int a1 = 100, b1 = 200, c1 = 300;
      	System.out.println(a1); // 100
      	System.out.println(b1); // 200
      	System.out.println(c1); // 300
	}
}