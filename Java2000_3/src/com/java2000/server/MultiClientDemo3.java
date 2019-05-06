package com.java2000.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MultiClientDemo3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 创建一个Socket 对象，指定要连接的服务器
        try {
            //获取socket 的输入输出流;
            Socket socket = new Socket("localhost",6666);

            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("请输入： ");
            String info = input.nextLine();
            ps.println(info);
            ps.flush();

            // 读取服务器端返回的数据
            info = br.readLine();
            System.out.println(info);
            ps.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
