package com.simple.base.uitl;

import java.util.Calendar;
import java.util.Date;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/15 11:38
 */
public class MyDateUtils {
    /**
     * 获取当天23点
     *
     * @return
     */
    public static Date getEndTime() {
        Calendar time = Calendar.getInstance();
        time.set(Calendar.HOUR_OF_DAY, 23);
        time.set(Calendar.MINUTE, 00);
        time.set(Calendar.SECOND, 00);
        time.set(Calendar.MILLISECOND, 999);
        return time.getTime();
    }

    /**
     * 获取当天0点
     *
     * @return
     */
    public static Date getStartTime() {
        Calendar time = Calendar.getInstance();
        time.set(Calendar.HOUR_OF_DAY, 00);
        time.set(Calendar.MINUTE, 00);
        time.set(Calendar.SECOND, 00);
        time.set(Calendar.MILLISECOND, 000);
        return time.getTime();
    }
}
