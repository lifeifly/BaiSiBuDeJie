package com.example.baisibudejie.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GsonUtils<T> {
    /**
     * 两种方案
     * 1.方法泛型
     * 2.类泛型
     */
    //方法泛型使用补充
    public ArrayList<T> parseArray(String result,Class<?> className){
        ArrayList<T> list=new ArrayList<>();
        return null;
    }
    public static <T> List<T> getList(String result,Class<T> tClass){
        List<T> list=new ArrayList<>();
        Gson gson=new Gson();
        JsonParser jsonParser=new JsonParser();
        JsonElement el=jsonParser.parse(result);
        Iterator it=el.getAsJsonArray().iterator();
        while (it.hasNext()){
            JsonElement e=(JsonElement)it.next();
            T model=gson.fromJson(e,tClass);
            list.add(model);
        }
        return list;
    }
}
