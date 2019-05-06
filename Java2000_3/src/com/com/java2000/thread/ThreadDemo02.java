package com.com.java2000.thread;

public class ThreadDemo02 {
    public static void main(String[] args) {
//
//        MyRunnable2 myRunable2 = new MyRunnable2();
//        Thread thread = new Thread(myRunable2);
//        thread.start();


        MyRunnable3 myRunnable3 = new MyRunnable3();

        Thread thread1 = new Thread(myRunnable3);
        thread1.start();


        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i == 20) {
//                try {
//                    thread.join(); // 让threa 线程执行完毕，再继续执行主线程;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                thread.interrupt(); //中断异常，只是做了一个中断标记;
                myRunnable3.flag = false;
            }
        }
    }
}


class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (Thread.interrupted()) { //测试中断状态，此方法会把中断状态清除；
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}


class MyRunnable3 implements Runnable {
    public boolean flag = true;

    public MyRunnable3() {
        flag = true;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "===" + (i++));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}