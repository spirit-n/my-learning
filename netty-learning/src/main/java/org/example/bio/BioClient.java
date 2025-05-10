package org.example.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class BioClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                sayHello();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        },"thread1");
        Thread thread2 = new Thread(() -> {
            try {
                sayHello();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        },"thread2");
        thread1.start();
        thread2.start();
    }

    private static void sayHello() throws IOException, InterruptedException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 8080));
        OutputStream outputStream = socket.getOutputStream();
        for (int i = 1; i <= 10; i++) {
            outputStream.write(("hello " + Thread.currentThread().getName()  + " "+i).getBytes());
            outputStream.flush();
        }
        Thread.sleep(100);
        socket.close();
    }


}
