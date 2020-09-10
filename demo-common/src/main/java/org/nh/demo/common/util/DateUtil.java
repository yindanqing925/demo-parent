package org.nh.demo.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yindanqing
 * @date 2019/6/13 22:59
 * @description 单例-双重校验锁
 */
public class DateUtil {

    private static final String DEFAULT = "yyyy-MM-dd HH:mm:ss";

    private static DateUtil dateUtil = null;

    public static DateUtil getInstance(){
        if(dateUtil == null){
            synchronized (DateUtil.class){
                if (dateUtil == null){
                    dateUtil = new DateUtil();
                }
            }
        }
        return dateUtil;
    }

    public static String format(Date date){
        return format(date, DEFAULT);
    }

    public static String format(Date date, String formatter){
        return new SimpleDateFormat(formatter).format(date);
    }

}
