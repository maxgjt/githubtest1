package com.com.java2000.aop;

import org.junit.Test;

import javax.naming.Name;
import java.io.InputStream;

public class AOPTest {
    @Test
    public void test(){
        //读取配置文件
         InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/com.java2000/aop/bean.properties");
        //创建bean 的工厂对象
        BeanFactory beanFactory = new BeanFactory(in);
        //获取代理对象
//        IManager bean = beanFactory.getBean(Name);
    }
}
