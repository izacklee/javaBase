package com.zeroten.javales.day69c_netty.client;

public enum ClientTypeEnum {

    FILE_SENDER(1),CLASS_LOADER(2);

    private int type;

    private ClientTypeEnum(int type) {

        this.type = type;
    }

    public int getType() {

        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
