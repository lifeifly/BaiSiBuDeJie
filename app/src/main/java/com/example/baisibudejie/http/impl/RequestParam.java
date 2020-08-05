package com.example.baisibudejie.http.impl;

import com.example.baisibudejie.http.IRequestParam;

import java.util.HashMap;
//请求参数封装
public class RequestParam implements IRequestParam {
    private HashMap<String,Object> paramMap=new HashMap<>();

    @Override
    public void put(String key, Object value) {
        paramMap.put(key,value);
    }

    @Override
    public Object get(String key) {
        return paramMap.get(key);
    }

    @Override
    public int size() {
        return paramMap.size();
    }

    @Override
    public HashMap<String, Object> getRequestParam() {
        return paramMap;
    }
}
