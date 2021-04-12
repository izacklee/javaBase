package com.zeroten.javales.day69c_netty;

import com.zeroten.javales.day69c_netty.po.FsEntity;
import io.netty.buffer.ByteBuf;

import java.util.List;

public class FsEntityDecoder implements MsgDecoder{


    @Override
    public void doDecode(String id, int fsLen, ByteBuf byteBuf, List<Object> out) {

        byte[] bytes = new byte[fsLen];

        byteBuf.readBytes(bytes);

        out.add(new FsEntity(id, fsLen, bytes));
    }
}
