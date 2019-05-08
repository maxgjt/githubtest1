package com.java2000.project.ui;

import com.java2000.project.bean.User;
import com.java2000.project.service.UserService;
import com.java2000.project.service.impl.UserServiceImpl;

public class LoginClass extends BaseClass {
    private UserService userService;
    public LoginClass(){
        userService = (UserService) beanFactory.getBean("userService");
    }

    public void login() throws BusinessException {
        print(getString("input.username"));
        String username = input.nextLine();
        print(getString("input.password"));
        String password = input.nextLine();
//        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);
        System.out.println(user);
        if (user!=null){
            currUser = user;
        }else {
            throw new BusinessException("login.error");
        }
    }

}
