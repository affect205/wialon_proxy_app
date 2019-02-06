package com.alexside.proxy.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WialonHandler extends ChannelInboundHandlerAdapter {
    private static final Logger log = LoggerFactory.getLogger(WialonHandler.class);
    private byte[] resp = new byte[]{0x1, 0x2, 0x3};

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        log.info("Handler added");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        log.info("Handler removed");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object in) {
        byte[] bytes = (byte[]) in;
        log.info("Message received: {}", Hex.encodeHexString(bytes));
        ctx.write(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }
}