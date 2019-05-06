package com.java2000.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class EchoServerDemo {
    public static void main(String[] args) {
        // 创建一个服务器端的Socket（1024-65535）
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("服务器已经启动，正在等待客户端的连接...");
            //等待客户端的连接，造成阻塞如果有客户端连接成功，立即返回;
            Socket socket = server.accept();
            System.out.println("客户端连接成功!"+server.getInetAddress().getHostAddress());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //通过输入流读取网络数据,如果没有数据，也会造成阻塞;
            String info = bufferedReader.readLine();
            System.out.println(info);

            //获取输出流，向客户端返回消息;
            PrintStream printStream = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            printStream.println("echo:"+info);

            printStream.flush();
            printStream.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
