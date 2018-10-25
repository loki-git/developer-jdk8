package com.loki.developerjdk8.time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName SimpleDateFormatTest
 * @Desc
 * @Author xujs
 * @Date 2018/10/23 20:43
 * @Version 1.0
 */
public class SimpleDateFormatTest {

    /**
     * 传统时间格式化存在线程安全问题
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return sdf.parse("20181023");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            result.add(pool.submit(task));
        }

        for (Future<Date> future : result) {
            System.out.println(future.get());
        }

        pool.shutdown();
    }

}
