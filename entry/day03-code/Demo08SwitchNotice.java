/*
switch语句注意事项：
	1.多个case后面的数值不可重复。
	2.switch后面小括号当中只能是下列数据类型：
		基本数据类型：byte/short/int/char
		引用数据类型：String字符串、enum枚举
	3.switch语句可以很灵活：前后顺序可以颠倒，而且break语句还可以省略。
	“匹配哪一个case，就从哪一个case向下穿透执行，直到遇到break或整体结速为止”。
*/
public class Demo08SwitchNotice{
	public static void main(String[] args){
		int num = 2;
		switch(num){
			case 1:
				System.out.println("东风日产");
				break;
			case 2:
				System.out.println("保时捷");
				// break;
			case 3:
				System.out.println("玛莎拉蒂");
				// break;
			default:
				System.out.println("奔驰");
				break;

			/*
				结果输出：
					保时捷
					玛莎拉蒂
					奔驰
			*/
		}
	}
}