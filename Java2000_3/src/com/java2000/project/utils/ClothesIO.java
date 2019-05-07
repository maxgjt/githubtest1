package com.java2000.project.utils;

import com.java2000.project.bean.Clothes;
import com.java2000.project.ui.BusinessException;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

public class ClothesIO {
    private static List<Clothes> list = new ArrayList<>();
    public Clothes findByid(String cid) throws BusinessException{
        for (Clothes c:list){
            if (c.getId().equals(cid)){
                return c;
            }
        }
        return null;
    }

    public List<Clothes> list() throws BusinessException{
        if (list.size()==0){
            list = ProductsXmlUtils.parserProductFormXml();
        }
        return list;
    }

    //更新XML文件
    public void update() throws BusinessException{
        ProductsXmlUtils.writeProductToXml(list);
    }
}
