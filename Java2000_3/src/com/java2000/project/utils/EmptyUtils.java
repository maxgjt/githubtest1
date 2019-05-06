package com.java2000.project.utils;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import org.hamcrest.core.Is;

public class EmptyUtils {
    public static boolean isEmpty(String s){
        if (null == s || "".equals(s)){
            return true;
        }else {
            return false;
        }
    }
}
