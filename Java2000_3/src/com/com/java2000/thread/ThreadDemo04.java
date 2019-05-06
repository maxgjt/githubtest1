package com.com.java2000.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo04 {
    public static void main(String[] args) {
        MyRunnable5 myRunnable5 = new MyRunnable5();
        Thread t1 = new Thread(myRunnable5);
        Thread t2 = new Thread(myRunnable5);
        t1.start();
        t2.start();
    }
}

class MyRunnable5 implements Runnable {
    private int ticket = 10;
//    private Object obj = new Object(); // 同步锁

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            method2();
        }
    }

    //互斥锁
    ReentrantLock lock = new ReentrantLock();
    private void method2(){
        lock.lock(); //锁
        try {
            if (ticket > 0) {
                ticket--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("您购买的票还剩余" + ticket + "张");
            }
        }finally {
            lock.unlock(); //释放锁
        }
    }

    //同步方法，同步的对象是当前对象(thiis);
    private synchronized void method() {
        if (ticket > 0) {
            ticket--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("您购买的票还剩余" + ticket + "张");
        }
    }
}