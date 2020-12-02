package com.wyy.ltd.epoll;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {

    static List<Socket> sockets = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int port = 18080;
        while (true){
            ServerSocket socket = new ServerSocket(port++);
            Socket accept = socket.accept();//阻塞等待客户端连接
            System.out.println(accept);
            sockets.add(accept);
            
            for (Socket s:sockets){
                //客户端关闭连接 read方法会自己解阻塞
                int read = s.getInputStream().read();//假定这个方法非阻塞 根据返回read值判断是否操作
                if (read>0) {//说明客户端发送信息过来了 可以执行一些操作 这就是轮循的逻辑
                    //但是这种情况list的遍历限制了性能
                    //并且获取socket操作也是要通过内核去处理
                    // 所以将遍历交给内核函数select()去处理来提升性能
                }
            }
        }

    }
    
    public void NIO() throws Exception {
        List<SocketChannel> list = new ArrayList();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //服务端只用监听自身的当前接口就行 等待其他机器的连接
        //这里就是实现一个非阻塞的socket
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(9091));
        ssc.configureBlocking(false);
        while (true){
            SocketChannel socketChannel = ssc.accept();
            if(socketChannel==null){
                Thread.sleep(1000);
                System.out.println("没人连接");
            }else{
                socketChannel.configureBlocking(false);
                list.add(socketChannel);
            }
            //得到套接字，循环所有的套接字，通过套接字获取数据
            //因为无论是否有新人来连接都需要遍历socket
            for (SocketChannel channel : list) {
                int k =channel.read(byteBuffer);
                System.out.println(k+"=======================================");
                if(k!=0){
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array()));
                }
            }
        }
    }
}
