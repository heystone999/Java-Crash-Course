package com.stone.module5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestDateTime {
    public static void main(String[] args) {
        LocalDateTime dt1=LocalDateTime.of(2022,7,4,10,30,22);
        LocalTime t1=LocalTime.of(10,30,22);
        System.out.println(dt1.plusDays(28));
        System.out.println(dt1.minusDays(4));

        System.out.println(LocalDateTime.now());
        System.out.println(LocalTime.now());

        String dateTime="2022-06-30T10:30:22";
        String time="10:30:22";

        LocalDateTime dt2=LocalDateTime.parse(dateTime);
        System.out.println(dt2.getYear());
        System.out.println(dt2.getMonth());
        System.out.println(dt2.getMonthValue());
        System.out.println(dt2.getDayOfMonth());
        System.out.println(dt2.getHour());
        System.out.println(dt2.getMinute());
        System.out.println(dt2.getSecond());

        LocalTime t2=LocalTime.parse(time);
        System.out.println(t2.getHour());
        System.out.println(t2.getMinute());
        System.out.println(t2.getSecond());
    }
}
