package com.com.java2000.thread;

public class ThreadDemo01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();//启动线程

        MyRunable myRunable = new MyRunable();
        Thread thread = new Thread(myRunable);
        thread.start();

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + "->" + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + "->" + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}