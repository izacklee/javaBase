package com.zeroten.javales.day69c_netty;

import com.zeroten.javales.day69c_netty.po.FsResponse;
import io.netty.buffer.ByteBuf;

import java.util.List;

public class FsEntityRespDecoder implements MsgDecoder {


    @Override
    public void doDecode(String id, int rspLen, ByteBuf byteBuf, List<Object> out) {

        byte status = byteBuf.readByte();

        byte[] tmpBytes = new byte[rspLen - 1];

        byteBuf.readBytes(tmpBytes);

        String host = new String(tmpBytes);

        FsResponse response = new FsResponse(id, status, rspLen, host);

        out.add(response);
    }
}
