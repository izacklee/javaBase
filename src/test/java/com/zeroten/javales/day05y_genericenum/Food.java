package com.zeroten.javales.day05y_genericenum;

public interface Food {
    // 在接口中，所有属性都是常量，所有方法都是静态方法
    enum A implements Food {
        AA,AAA,AAAA
    }
    enum B implements Food {
        BB,BBB,BBBB
    }
}
