package cn.itcast.day05.demo02;

/*
Java的内存需要划分成为5个部分：

1.栈（Stack）: 存的都是方法的局部变量。方法的运行一定要在栈当中运行。
2.堆（Heap）：凡是new出来的东西都在堆中。
    堆内存里的数据都是有默认值的。规则：
        如果是整数       默认0
        如果是浮点数     默认0.0
        如果是字符       默认'\u0000'
        如果是布尔       默认false
        如果是引用类型    默认null
3.方法区（Method Area）:存储.class相关信息，包含方法的信息。
4.本地方法栈（Native Method Stack）：与操作系统相关。
5.寄存器（pc Register）:与CPU相关。
*/

public class Demo06MemoryArea {
    public String name="内存";
}
