/*
数字和字符的对照关系表（编码表）

ASCII码表：American Standard Code For Information Interchange，美国信息交换标准代码。
Unicode码表：万国码。也是数字和符号的对应关系，开头0-127部分和ASCII码表完全一样，但是从128开始包含更多字符。

主要记住这三个ASCII值对应的控制字符即可：
48 - '0'
65 - 'A'
97 - 'a'
*/
public class Demo03DataChar{
	public static void main(String[] args){
		char zifu = '1';
		System.out.println(zifu + 0); // 49

		char zifu2 = 'A'; //其实底层保存到数字是65

		char zifu3 = 'c'; 

		// 左侧是int类型，右侧是char类型
		// char --> int，确实从小到大
		// 发生自动类型转换
		int num = zifu3;
		System.out.println(num); // 99

		char zifu4 = '中'; //正确写法
		System.out.println(zifu4 + 0); //20013
	}
}