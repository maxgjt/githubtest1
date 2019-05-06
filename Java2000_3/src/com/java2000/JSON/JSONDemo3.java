package com.java2000.JSON;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONDemo3 {
    @Test
    public void createJSON(){
        ArrayList<Name> list = new ArrayList<>();
        list.add(new Name("vince","ma","11834774@qq.com"));
        list.add(new Name("jack","xu","1774@qq.com"));

        JsonArray array = new JsonArray();
        for(Name n:list){
            JsonObject obj = new JsonObject();
            obj.addProperty("fisrtName",n.getFirstName());
            obj.addProperty("lastName",n.getLastName());
            obj.addProperty("email",n.getEmail());
            array.add(obj);
        }
        System.out.println(array.toString());
    }
    //把一个JSON对象转换成JAVA 对象，或者把一个JAVA 对象转换成一个JSON对象
    @Test
    public void gson11(){
        Gson gson = new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/java2000/JSON/name.json");
        InputStreamReader in = new InputStreamReader(is);
        Name name = gson.fromJson(in, Name.class);
        System.out.println(name);
        String json = gson.toJson(name);
        System.out.println(json);
    }

    // 把一组JSON对象转化成一个JAVA 对象集合，或者把一个JAVA 对象集合转换成JSON 数组;
    @Test
    public void gson2(){
        Gson gson = new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/java2000/JSON/name.json");
        InputStreamReader in = new InputStreamReader(is);
        TypeToken<List<Name>> type = new TypeToken<List<Name>>(){};
        gson.fromJson(in, (Type) type);

//        List<Name> list= gson.fromJson(in,TypeToken.get());
    }
}
