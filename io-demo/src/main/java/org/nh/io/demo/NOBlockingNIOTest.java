package org.nh.io.demo;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

public class NOBlockingNIOTest {
    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(9897));
        //切换成非阻塞模式
        socketChannel.configureBlocking(false);
        //分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //发送数据给服务器端
        buffer.put("this is one".getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        //关闭通道
        socketChannel.close();
    }

    @Test
    public void server() throws IOException {
        //获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //切换成非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(9897));
        //获取选择器
        Selector selector = Selector.open();
        //将通道注册到选择器上,并且指定监听事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //轮询式的获取选择器上已经“准备就绪”的事件
        while (selector.select() > 0) {
            //获取当前选择器中所有注册的“选择键（已注册的监听事件）”
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            //遍历
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                //判断具体是什么事件准备就绪
                if (selectionKey.isAcceptable()) {
                    //如果是“接受就绪”，获取客户端的连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //切换成非阻塞模式
                    socketChannel.configureBlocking(false);
                    //将该通道注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    //获取当前选择器上“读就绪”状态的通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    //读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = socketChannel.read(buffer)) != -1) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                        buffer.clear();
                    }

                }
                //取消选择键
                iterator.remove();
            }


        }


    }

}
