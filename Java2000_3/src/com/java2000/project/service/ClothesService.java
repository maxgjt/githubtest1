package com.java2000.project.service;

import com.java2000.project.bean.Clothes;
import com.java2000.project.ui.BusinessException;

import java.util.List;

public interface ClothesService {
    public List<Clothes> list() throws BusinessException;
    public Clothes findById(String cid) throws BusinessException;
    public void update() throws BusinessException;
}
