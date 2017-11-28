package me.codz;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * <p>Created with IDEA
 * <p>Author: laudukang
 * <p>Date: 2017-3-8
 * <p>Time: 20:50
 * <p>Version: 1.0
 */
public class DiscardServerHandler extends ChannelHandlerAdapter { // (1)

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
		// Discard the received data silently.
		((ByteBuf) msg).release(); // (3)
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {        // (4)
		// Close the connection when an exception is raised.
		cause.printStackTrace();
		ctx.close();
	}
}
