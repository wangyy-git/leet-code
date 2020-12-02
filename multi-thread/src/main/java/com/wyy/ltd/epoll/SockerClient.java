package com.wyy.ltd.epoll;

import java.io.IOException;
import java.net.Socket;

public class SockerClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 18082);
//        InetSocketAddress address = new InetSocketAddress();
//        socket.bind(address);
        System.out.println(socket.getInetAddress());
        socket.close();
    }
}
 