package com.java2000.observer;


public interface MessageSubject {
    //注册观察者
    public  void registerObserver(Observer o);
    //移除观察者
    public  void removeObserver(Observer o);
    //通知所有观察者
    public  void notifyObserver();
}
