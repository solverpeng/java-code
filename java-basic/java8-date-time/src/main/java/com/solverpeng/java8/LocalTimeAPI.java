package com.solverpeng.java8;

import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeAPI {

    /**
     * 实例化时间-静态方法
     */
    @Test
    public void testStaticInstance() {
        LocalTime now = LocalTime.now();                                                        //17:19:57.279
        LocalTime localTime = LocalTime.of(12, 12);                                //12:12
        LocalTime localTime1 = LocalTime.of(12, 12, 12);                    //12:12:12
        LocalTime localTime2 = LocalTime.of(12, 12, 12, 12);   //12:12:12.000000012
        LocalTime localTime3 = LocalTime.ofSecondOfDay(100);                                    //00:01:40
        LocalTime localTime4 = LocalTime.ofNanoOfDay(1000);                                     //00:00:00.000001
        LocalTime localTime5 = LocalTime.parse("12:12:12");                                     //12:12:12
    }

    /**
     * 时间加减
     */
    @Test
    public void testLocalTimePlusMinus() {
        LocalTime localTime = LocalTime.of(12, 12);
        LocalTime localTime1 = localTime.plusHours(1);                                          //13:12
        LocalTime localTime2 = localTime.plusMinutes(1);                                        //12:13
    }

    /**
     * 时分秒
     */
    @Test
    public void testHourMinusSecond() {
        LocalTime localTime = LocalTime.of(12, 13, 14);
        int hour = localTime.getHour();                                                         //12
        int minute = localTime.getMinute();                                                     //13
        int second = localTime.getSecond();                                                     //14
    }

    /**
     * 时间覆盖
     */
    @Test
    public void testWith() {
        LocalTime localTime = LocalTime.of(12, 13, 14);
        LocalTime localTime1 = localTime.withHour(11);                                          //11:13:14
        LocalTime localTime2 = localTime.withMinute(12);                                        //12:12:14
        LocalTime localTime3 = localTime.withSecond(13);                                        //12:13:13
    }

    /**
     * 格式化
     */
    @Test
    public void testFormat() {
        LocalTime localTime = LocalTime.of(12, 13, 14);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String format = localTime.format(formatter);                                            //12:13:14
    }
}
