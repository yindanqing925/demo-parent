package org.nh.xyy.demo.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateDemo
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/10 18:27
 */
public class LocalDateDemo {

    public static void main(String[] args) {
        new LocalDateDemo().testLocalDate();
    }

    private void testLocalDate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);

        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);

        Month month = localDateTime.getMonth();
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        int dayOfMonth = localDateTime.getDayOfMonth();
        System.out.println(month + ", " + dayOfMonth + ", " + dayOfWeek);

        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(18).withMonth(Month.MAY.getValue()).withYear(2018);
        System.out.println(localDateTime1);

        LocalDate localDate2 = LocalDate.of(2018, Month.MARCH, 28);
        System.out.println(localDate2);

        LocalDateTime localDateTime2 = LocalDateTime.of(localDate2, LocalTime.now());
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = LocalDateTime.of(LocalDate.parse("2018-06-01", DateTimeFormatter.ISO_DATE), LocalTime.parse("15:36:58.369"));
        System.out.println(localDateTime3);

    }

}
