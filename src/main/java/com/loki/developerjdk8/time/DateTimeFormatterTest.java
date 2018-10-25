package com.loki.developerjdk8.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName DateTimeFormatterTest
 * @Desc
 * @Author xujs
 * @Date 2018/10/24 18:44
 * @Version 1.0
 */
public class DateTimeFormatterTest {

    /**
     * JDK8时间格式化没有线程安全问题
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20181024", dtf);
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(pool.submit(task));
        }

        for (Future<LocalDate> future : result) {
            System.out.println(future.get());
        }

        pool.shutdown();
    }

}
