package com.zeroten.javales.day69c_netty.po;

import io.netty.buffer.ByteBuf;
import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseEntity implements Serializable {

    /**
     * 实体类型
     */
    private int type;

    /**
     * 长度，bytes
     */
    private int length;

    /**
     * 实体ID
     */
    private String id;


    public BaseEntity() {

    }

    public BaseEntity(int type, String id, int length) {

        this.type = type;
        this.length = length;
        this.id = id;
    }

    public abstract ByteBuf getData();

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
