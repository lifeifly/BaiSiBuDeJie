package com.example.baisibudejie.http.impl;

import com.example.baisibudejie.http.IHttpCommand;
import com.example.baisibudejie.http.IRequestParam;
import com.example.baisibudejie.http.utils.HttpUtils;

import java.util.HashMap;
//
public class HttpCommand implements IHttpCommand<HashMap<String,Object>> {

    @Override
    public String execute(String url, IRequestParam<HashMap<String,Object>> requestParam) {
        try {
            return HttpUtils.post(url,requestParam.getRequestParam());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
