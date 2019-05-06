package com.com.java2000.thread;

public class ProducerCustomerDemo {
    public static void main(String[] args) {
        Food food =new Food();
        Producer p = new Producer(food);
        Custmers c = new Custmers(food);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}

class  Food{
    private String name;
    private String desc;
    private boolean flag = true; // true 表示可以生产，false表示可以消费

    //生产产品
    public synchronized void set(String name,String desc){
        if (!flag){
            try {
                this.wait(); //线程进入等待状态，释放监视器的所有权;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setName(name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setDesc(desc);
        flag = false;
        this.notify();//唤醒等待的线程（随机其中一个）
    }

    //消费产品

    public synchronized void get(){
        //不能消费
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+"->" +this.getDesc());
        flag = true;
        this.notify();//唤醒线程
    }

    public Food() {}

    public Food(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }


}

class Producer implements Runnable{
    private Food food;

    public Producer(Food food){
        this.food=food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2 == 0){
                food.set("锅包肉","酸甜可口，爽");
            }else {
                food.set("佛跳墙","滋阴补阳，good");
            }
        }
    }
}

class Custmers implements Runnable{
    private Food food;

    public Custmers(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            food.get();
        }
    }
}