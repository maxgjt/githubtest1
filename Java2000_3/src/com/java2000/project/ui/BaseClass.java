package com.java2000.project.ui;

import com.java2000.project.bean.User;
import com.java2000.project.framework.BeanFactory;

import java.util.ResourceBundle;
import java.util.Scanner;

public abstract class BaseClass {
    protected static Scanner input = new Scanner(System.in);
    protected static User currUser; //当前用户对象
    protected BeanFactory beanFactory = null;
    private static ResourceBundle r = ResourceBundle.getBundle("com.java2000.project.res.r_temp");

    protected static String getString(String key){
        return r.getString(key);
    }

    public static void print(String s){
        System.out.println(s);
    }

    public BaseClass(){
        beanFactory = BeanFactory.init();
    }
}
