package org.nh.netty.demo1.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @program: ClientDemo1.java
 * @description:
 * @author: yindanqing
 * @create: 2020/10/23 17:02
 */
public class ClientDemo1 {

    public static void main(String[] args) throws Exception  {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel sc) throws Exception {
                sc.pipeline().addLast(new ClientHandlerDemo1());
            }
        });

        ChannelFuture cf1 = b.connect("127.0.0.1", 8888).syncUninterruptibly();
        // 发送消息
        byte[] msg = "发送第1条测试消息".getBytes();
        cf1.channel().writeAndFlush(Unpooled.copiedBuffer(msg));

        // 等待关闭
        cf1.channel().closeFuture().sync();
        group.shutdownGracefully();
    }
}
