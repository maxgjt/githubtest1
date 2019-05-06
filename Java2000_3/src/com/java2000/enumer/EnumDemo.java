package com.java2000.enumer;

import org.junit.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

public class EnumDemo {
    public  Color colorEnum;

    @Test
    public void test(){
        colorEnum = Color.BLUE;
        System.out.println(colorEnum);
        System.out.println(colorEnum.name());
        System.out.println(colorEnum.ordinal());
        System.out.println(colorEnum.toString());

        Color[] colors = Color.values();
        System.out.println(Arrays.toString(colors));
    }

    @Test
    public void test2(){
        EnumSet<Color> set = EnumSet.allOf(Color.class);
        for (Color c:set) {
            System.out.println(c);
        }

        EnumMap<Color,String> map = new EnumMap<Color, String>(Color.class);
        map.put(Color.RED,"red");
        map.put(Color.RED,"green");
        map.put(Color.RED,"blue");
    }

}
