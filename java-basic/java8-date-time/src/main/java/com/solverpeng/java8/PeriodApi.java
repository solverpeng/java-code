package com.solverpeng.java8;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodApi {

    @Test
    public void testCreate() {
        LocalDate from = LocalDate.now();
        LocalDate to = LocalDate.of(2019, 10, 10);
        Period between = Period.between(from, to);
        Period period = Period.of(2019, 12, 12);
        Period period1 = Period.ofYears(2019);
        Period period2 = Period.ofMonths(10);
        Period period3 = Period.ofWeeks(10);
        Period period4 = Period.ofDays(10);
    }

    @Test
    public void testGet() {
        Period period = Period.of(2019, 12, 12);
        int years = period.getYears();      //2019
        int months = period.getMonths();    //12
        int days = period.getDays();        //12
        long l = period.get(ChronoUnit.DAYS);//12
    }

    @Test
    public void testPlus() {
        Period period = Period.of(10, 12, 13);
        int years = period.plusYears(1).getYears();     //1
        int months = period.plusMonths(1).getMonths();  //13
        int days = period.plusDays(10).getDays();       //23
    }
}
