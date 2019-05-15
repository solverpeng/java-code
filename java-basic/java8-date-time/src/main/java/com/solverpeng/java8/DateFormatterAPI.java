package com.solverpeng.java8;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateFormatterAPI {
    @Test
    public void testCreate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE);//2019-05-15
        String format1 = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);//2019-05-15T19:36:02.672
        String format2 = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);//19:36:47.195
    }

    @Test
    public void name() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // LocalDateTime/LocalDate->String
        String format = formatter.format(LocalDateTime.now());  //2019-05-15 19:42:43
        String format1 = formatter2.format(LocalDate.now());    //2019-05-15

        // String->LocalDateTime/LocalDate
        LocalDateTime from = LocalDateTime.from(formatter.parse("2019-10-23 12:12:12"));//2019-10-23T12:12:12
        LocalDate from1 = LocalDate.from(formatter2.parse("2019-10-22"));//2019-10-22
    }
}
