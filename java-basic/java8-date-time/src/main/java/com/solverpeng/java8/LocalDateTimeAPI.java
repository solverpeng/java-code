package com.solverpeng.java8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class LocalDateTimeAPI {

    /**
     * 实例化-静态方法
     */
    @Test
    public void testStaticInstance() {
        LocalDateTime now = LocalDateTime.now();            //2019-05-15T09:32:16.095
        LocalDateTime localDateTime = LocalDateTime.of(2018, 12, 12, 15, 23, 23);//2018-12-12T15:23:23
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());//2019-05-15T09:32:16.096
        LocalDateTime localDateTime2 = LocalDateTime.parse("2019-12-12T10:12:12");//2019-12-12T10:12:12
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime3 = LocalDateTime.parse("2017-01-05 12:30:05", formatter);//2017-01-05T12:30:05
    }

    /**
     * 转换为日期和时间，获取年月日时分秒
     */
    @Test
    public void testConvert() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 12, 23, 10, 12, 22);
        LocalDate localDate = localDateTime.toLocalDate();      //2018-12-23
        LocalTime localTime = localDateTime.toLocalTime();      //10:12:22
        int year = localDateTime.getYear();                     //2018
        Month month = localDateTime.getMonth();                 //DECEMBER
        int monthValue = localDateTime.getMonthValue();         //12
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();     //SUNDAY
        int dayOfMonth = localDateTime.getDayOfMonth();         //23
        int dayOfYear = localDateTime.getDayOfYear();           //357
        int hour = localDateTime.getHour();                     //10
        int minute = localDateTime.getMinute();                 //12
        int second = localDateTime.getSecond();                 //22
        int nano = localDateTime.getNano();                     //0
        long aLong = localDateTime.getLong(ChronoField.YEAR);   //2018
    }

    /**
     * 日期时间加减
     */
    @Test
    public void testPlus() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 12, 23, 10, 12, 22);
        LocalDateTime localDateTime1 = localDateTime.plusYears(1);  //2019-12-23T10:12:22
        LocalDateTime localDateTime2 = localDateTime.minusYears(1); //2017-12-23T10:12:22
    }

    /**
     * 拷贝覆盖
     */
    @Test
    public void testWith() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 12, 23, 10, 12, 22);
        LocalDateTime localDateTime1 = localDateTime.withYear(2019);    //2019-12-23T10:12:22
        LocalDateTime localDateTime2 = localDateTime.withMonth(10);     //2018-10-23T10:12:22
    }

    /**
     * 日期时间比较
     */
    @Test
    public void testCompare() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 12, 23, 10, 12, 22);
        LocalDateTime localDateTime2 = LocalDateTime.of(2019, 12, 23, 10, 12, 22);
        int compare = localDateTime.compareTo(localDateTime2);  //-1

        boolean after = localDateTime.isAfter(localDateTime2);      //false
        boolean before = localDateTime.isBefore(localDateTime2);    //true
    }

    /**
     * 相差
     */
    @Test
    public void testUtil() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 12, 23, 10, 12, 22);
        LocalDateTime localDateTime2 = LocalDateTime.of(2019, 12, 23, 10, 12, 22);
        long until = localDateTime.until(localDateTime2, ChronoUnit.MONTHS);    //12
    }

    /**
     * 格式化
     */
    @Test
    public void testFormatter() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 12, 23, 10, 12, 22);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = localDateTime.format(formatter);    //2018-12-23 10:12:22
    }

}
