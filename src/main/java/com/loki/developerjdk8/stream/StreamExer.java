package com.loki.developerjdk8.stream;

import com.loki.developerjdk8.lambda.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName StreamExer
 * @Desc 流练习
 * @Author xujs
 * @Date 2018/10/23 14:50
 * @Version 1.0
 */
public class StreamExer {

    List<Student> stus = Arrays.asList(
            new Student("张三", 16, "男", 500),
            new Student("李丽", 17, "女", 450),
            new Student("王五", 19, "男", 530),
            new Student("赵六", 18, "男", 600),
            new Student("田七", 17, "女", 570)
    );

    /**
     * 给定一个数字列表,如何返回一个由每个数的平方构成的列表呢
     * [1,2,3,4,5]-[1,4,9,16,25]
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .map(x -> x * x)
                .forEach(System.out::println);
    }

    /**
     * 用map和reduce方法数一数流中有多少个Student
     */
    @Test
    public void test2() {
        Optional<Integer> op =  stus.stream()
                .map(s -> 1)
                .reduce(Integer::sum);
        System.out.println(op.get());
    }

}
