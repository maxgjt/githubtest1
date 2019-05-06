package com.java2000.project.utils;

import com.java2000.project.bean.User;
import com.java2000.project.ui.BusinessException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserIO{
    private static List<User> users = new ArrayList<>();
    private static final String USER_FILE = "user.txt";
    public boolean writeUsers() throws BusinessException {
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USER_FILE));
            out.writeObject(users);
            out.close();
        }catch (IOException e){
            e.printStackTrace();
            throw new BusinessException("io.write.error");
        }

        return true;
    }

    public boolean readUsers(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(USER_FILE));
            users = (List<User>) in.readObject();
            System.out.println(Arrays.toString(users.toArray()));
            in.close();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            new BusinessException("io.read.error");
        }
        return true;
    }

    public void add(User user){
        user.setId(users.size()+1);
        users.add(user);
//        System.out.println(Arrays.toString(users.toArray()));
    }

    public User findByUsernameandPassword(String username,String password){
        for (User u:users){
            if (u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }
}
