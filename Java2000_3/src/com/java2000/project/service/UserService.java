package com.java2000.project.service;

import com.java2000.project.bean.User;
import com.java2000.project.ui.BusinessException;

public interface UserService {
    public User register(User user) throws BusinessException;

    public User login(String username,String password) throws BusinessException;
}
