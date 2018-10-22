package com.loki.developerjdk8.lambda2;

import com.loki.developerjdk8.lambda.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @ClassName MethodRefExer
 * @Desc
 * @Author xujs
 * @Date 2018/10/21 19:58
 * @Version 1.0
 */
public class MethodRefExer {

    List<Student> list = Arrays.asList(
            new Student("张三", 16, "男", 500),
            new Student("李丽", 17, "女", 450),
            new Student("王五", 19, "男", 530),
            new Student("赵六", 18, "男", 600),
            new Student("田七", 17, "女", 570)
    );

    @Test
    public void test1() {
        Collections.sort(list, (s1, s2) -> {
            if (s1.getAge() == s2.getAge()) {
                return s1.getName().compareTo(s2.getName());
            } else {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        });

        list.forEach(System.out::println);
    }

    @Test
    public void test2() {
        Function<String, String> fun = s -> s.toUpperCase();
        System.out.println(fun.apply("abcdef"));

        Function<String, String> fun1 = String::toUpperCase;
        System.out.println(fun1.apply("lmn"));

        Function<String, String> fun2 = s -> s.substring(2, 5);
    }

    @Test
    public void test3() {
        BiFunction<Long, Long, Long> biF = (x, y) -> x + y;
        System.out.println(biF.apply(100l, 200l));
    }

}
