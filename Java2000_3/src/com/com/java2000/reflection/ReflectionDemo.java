package com.com.java2000.reflection;

import org.junit.Test;

import java.lang.reflect.*;

public class ReflectionDemo {

    @Test
    public void test1() throws ClassNotFoundException {
        //通过对象的getClass() 方法
        Dog dog = new Dog("wangwang",4,"白色");
        Class aClass = dog.getClass();
        System.out.println(aClass);


        // 通过类.class
        Class dogClass = Dog.class;

        //通过class.forName方法
        Class aClass1 = Class.forName("com.com.java2000.reflection.Dog");
    }

    @Test
    public void test2(){
        Class<Dog> dogClass = Dog.class;
        try {
            //通过Class 对象实例化类对象，调用了默认的无参构造方法;
            Dog dog = dogClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //获取构造方法
    @Test
    public void test3(){
        Class<Dog> dogClass = Dog.class;
        Constructor<?>[] constructors = dogClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName());
            System.out.println(constructors[i].getParameterCount());
        }
        try {
            //获取一个指定的构造方法
            Constructor<Dog> constructor = dogClass.getConstructor(String.class, int.class, String.class);
            //调用带参数的构造方法实例化对象;
            Dog dog = constructor.newInstance("小白", 5, "白色");
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //获取所有属性
    @Test
    public void test4(){
        //获取非私有属性
        Class<Dog> dogClass = Dog.class;
        Field[] fields = dogClass.getFields();
        System.out.println(fields.length);
        //获取所有属性(包括私有属性)
        Field[] declaredFields = dogClass.getDeclaredFields();
        System.out.println(declaredFields.length);

        for (int i = 0; i < declaredFields.length; i++) {
            int modifiers = declaredFields[i].getModifiers();
            System.out.println(Modifier.toString(modifiers)+" "+declaredFields[i].getType()+declaredFields[i].getName());
        }
    }

    @Test
    public void test5() throws InvocationTargetException, IllegalAccessException {
        Class<Dog> dogClass = Dog.class;
        Dog dog = new Dog("wangwang",5,"白色");
        // 获取类的包名字
        Package aPackage = dogClass.getPackage();
        System.out.println(aPackage.getName());
        //获取到公共的方法，包括继承的公有方法;
        Method[] methods = dogClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
            if(methods[i].getName().equals("toString")){
                String s = (String) methods[i].invoke(dog);
            }
        }
        System.out.println("--------------------");
        // 访问私有方法,获取到本类中定义的所有方法（不包括父类）
        Method[] declaredMethods = dogClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            System.out.println(declaredMethods[i]);
        }
    }
}
