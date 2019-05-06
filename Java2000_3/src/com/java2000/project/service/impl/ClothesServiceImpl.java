package com.java2000.project.service.impl;

import com.java2000.project.bean.Clothes;
import com.java2000.project.service.ClothesService;
import com.java2000.project.ui.BusinessException;
import com.java2000.project.utils.ProductsXmlUtils;

import java.util.List;

public class ClothesServiceImpl implements ClothesService {
    @Override
    public List<Clothes> list() throws BusinessException {
        List<Clothes> clothes = ProductsXmlUtils.parserProductFormXml();
        return clothes;
    }
}
