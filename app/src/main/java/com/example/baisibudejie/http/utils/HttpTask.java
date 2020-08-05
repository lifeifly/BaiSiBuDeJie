package com.example.baisibudejie.http.utils;

import android.os.AsyncTask;

import com.example.baisibudejie.http.IHttpCommand;
import com.example.baisibudejie.http.IRequestParam;

//异步任务执行网络请求--公共类
public class HttpTask extends AsyncTask<String, Void, String> {
    private String url;
    private IRequestParam requestParam;
    private HttpUtils.OnHttpResultListener listener;
    private IHttpCommand httpCommand;

    public HttpTask(String url, IRequestParam requestParam, HttpUtils.OnHttpResultListener listener, IHttpCommand httpCommand) {
        this.url = url;
        this.requestParam = requestParam;
        this.listener = listener;
        this.httpCommand = httpCommand;
    }


    @Override
    protected String doInBackground(String... strings) {
        try {
            return httpCommand.execute(url, requestParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        if (this.listener != null) {
            this.listener.onResult(s);
        }
    }
}
