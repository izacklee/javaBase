package com.zeroten.javales.day05y_genericenum;

// 枚举没特殊必要 不建议用
public class Demo06UseEnum {

    public static void main(String[] args) {
        // 声明及赋值
        Sex male = Sex.MALE;
        // 在类的定义和使用中，传递
//        Enum e = new Enum();
//        e.setSex(male);

        // 在switch中使用传递
        switch(male) {
            case MALE:
                break;
            case FEMALE:
                break;
        }
    }

}
