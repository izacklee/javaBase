package com.zeroten.javales.day69c_netty.po;

import com.zeroten.javales.day69c_netty.EntityEnum;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import lombok.Data;

@Data
public class FsResponse extends BaseEntity {

    /**
     * 状态 1成功 0失败
     */
    private byte status;

    /**
     * 主机IP
     */
    private String host;

    public FsResponse() {

    }

    public FsResponse(String id, byte status, int length, String host) {

        super(EntityEnum.RESP.getType(), id, length);

        this.status = status;
        this.host = host;
    }

    @Override
    public ByteBuf getData() {

        // buffer的分配器
        ByteBuf bf = PooledByteBufAllocator.DEFAULT.buffer();
        bf.writeByte(status);
        bf.writeBytes(host.getBytes());

        return bf;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ip").append(",").append("发送状态：").append(status==0?"失败":"成功");

        return stringBuilder.toString();
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
