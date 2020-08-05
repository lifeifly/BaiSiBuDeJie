package com.example.baisibudejie.http;
//执行网络请求命令接口
public interface IHttpCommand<T> {
    public String execute(String uri,IRequestParam<T> requestParam);
}
