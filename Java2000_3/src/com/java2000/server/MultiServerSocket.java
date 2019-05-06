package com.java2000.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiServerSocket {
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(3);
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("服务器已经开启，正在等待链接……");
            while (true) {
                Socket s = server.accept();
                System.out.println("连接成功……");
                System.out.println(s.getInetAddress().getHostAddress());
                es.execute(new UserThread(s));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


class UserThread implements Runnable {
    private Socket s;

    public UserThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintStream ps = new PrintStream(new BufferedOutputStream(s.getOutputStream()));
            String info = br.readLine();
            System.out.println(info);
            ps.println("echo"+info);
            ps.flush();
            ps.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}