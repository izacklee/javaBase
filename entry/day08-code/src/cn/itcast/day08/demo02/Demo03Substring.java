package cn.itcast.day08.demo02;

/*
字符串的截取方法：

public String substring(int index): 截取从参数位置一直到字符串末尾，返回新字符串。
public String substring(int begin， int end)：截取从begin开始，一直到end结束，中间的字符串。
备注：[begin,end),左闭右开（包含左边，不包含右边）。
*/
public class Demo03Substring {
    public static void main(String[] args) {
        // 一个参数的截取字符
        String str1 = "HelloWorld";
        String result = str1.substring(5);
        System.out.println(str1); // HelloWorld，原封不动
        System.out.println("截取出来的字符：" + result); // World，新字符串

        // 两个参数的截取字符串
        String result1 = str1.substring(5, 7);
        System.out.println("两参数截取出来的字符：" + result1); // Wo

        // 下面这种写法字符串的内容仍然是没有改变的
        // 下面两个字符串："Hello","Java"
        // StrA当中保存的是地址值。
        // 本来地址值是Hello的0X666
        // 后来变成了Java的0X999
        String strA = "Hello";
        System.out.println(strA); // Hello
        String strB = "Java";
        System.out.println(strB); // Java

    }
}
