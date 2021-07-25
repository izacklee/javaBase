/*
常量：在程序运行期间，固定不变的量

常量的分类：
1、字符串常量：凡用双引号引起来的部分，叫做字符常量。例如："abc"、"123"
2、整数常量：直接写上数字，没有小数点。例如:123、100、0、-200
3、浮点数常量：直接写上数字，有小数点。例如：1.5、3.14、0.0
4、字符常量：凡用单引号引起来的部分，叫做字符常量。例如：'a'、'1'
5、布尔常量：只有两种取值，true、false
6、空常量：null。代表没有任何数据
*/
public class Demo01Const{
	public static void main(String[] args){
		//字符串常量
		System.out.println("Hello World!!!");
		System.out.println("");//两双引号中间的内容可为空。
		System.out.println("100");

		//整数常量
		System.out.println(100);
		System.out.println(-200);

		//浮点常量
		System.out.println(3.14);

		//字符常量
		System.out.println('a');
//		 System.out.println('abc'); //字符常量单引号中间只能有一个字符
		// System.out.println(''); //单引号中间必须有内容

	    //布尔常量
	    System.out.println(true);
	    System.out.println(false);

	    //空常量
	    // System.out.println(null); //null 不能直接打印输出

	}
}