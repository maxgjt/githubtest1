package com.java2000.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientDemo {
    public static void main(String[] args) {
        // 创建一个Socket 对象，指定要连接的服务器
        try {
            //获取socket 的输入输出流;
            Socket socket = new Socket("localhost",6666);

            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            ps.println("hello,my name is Bin");
            ps.flush();

            // 读取服务器端返回的数据
            String info = br.readLine();
            System.out.println(info);
            ps.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
