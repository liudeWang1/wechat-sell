package com.wang.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by 汪刘德 on 2018/3/17.
 */
public class JsonUtil {

    public static String toJson(Object object){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson=gsonBuilder.create();
        return gson.toJson(object);
    }
}
