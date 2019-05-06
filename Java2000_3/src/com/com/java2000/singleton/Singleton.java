package com.com.java2000.singleton;

/**
 * 单例模式;
 * 1.多线程访问的安全问题
 * 2.加上volatile 关键字保证变量的一致性
 * 3.防止反射调用私有构造方法
 * 4.让单例类序列化安全
 */

public class Singleton {
    private volatile static Singleton singleton = null;
    private Singleton(){
        if (singleton !=null){
            throw new RuntimeException("此类对象为单例模式，已经被实例化了");
        }
    }
    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
