package com.java2000.project.utils;

import com.java2000.XML.Person;
import com.java2000.project.bean.Clothes;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsXmlUtils {
    public static List<Clothes> parserProductFormXml(){
        List<Clothes> products = new ArrayList<>();
        XStream xStream = new XStream(new Xpp3DomDriver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");
        try {
            BufferedInputStream input = new BufferedInputStream(new FileInputStream("product.xml"));
            products = (List<Clothes>) xStream.fromXML(input);
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void writeProductToXml(List<Clothes> products){
        XStream xStream = new XStream(new Xpp3DomDriver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");

        try {
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("product.xml"));
            output.write("<?xml vesion=\"1.0\" encoding=\"utf-8\"?>".getBytes());
            xStream.toXML(products,output);
            output.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
