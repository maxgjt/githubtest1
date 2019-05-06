package com.com.java2000.aop;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class BeanFactory {
    Properties prop = new Properties();
    public BeanFactory(InputStream in){
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getBean(String name){
        String className = prop.getProperty(name);
        Object bean = null;
        try {
            //获取ClassName ProxyFactoryBean 的 class 对象
            Class<?> aClass = Class.forName(className);
            bean = aClass.newInstance(); //实例化对象
            //根据配置文件实例化target 和advice 对象
            Object target= Class.forName(prop.getProperty(name + ".target")).newInstance();
            Object advice= Class.forName(prop.getProperty(name + ".advice")).newInstance();
            //通过内省实现对 ProxyFactoryBean 的属性赋值;
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor pd:propertyDescriptors) {
                String  propertyName = pd.getName();
                Method writeMethod = pd.getWriteMethod();
                if ("target".equals(propertyName)){
                    writeMethod.invoke(bean,target);
                }else if ("advice".equals(propertyName)){
                    writeMethod.invoke(bean,advice);
                }
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
