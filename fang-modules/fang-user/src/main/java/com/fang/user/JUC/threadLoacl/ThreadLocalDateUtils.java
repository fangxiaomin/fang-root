package com.fang.user.JUC.threadLoacl;

import java.rmi.Remote;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author:fxm
 * @createTime:2022/1/4 17:15
 */
public class ThreadLocalDateUtils {
    //  c错误的写法
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Date parse(String stringDate) throws ParseException {
        return sdf.parse(stringDate);
    }
    //z正确的写法
    public static final ThreadLocal<SimpleDateFormat> sdfThreadLocal = ThreadLocal.withInitial(() ->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") );
    public static final Date parseThreadLocal(String stringDate) throws ParseException {
        return sdfThreadLocal.get().parse(stringDate);
    }


    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static String format(LocalDateTime localDateTime){
        return DATE_TIME_FORMATTER.format(localDateTime);
    }

    public static LocalDateTime parse1(String stringDate){
        return LocalDateTime.parse(stringDate,DATE_TIME_FORMATTER);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() ->{
                try {
//                    System.out.println(ThreadLocalDateUtils.parse("2021-11-11 11:11:11"));
//                    System.out.println(ThreadLocalDateUtils.parseThreadLocal("2021-11-11 11:11:11"));
                    System.out.println(ThreadLocalDateUtils.parse1("2021-11-11 11:11:11"));
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    ThreadLocalDateUtils.sdfThreadLocal.remove();
                }
            }).start();

        }
    }
}
