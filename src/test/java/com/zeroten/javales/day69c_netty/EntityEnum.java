package com.zeroten.javales.day69c_netty;

public enum EntityEnum {

    RESP(1),FILE(2);

    private int type;

    EntityEnum(int type) {

        this.type = type;
    }

    public int getType() {

        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
