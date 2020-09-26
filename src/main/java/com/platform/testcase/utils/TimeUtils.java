package com.platform.testcase.utils;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeUtils {
    public static String TimeStrampToString(Timestamp stramp){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String time = format.format(stramp);
        return time;
    }

}
