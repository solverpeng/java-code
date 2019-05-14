package com.solverpeng.java8;

import java.time.*;
import java.util.Date;

public class DateAPI {
    public static void main(String[] args) {
        Date date = new Date();                 //Tue May 14 16:13:44 CST 2019
        Date date2 = new Date(1557821720111L);  //Tue May 14 16:15:20 CST 2019
        long time = date.getTime();             //1557821720609

        boolean before = date.before(date2);    //false
        boolean after = date.after(date2);      //true

        int result = date.compareTo(date2);     //1 date > date2

        //LocalDateTime->Date
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date3 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        //LocalDate->Date
        LocalDate localDate = LocalDate.now();
        Date date4 = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        // LocalDateTime->Date
        Instant instant = LocalDateTime.of(LocalDate.now(), LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant();
        java.util.Date date5 = Date.from(instant);

        //Date->LocalDateTime
        Instant instant1 = date.toInstant();
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());

        //Date->LocalDate
        Instant instant2 = date.toInstant();
        LocalDate localDate2 = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault()).toLocalDate();
    }
}
