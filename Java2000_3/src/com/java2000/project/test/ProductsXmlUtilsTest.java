package com.java2000.project.test;

import com.java2000.project.bean.Clothes;
import com.java2000.project.utils.ProductsXmlUtils;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ProductsXmlUtilsTest {
    @Test
    public void test() throws DocumentException {
        List<Clothes> clothes = ProductsXmlUtils.parserProductFormXml();
        System.out.println(Arrays.toString(clothes.toArray()));
    }
}
