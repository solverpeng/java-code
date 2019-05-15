package com.solverpeng.java8;

import org.junit.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class InstantAPI {

    /**
     * 实例化方法
     */
    @Test
    public void testStatic() {
        Instant now = Instant.now();                                //2019-05-15T06:13:09.114Z
        Instant parse = Instant.parse("2019-05-15T06:13:09.114Z"); //2019-05-15T06:13:09.114Z
        Instant instant = Instant.ofEpochSecond(120, 100000);//1970-01-01T00:02:00.000100Z
    }

    /**
     * 加减
     */
    @Test
    public void testPlus() {
        Instant instant = Instant.ofEpochSecond(100000000L);//1973-03-03T09:46:40Z
        Instant instant1 = instant.plusSeconds(10000L);     //1973-03-03T12:33:20Z
        Instant plus = instant.plus(10000L, ChronoUnit.SECONDS);//1973-03-03T12:33:20Z
    }

    /**
     * 获取秒毫秒
     */
    @Test
    public void testGet() {
        Instant instant = Instant.ofEpochSecond(100000000L);
        long epochSecond = instant.getEpochSecond();
        int nano = instant.getNano();
    }

    /**
     * 获取秒毫秒
     */
    @Test
    public void testCompare() {
        Instant instant = Instant.ofEpochSecond(100000000L); //1973-03-03T09:46:40Z
        Instant instant2 = Instant.ofEpochSecond(200000000L);//1976-05-03T19:33:20Z
        boolean after = instant.isAfter(instant2);           //false
        boolean before = instant.isBefore(instant2);         //true
        int i = instant.compareTo(instant2);                 //-1
    }

}
