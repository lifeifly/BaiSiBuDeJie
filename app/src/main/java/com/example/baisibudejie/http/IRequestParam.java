package com.example.baisibudejie.http;

import java.util.HashMap;

public interface IRequestParam<T> {
    void put(String key,Object value);
    Object get(String key);
    int size();
    T getRequestParam();
}
