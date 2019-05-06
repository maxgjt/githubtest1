package com.java2000.server.communication;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ExecutorService es = Executors.newSingleThreadExecutor();
        try {
            Socket socket = new Socket("localhost",8888);
            System.out.println("服务器连接成功!");
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            // 像服务器发送登录信息
            System.out.println("请输入名称：");
            String name = input.nextLine();

            Message message = new Message(name,null,MessageType.TYPE_LOGIN,null);
            oos.writeObject(message);
            Message info = (Message)ois.readObject();
            System.out.println(info.getInfo()+info.getFrom());
            //启动读取消息的线程
            es.execute(new ReadInfoThread(ois));

            //使用主线程来实现发送消息;
            boolean flag = true;
            while (flag){
                Message msg = new Message();
                System.out.println("To: ");
                msg.setTo(input.nextLine());
                msg.setFrom(name);
                msg.setType(MessageType.TYPE_SEND);
                System.out.println("Info:");
                msg.setInfo(input.nextLine());
                oos.writeObject(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

//读取消息
class ReadInfoThread implements Runnable{

    private  ObjectInputStream in;
    private  boolean flag = true;

    public ReadInfoThread(ObjectInputStream in) {
        this.in = in;
    }

    public ReadInfoThread(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {

            while (flag){
                Message message = (Message) in.readObject();
                System.out.println("【"+message.getFrom()+"】对我说"+message.getInfo());
            }
            if (in!=null){
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
