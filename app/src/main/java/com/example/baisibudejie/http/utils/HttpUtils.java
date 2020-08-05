package com.example.baisibudejie.http.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpUtils {
    public static final String URL_STR = "http://192.168.57.1:8080/Dream_4_23_PhoneGapServer/PhoneGapServlet";

    public static String get(String urlStr) {
        String result = null;
        try {
            URL url = new URL(urlStr);
            //打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                result = new String(StremTool.readInputStream(inputStream));
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String post(String urlStr, String username, String password) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        return post(urlStr, paramMap);
    }

    public static String post(String urlStr, Map<String, Object> paramMap) {
        StringBuilder sb = null;
        //拼接参数
        StringBuilder params = new StringBuilder();
        int i = 0;
        for (String key : paramMap.keySet()) {
            Object value = paramMap.get(key);
            params.append(key);
            params.append("=");
            params.append(value);
            if (i < paramMap.size() - 1) {
                params.append("&");
            }
            i++;
        }
        try {
            //创建请求地址
            URL url = new URL(urlStr);
            //打开链接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置参数
            connection.setDoInput(true);//需要输入
            connection.setDoOutput(true);//需要输出
            connection.setUseCaches(false);//不允许缓存
            connection.setRequestMethod("POST");//设置POST方式连接
            //设置请求属性
            connection.setRequestProperty("Charset", "UTF-8");
            //连接，也可以不用明文connect，使用下面的httpConn。个体Output Stream（）会自动连接
            connection.connect();
            //建立输入流，向指向的URL传入参数
            DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
            dos.writeBytes(params.toString());
            dos.flush();
            dos.close();
            //获得响应状态
            int resultCode = connection.getResponseCode();
            sb = new StringBuilder();
            if (HttpURLConnection.HTTP_OK == resultCode) {
                //解析服务器返回的数据
                String readLine = new String();
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    sb.append(readLine).append("\n");
                }
                responseReader.close();
                return sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface OnHttpResultListener {
        public void onResult(String result);
    }
}
