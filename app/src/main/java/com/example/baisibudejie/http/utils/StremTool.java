package com.example.baisibudejie.http.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StremTool {
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        byte[] buffer=new byte[1024];
        int len=0;
        while((len=inputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }
        byte[] data=outputStream.toByteArray();//网页的二进制数据
        outputStream.close();
        inputStream.close();
        return data;
    }
}
