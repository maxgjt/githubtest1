package com.com.java2000.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CreateProxy implements InvocationHandler {
    private  Object target;// 被代理的对象

    //用于创建代理对象的方法
    public Object create(Object target){
        this.target = target;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return proxy;
    }

    /**
     *
     * @param proxy 代理类对象
     * @param method 被代理对象的方法
     * @param args 被代理对象方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("海外寻找客户需要的产品");
        System.out.println("跟客户确认物品");
        method.invoke(target,args);
        System.out.println("完成本次海淘");
        return null;
    }
}
