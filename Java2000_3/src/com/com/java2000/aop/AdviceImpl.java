package com.com.java2000.aop;

public class AdviceImpl implements Advice {

    //切面的实现类

    @Override
    public void beforeAdvice() {
        System.out.println("Start tie: "+ System.currentTimeMillis());
    }

    @Override
    public void afterAdvice() {
        System.out.println("end time: "+ System.currentTimeMillis());
    }
}
