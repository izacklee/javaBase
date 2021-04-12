package com.zeroten.javales.day69c_netty.po;

import com.zeroten.javales.day69c_netty.EntityEnum;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import lombok.Data;

@Data
public class FsEntity extends BaseEntity {

    private byte[] fsData;

    public FsEntity(String fsId, int fLen, byte[] fData) {

        super(EntityEnum.FILE.getType(), fsId, fLen);

        this.fsData = fData;

    }

    public FsEntity(String fsId) {

        super(EntityEnum.FILE.getType(), fsId, 0);
    }

    @Override
    public ByteBuf getData() {

        ByteBuf bf = PooledByteBufAllocator.DEFAULT.buffer();
        bf.writeBytes(fsData);

        return bf;
    }

    public byte[] getFsData() {
        return fsData;
    }

    public void setFsData(byte[] fsData) {
        this.fsData = fsData;
    }
}
