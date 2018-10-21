package com.loki.developerjdk8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8中内置的4大核心函数式接口
 * <p>
 * Consumer<T>:消费型接口
 * void accept(T t);
 * <p>
 * Supplier<T>:供给型接口
 * T get();
 * <p>
 * Function<T,R>:函数型接口
 * <p>
 * Predicate<T>:段言型接口
 * boolean test（T t）
 */
public class LambdaTest4 {

    @Test
    public void test1() {
        happy(1000, m -> System.out.println("先生您好，您本次消费了" + m + "元！"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        getNumList(5, () -> (int) (Math.random() * 1000)).forEach(System.out::println);
    }

    public List<Integer> getNumList(int num, Supplier<Integer> su) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(su.get());
        }

        return list;
    }

    @Test
    public void test3() {
        System.out.println(strHandler("\t\t\t  Lambda   ", str -> str.trim()));
    }

    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    @Test
    public void test4() {
        List<String> l = Arrays.asList("Lambda", "SpringBoot", "Java", "Spring");
        filterStr(l, s -> s.length() > 5).forEach(System.out::println);
    }

    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> newList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                newList.add(str);
            }
        }
        return newList;
    }

}
