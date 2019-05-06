package com.com.java2000.thread;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadDemo05 {
    public static void main(String[] args) {
        //创建线程池 4种
        //1创建一个单线程的线程池

//        ExecutorService es = Executors.newSingleThreadExecutor();

//        ExecutorService es = Executors.newFixedThreadPool(1);

        ScheduledExecutorService es = Executors.newScheduledThreadPool(3);
//        es.execute(new MyRunnable6());
//        es.execute(new MyRunnable6());
        es.schedule(new MyRunnable6(),3000, TimeUnit.MILLISECONDS);
        es.shutdown();
    }
}

class MyRunnable6 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


