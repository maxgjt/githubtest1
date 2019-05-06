package com.java2000.project;

import com.java2000.project.ui.WelcomeClass;
import com.java2000.project.utils.UserIO;

/**
 * 程序的入口类
 */
public class MainClass {
    public static void main(String[] args) {
        UserIO userIO = new UserIO();
        userIO.readUsers();
        new WelcomeClass().start();
    }
}
