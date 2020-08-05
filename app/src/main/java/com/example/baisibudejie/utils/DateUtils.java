package com.example.baisibudejie.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
    public static String parseDate(String createTime){
        try {
            String ret="";
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long create=sdf.parse(createTime).getTime();
            Calendar now=Calendar.getInstance();
            long ms=1000*(now.get(Calendar.HOUR_OF_DAY)*3600+now.get(Calendar.MINUTE)*60+now.get(Calendar.SECOND));
            long ms_now=now.getTimeInMillis();
            if (ms_now-create<ms){
                ret="今天"+createTime.substring(createTime.indexOf(" ")+1);
            }else if (ms_now-create<(ms+24*3600*1000)){
                ret="昨天"+createTime;
            }else if (ms_now-create<(ms+24*3600*1000)){
                ret="前天"+createTime;
            }else {
                ret="更早"+createTime;
            }
            return ret;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
