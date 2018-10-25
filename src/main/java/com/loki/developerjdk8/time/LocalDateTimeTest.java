package com.loki.developerjdk8.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * @ClassName LocalDateTimeTest
 * @Desc
 * @Author xujs
 * @Date 2018/10/24 18:54
 * @Version 1.0
 */
public class LocalDateTimeTest {

    /**
     * ZonedDate、ZonedTime、ZonedDateTime
     */
    @Test
    public void test7 () {
        // 获取所有时区 599个
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);

        System.out.println("---------------------------------------------");

        LocalDateTime ldt1 = LocalDateTime.now(ZoneId.of("America/Panama"));
        System.out.println(ldt1);

        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);
    }

    /**
     * DateTimeFormatter:格式化时间/日期
     */
    @Test
    public void test6() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();

        String strDate = dtf.format(ldt);
        System.out.println(strDate);

        System.out.println("--------------------------------------------");

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDate1 = dtf1.format(ldt);
        System.out.println(strDate1);

        LocalDateTime newDate = ldt.parse(strDate1, dtf1);
        System.out.println(newDate);
    }

    /**
     * TemporalAdjuster:时间校正器
     */
    @Test
    public void test5 () {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        // 指定时间中的day
        LocalDateTime ldt1 = ldt.withDayOfMonth(10);
        System.out.println(ldt1);

        // 下个周一
        LocalDateTime ldt2 = ldt.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(ldt2);

        System.out.println("---------------------------------------------------");
        // 自定义:下个工作日
        LocalDateTime ldt4 = ldt.with(d -> {
            LocalDateTime ldt3 = (LocalDateTime) d;
            DayOfWeek dof = ldt3.getDayOfWeek();
            if (dof.equals(DayOfWeek.FRIDAY)) {
                return ldt3.plusDays(3);
            } else if (dof.equals(DayOfWeek.SATURDAY)) {
                return ldt3.plusDays(2);
            } else {
                return ldt3.plusDays(1);
            }
        });

        System.out.println(ldt4);
    }

    /**
     * Period:计算两个"日期"之间的间隔
     */
    @Test
    public void test4 () {
        LocalDate ld = LocalDate.now();
        LocalDate ld1 = LocalDate.of(2019, 1, 1);

        Period per = Period.between(ld, ld1);
        System.out.println(per);
        System.out.println(per.getYears());
        System.out.println(per.getMonths());
        System.out.println(per.getDays());
    }

    /**
     * Duration:计算两个"时间"之间的间隔
     */
    @Test
    public void test3() {
        Instant ins = Instant.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant ins1 = Instant.now();

        Duration dur = Duration.between(ins, ins1);
        System.out.println(dur.toMillis());

        System.out.println("--------------------------------------------");

        LocalTime lt = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime lt1 = LocalTime.now();

        System.out.println(Duration.between(lt, lt1).toMillis());
    }

    /**
     * Instant:时间戳(以Unix元年:1970年1月1日 00:00:00到某个时间之间的毫秒值)
     */
    @Test
    public void test2() {
        Instant ins = Instant.now();
        System.out.println(ins);

        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        // 转时间戳
        System.out.println(ins.toEpochMilli());

        Instant ins1 = Instant.ofEpochSecond(1);
        System.out.println(ins1);
    }

    /**
     * LocalDate LocalTime LocalDateTime
     */
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2018, 10, 24, 20, 12, 10);
        System.out.println(ldt2);

        LocalDateTime ldtYear = ldt.plusYears(1);
        System.out.println(ldtYear);
        LocalDateTime ldtMonth = ldt.plusMonths(1);
        System.out.println(ldtMonth);
        LocalDateTime ldt3 = ldt.plusDays(1);
        System.out.println(ldt3);

        LocalDateTime minusWeeks = ldt.minusWeeks(1);
        System.out.println(minusWeeks);
    }

}
