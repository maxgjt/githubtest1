package com.java2000.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.baidu.com/img/bd_logo1.png");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("/Users/maxgong/Desktop/test.jpg"));
            byte[] bytes = new  byte[2014];
            int len = -1;
            while ((len=in.read(bytes))!=-1) {
                out.write(bytes,0,len);
                out.flush();
            }
            in.close();
            out.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
