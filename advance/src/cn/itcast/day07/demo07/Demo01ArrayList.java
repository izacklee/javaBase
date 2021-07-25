package cn.itcast.day07.demo07;

import java.util.ArrayList;

/*
    Lambda表达式：是可推导，可省略
    凡是根据上下文推导出来的内容，都可以省略书写
    可以省略的内容：
        1.（参数列表）：括号中参数列表的数据类型，可以省略不写
        2.（参数列表）：括号中参数如果只有一个，那么数据类型和()都可以省略
        3. {一些代码}：如果{}中代码只有一行，无论是否有返回值，都可以省略({}, return, 分号)
            注意：要省略{}，return，分号必须一起省略
*/
public class Demo01ArrayList {

    public static void main(String[] args) {
        // JDK1.7版本之前，创建集合对象必须把前后的泛型都写上
        ArrayList<String> list = new ArrayList<String>();

        // JDK1.7之后，=号后面的泛型可以省略，后面的泛型可以根据前面的泛型推导出来
        ArrayList<String> list2 = new ArrayList<>();

    }
}
