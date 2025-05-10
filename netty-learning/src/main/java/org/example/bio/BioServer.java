package org.example.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);
        while (true) {
            Socket accept = socket.accept();
            InputStream inputStream = accept.getInputStream();
            int length;
            byte[] buffer = new byte[1024];
            while ((length = inputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, length));
            }
            System.out.println("------------------客户端断开连接-----------------------");
        }
    }
}
