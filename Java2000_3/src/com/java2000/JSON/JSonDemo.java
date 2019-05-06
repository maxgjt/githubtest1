package com.java2000.JSON;

import com.google.gson.stream.JsonReader;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import javax.print.attribute.standard.MediaSize;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class JSonDemo {
    @Test
    public void parseJASONNames() throws IOException {

        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/java2000/JSON/names.json");
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        //JSON 的解析工具(解析器)
        JsonReader reader = new JsonReader(inputStreamReader);

        ArrayList<Name> list = new ArrayList<>();
        //开始解析数组
        reader.beginArray();
        while(reader.hasNext()){
            list.add(parseName(reader));
        }

        System.out.println(Arrays.toString(list.toArray()));
        //结束解析数组

        reader.endArray();
    }


    private Name parseName(JsonReader jsonReader) throws IOException {
        Name name = new Name();
        jsonReader.beginObject();
        while (jsonReader.hasNext()){
            String attrName = jsonReader.nextName();
            if ("firstName".equals(attrName)) {
                name.setFirstName(jsonReader.nextString());
            }else if ("lastName".equals(attrName)){
                name.setLastName(jsonReader.nextString());
            }else if ("email".equals(attrName)){
                name.setEmail(jsonReader.nextString());
            }
        }

        jsonReader.endObject();
        return name;
    }
}
