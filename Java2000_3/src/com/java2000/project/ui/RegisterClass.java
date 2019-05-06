package com.java2000.project.ui;

import com.java2000.project.bean.User;
import com.java2000.project.service.UserService;
import com.java2000.project.service.impl.UserServiceImpl;

public class RegisterClass extends BaseClass {
    public void register() throws BusinessException{
        print(getString("input.username"));
        String username = input.nextLine();
        print(getString("input.password"));
        String password = input.nextLine();
        User user = new User(username,password);
//        System.out.println(user);
        UserService userService = new UserServiceImpl();
        userService.register(user);
    }
}
