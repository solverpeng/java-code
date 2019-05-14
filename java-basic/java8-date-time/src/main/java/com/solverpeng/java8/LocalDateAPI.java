package com.solverpeng.java8;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateAPI {

    /**
     * 实例化日期-静态方法
     */
    @Test
    public void testStaticInstance() {
        LocalDate now = LocalDate.now();//2019-05-14
        LocalDate of = LocalDate.of(2019, 12, 30);       //2019-12-30
        LocalDate parse = LocalDate.parse("2019-10-23");                        //2019-10-23
        LocalDate localDate = LocalDate.ofYearDay(2019, 222);    //2019-08-10
        LocalDate ofEpochDay = LocalDate.ofEpochDay(10000);                     //1997-05-19
    }

    /**
     * 日期加减
     */
    @Test
    public void testLocalDatePlusMinus() {
        LocalDate localDate = LocalDate.of(2019, 10, 10);
        LocalDate localDate1 = localDate.plusDays(100); //2020-01-18
        LocalDate localDate2 = localDate.minusDays(1);  //2019-10-09
    }

    /**
     * 年月日周星期
     */
    @Test
    public void testYearMonthDay() {
        LocalDate localDate = LocalDate.of(2019, 10, 10);
        int year = localDate.get(ChronoField.YEAR);     //2019
        int year1 = localDate.getYear();                //2019
        int monthValue = localDate.getMonthValue();     //10
        Month month = localDate.getMonth();             //OCTOBER
        int dayOfMonth = localDate.getDayOfMonth();     //10
        int dayOfYear = localDate.getDayOfYear();       //283
        DayOfWeek dayOfWeek = localDate.getDayOfWeek(); //THURSDAY
        boolean leapYear = localDate.isLeapYear();      //false
        int lengthOfMonth = localDate.lengthOfMonth();  //31
        int lengthOfYear = localDate.lengthOfYear();    //365
    }

    /**
     * 年月日拷贝覆盖
     */
    @Test
    public void testWith() {
        LocalDate localDate = LocalDate.of(2019, 10, 10);
        LocalDate localDate1 = localDate.withYear(2018);        //2018-10-10
        LocalDate localDate2 = localDate.withMonth(12);         //2019-12-10
        LocalDate localDate3 = localDate.withDayOfMonth(23);    //2019-10-23
        LocalDate localDate4 = localDate.withDayOfYear(200);    //2019-07-19

        LocalDate with  = localDate.with(TemporalAdjusters.firstDayOfMonth());                  //2019-10-01
        LocalDate with2 = localDate.with(TemporalAdjusters.lastDayOfMonth());                   //2019-10-31
        LocalDate with3 = localDate.with(TemporalAdjusters.firstDayOfNextMonth());              //2019-11-01
        LocalDate with4 = localDate.with(TemporalAdjusters.firstDayOfYear());                   //2019-01-01
        LocalDate with5 = localDate.with(TemporalAdjusters.lastDayOfYear());                    //2019-12-31
        LocalDate with6 = localDate.with(TemporalAdjusters.firstDayOfNextYear());               //2020-01-01
        LocalDate with7 = localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY));     //2019-10-04
        LocalDate with8 = localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));      //2019-10-25
        LocalDate with9 = localDate.with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.FRIDAY));  //2019-10-04
        LocalDate with10 = localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));            //2019-10-11
        LocalDate with11 = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));      //2019-10-11
        LocalDate with12 = localDate.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));        //2019-10-04
        LocalDate with13 = localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));  //2019-10-04
    }

    /**
     * 格式化
     */
    @Test
    public void testFormat() {
        LocalDate localDate = LocalDate.of(2019, 10, 10);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String format = localDate.format(dateTimeFormatter);                                    //2019/10/10
    }

    /**
     * 日期比较
     */
    @Test
    public void testCompareTo() {
        LocalDate localDate = LocalDate.of(2019, 10, 10);
        LocalDate localDate2 = LocalDate.of(2019, 11, 11);
        int compare = localDate.compareTo(localDate2);                                          //-1
    }

    /**
     * 相差
     */
    @Test
    public void testUntil() {
        LocalDate localDate = LocalDate.of(2019, 10, 10);
        LocalDate localDate2 = LocalDate.of(2019, 11, 11);
        long until = localDate.until(localDate2, ChronoUnit.MONTHS);                            //1
    }
    /**
     * 1970-01-01
     */
    @Test
    public void testEpochDay() {
        LocalDate localDate = LocalDate.of(2019, 10, 10);
        long toEpochDay = localDate.toEpochDay();                                               //18179
    }

}
