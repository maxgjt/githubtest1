package com.java2000.project.service.impl;

import com.java2000.project.bean.User;
import com.java2000.project.service.UserService;
import com.java2000.project.ui.BusinessException;
import com.java2000.project.utils.EmptyUtils;
import com.java2000.project.utils.UserIO;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.IOException;

public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) throws BusinessException {
        UserIO userIO = new UserIO();
        userIO.add(user);
        userIO.writeUsers();
        return null;
    }

    @Override
    public User login(String username, String password) throws BusinessException {
        if (EmptyUtils.isEmpty(username)){
            throw new BusinessException("username.notnull");
        }
        if (EmptyUtils.isEmpty(password)){
            throw new BusinessException("password.notnull");
        }

        UserIO userIO = new UserIO();
        User user = userIO.findByUsernameandPassword(username, password);

        return user;
    }
}
