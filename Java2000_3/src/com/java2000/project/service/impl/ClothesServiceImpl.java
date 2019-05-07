package com.java2000.project.service.impl;

import com.java2000.project.bean.Clothes;
import com.java2000.project.service.ClothesService;
import com.java2000.project.ui.BusinessException;
import com.java2000.project.utils.ClothesIO;

import java.util.List;

public class ClothesServiceImpl implements ClothesService {
    private ClothesIO clothesIO = new ClothesIO();

    @Override
    public List<Clothes> list() throws BusinessException {

        return clothesIO.list();
    }

    @Override
    public Clothes findById(String cid) throws BusinessException {

       return  clothesIO.findByid(cid);
    }

    public  void update() throws BusinessException{
        clothesIO.update();
    }
}
