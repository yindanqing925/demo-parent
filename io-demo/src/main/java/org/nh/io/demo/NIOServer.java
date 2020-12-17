package org.nh.io.demo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: NIOServer.java
 * @description:
 * @author: yindanqing
 * @create: 2020/12/2 17:15
 */
public class NIOServer extends Thread {

    public void run() {
        try (Selector selector = Selector.open();
             ServerSocketChannel serverSocket1 = ServerSocketChannel.open();
             ServerSocketChannel serverSocket2 = ServerSocketChannel.open()) {// 创建Selector和Channel
            serverSocket1.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocket1.configureBlocking(false);
            // 注册到Selector，并说明关注点
            serverSocket1.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select();// 阻塞等待就绪的Channel，这是关键点之一
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectedKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    // 生产系统中一般会额外进行就绪状态检查
                    sayHelloWorld((ServerSocketChannel) key.channel());
                    iter.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sayHelloWorld(ServerSocketChannel channel) throws IOException {
        try (SocketChannel client = channel.accept();) {
            //分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(8);
            StringBuffer sb = new StringBuffer();
            while (-1 != client.read(buffer)){
                buffer.flip();
                sb.append(buffer.get());
                buffer.clear();
            }
            System.out.println("server receive:" + sb.toString());
            client.write(Charset.defaultCharset().encode("Hello world!"));
        }
    }

    public static void main(String[] args) throws IOException {
        NIOServer server = new NIOServer();
        server.start();
        try (Socket client = new Socket(InetAddress.getLocalHost(), 8888);) {
            client.getOutputStream().write("this is one ".getBytes());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(System.out::println);
        }
    }
}