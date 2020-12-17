package org.nh.io.demo;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


/**
 * 一、使用NIO完成网络通信的三个核心：
 * ①通道（Channel）：负责连接。
 * java.nio.channels.Channel接口：
 * 		|--SelectableChannel
 * 		|--SocketChannel
 * 		|--ServerSocketChannel
 * 		|--DatagramChannel
 *
 * 		|--Pipe.SinkChannel
 * 		|--Pipe.SourceChannel
 * ②缓冲区（Buffer）：负责数据的存取。
 * ③选择器（Selector）：是SelectableChannel的多路复用器。用于监控SelectableChannel的一些IO状况。
 */
public class BlockingNIOTest {

    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(9898));

        FileChannel fileChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

        //分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //读取本地文件，并发送到服务器端
        while (-1 != fileChannel.read(buffer)) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        //通知服务器端传送完毕
        socketChannel.shutdownOutput();

        int len = 0;

        while ((len = socketChannel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(),0,len));
            buffer.clear();
        }


        fileChannel.close();
        socketChannel.close();
    }

    @Test
    public void server() throws IOException {
        //获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //绑定端口号
        serverSocketChannel.bind(new InetSocketAddress(9898));

        SocketChannel socketChannel = serverSocketChannel.accept();

        FileChannel fileChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (-1 != socketChannel.read(buffer)) {
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }

        buffer.put("服务器端接受成功".getBytes());
        buffer.flip();

        socketChannel.write(buffer);


        fileChannel.close();
        socketChannel.close();
    }


}