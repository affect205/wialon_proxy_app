package com.alexside;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientHandler extends SimpleChannelInboundHandler {
    private static final Logger log = LoggerFactory.getLogger(ClientHandler.class);
    private byte[] req = {0x05, 0x06, 0x07};

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        log.info("Send request: {}", req);
        ctx.writeAndFlush(req);
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object in) {
        byte[] bytes = (byte[]) in;
        log.info("Received response: {}", Hex.encodeHexString(bytes));
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable cause){
        cause.printStackTrace();
        channelHandlerContext.close();
    }
}