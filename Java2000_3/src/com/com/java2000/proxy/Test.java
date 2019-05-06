package com.com.java2000.proxy;

public class Test {
    public static void main(String[] args) {
        CreateProxy createProxy = new CreateProxy(); // 用来创建代理对象的对象;
        Subject person = new Person();
        Subject proxy = (Subject) createProxy.create(person);
        proxy.shopping();  //调用invoke方法
    }
}
