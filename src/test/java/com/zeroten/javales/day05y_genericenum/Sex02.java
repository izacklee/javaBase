package com.zeroten.javales.day05y_genericenum;

public enum Sex02 {
    FEMALE(0){
        // 枚举方法的重写
        public boolean female() {
            return true;
        }

        public boolean male() {
            return false;
        }
    }, MALE(1){
        public boolean female() {
            return false;
        }

        public boolean male() {
            return true;
        }
    };
    private int i;
    // 构造要定义成私有的
    private Sex02(int i) {
        this.i = i;
    }

    public int getValue() {
        return this.i;
    }

    public boolean female() {
        return true;
    }

    public boolean male() {
        return true;
    }
}
