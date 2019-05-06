package com.java2000.regex;

import org.junit.Test;

import javax.crypto.Mac;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    @Test
    public void test1(){
        Pattern pattern = Pattern.compile("[0-9]{7}");
        Matcher matcher = pattern.matcher("5201314");
        boolean b = matcher.matches();
        System.out.println(b);
    }

    @Test
    public void test2(){
        //创建一个匹配模式
        Pattern pattern =Pattern.compile("a*b");
        Matcher matcher = pattern.matcher("aaaaab");
        boolean b = matcher.matches();//匹配
        System.out.println(b);
    }

    @Test
    public void test3(){
        //匹配电话号码
        String phoneNubmber = "010-38389438";
        boolean b = phoneNubmber.matches("\\d{3,4}-\\d{7,8}");
        System.out.println("电话号码匹配结果是： "+b);

        // 匹配手机号码
        String phone = "13895271234";
        boolean b1 = phone.matches("[1][3-9]\\d{9}");
        System.out.println("手机号码匹配结果是： "+b1);

        //匹配用户名:字母开头，数字字母下划线组合
        String username = "abc1314";
        boolean b2 = username.matches("[a-zA-Z]+[\\w|_]*"); //\w 表示的是字符包括字母数字也包括下划线;
        System.out.println("手机号码匹配结果是： "+b2);

        //匹配ip 地址
        String ip = "20.10.20.123";
        boolean b3 = ip.matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}");
        System.out.println("ip地址匹配结果是： "+b3);

        //匹配网址
        String addr = "http://www.baidu.com";
        boolean b4 = addr.matches("http://\\w.\\w+.\\S*");  // /S 表示非空白字符
        System.out.println("网址匹配结果是： "+b4);
    }
}
