package com.java2000.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPClientDemo {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        try {
            DatagramSocket socket = new DatagramSocket(8000);
            System.out.println("正在接收数据中。。。");
            socket.receive(dp);
            String s = new String(dp.getData(),0,dp.getLength());
            System.out.println(s);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
