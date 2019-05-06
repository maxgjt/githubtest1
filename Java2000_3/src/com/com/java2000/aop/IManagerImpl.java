package com.com.java2000.aop;

import java.util.ArrayList;

public class IManagerImpl implements IManager{
    private ArrayList<String> list = new ArrayList<>();

    @Override
    public void add(String item) {
        list.add(item);
    }
}
