package com.wyy.ltd.epoll;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer2 {

    static List<Socket> sockets = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int port = 18082;
        ServerSocket socket = new ServerSocket(port);
        Socket accept = socket.accept();//阻塞等待客户端连接
        System.out.println(accept);
        accept.getInputStream().read();
        System.out.println("client close");
        
    }
}
