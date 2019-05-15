package com.solverpeng.java8;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DurationAPI {

    @Test
    public void testCreate() {
        LocalDateTime from = LocalDateTime.of(2017, Month.JANUARY, 5, 10, 7, 0);    // 2017-01-05 10:07:00
        LocalDateTime to = LocalDateTime.of(2017, Month.FEBRUARY, 5, 10, 7, 0);     // 2017-02-05 10:07:00
        Duration duration = Duration.between(from, to);         //表示从 2017-01-05 10:07:00 到 2017-02-05 10:07:00 这段时间

        Duration of = Duration.of(5, ChronoUnit.DAYS);  //表示5天
        Duration duration1 = Duration.ofDays(10);               //表示10天
        Duration duration2 = Duration.ofHours(10);              //表示10个小时
        Duration duration3 = Duration.ofSeconds(100);           //表示100秒
    }


    @Test
    public void testGet() {
        Duration duration = Duration.ofDays(10);               //表示10天
        long days = duration.toDays();              // 这段时间的总天数
        long hours = duration.toHours();            // 这段时间的小时数
        long minutes = duration.toMinutes();        // 这段时间的分钟数
        long seconds = duration.getSeconds();       // 这段时间的秒数
        long milliSeconds = duration.toMillis();    // 这段时间的毫秒数
        long nanoSeconds = duration.toNanos();      // 这段时间的纳秒数
    }

    @Test
    public void testPlus() {
        Duration duration = Duration.ofDays(10);               //表示10天
        Duration plus = duration.plus(5, ChronoUnit.DAYS);  //表示15天
    }
}
