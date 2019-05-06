package com.java2000.JSON;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JSONDemo2 {
    /**
     * 使用JSON 解析复杂JSON数据
     */
    @Test
    public void parseJSONMessage() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/java2000/JSON/message.json");
        InputStreamReader in = new InputStreamReader(is);
        JsonReader jsonReader = new JsonReader(in);

        ArrayList<Message> list = readMessage(jsonReader);
        for (Message m : list) {
            System.out.println(m);
        }
    }

    //读取Message 数组
    private ArrayList<Message> readMessage(JsonReader jsonReader) throws IOException {
        ArrayList<Message> list = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            list.add(read(jsonReader));
        }
        jsonReader.endArray();
        return list;
    }

    private Message read(JsonReader jsonReader) throws IOException {
        Message message = new Message();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String name = jsonReader.nextName();
            if ("id".equals(name)) {
                message.setId(jsonReader.nextLong());
            } else if ("text".equals(name)) {
                message.setText(jsonReader.nextString());
            } else if ("geo".equals(name) && jsonReader.peek() != JsonToken.NULL) {
                message.setGeo(readGeo(jsonReader));
            } else if ("user".equals(name)) {
                message.setUser(readUser(jsonReader));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return message;
    }

    private User readUser(JsonReader jsonReader) throws IOException {
        User user = new User();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String name = jsonReader.nextName();
            if ("name".equals(name)) {
                user.setName(jsonReader.nextString());
            } else if ("followers_count".equals(name)) {
                user.setFollowers_count(jsonReader.nextInt());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();

        return user;
    }

    private ArrayList<Double> readGeo(JsonReader jsonReader) throws IOException {
        ArrayList<Double> list = new ArrayList<>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            list.add(jsonReader.nextDouble());
        }

        jsonReader.endArray();

        return list;
    }

}
