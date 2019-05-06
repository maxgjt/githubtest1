package com.com.java2000.thread;

public class ThreadDemo03 {
    public static void main(String[] args) {
        MyRunnable4 myRunnable4 = new MyRunnable4();
        Thread thread = new Thread(myRunnable4);
        //
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("main----" + i);
        }
    }
}

class MyRunnable4 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("----" + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}