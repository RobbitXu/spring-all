package com.spring.common;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * Created by admin on 2018/11/8.
 */
public class TimeUtils {

    /**
     * Clock 时钟
    * Clock类提供了访问当前日期和时间的方法，Clock是时区敏感的，可以用来取代 System.currentTimeMillis()
     * 来获取当前的微秒数。
    * 某一个特定的时间点也可以使用Instant类来表示，Instant类也可以用来创建老的java.util.Date对象。
     */
    public static Date currentTime(){
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println("millis : "+ millis );
        Instant instant = clock.instant();
        Date legcyDate = Date.from(instant);
        System.out.println(legcyDate);
        return legcyDate;
    }

    /**
     *LocalTime 本地时间
     * LocalTime 定义了一个没有时区信息的时间，例如 晚上10点，或者 17:30:15。
     * 下面的例子使用前面代码创建的时区创建了两个本地时间。之后比较时间并以小时和分钟为单位计算两个时间的时间差：
     */
    public static void compareTime(){
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.now();
        System.out.println(localTime.isBefore(localTime1));
        long hoursBetween = ChronoUnit.HOURS.between(localTime,localTime1);
        long minutesBetween = ChronoUnit.MINUTES.between(localTime,localTime1);
        System.out.println(hoursBetween);
        System.out.println(minutesBetween);

        LocalTime late = LocalTime.of(23,59,59);
        System.out.println(late);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);
        LocalTime leetTime = LocalTime.parse("13:37",formatter);
        System.out.println(leetTime);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 5);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);
    }

    public static void main(String[] args) {
        compareTime();
    }
}
