package com.loki.developerjdk8.stream;

import com.loki.developerjdk8.lambda.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作步骤
 * 1、创建Stream
 * 2、中间操作
 * 3、终止操作（终端操作）
 */
public class StreamTest1 {

    List<Student> list = Arrays.asList(
            new Student("张三", 16, "男", 500),
            new Student("李丽", 17, "女", 450),
            new Student("王五", 19, "男", 530),
            new Student("赵六", 18, "男", 600),
            new Student("田七", 17, "女", 570),
            new Student("田七", 17, "女", 570),
            new Student("田七", 17, "女", 570)
    );

    // 中间操作
    /**
     * 筛选与切片
     * filter:接收Lambda,从流中排除某些元素;
     * limit:截断流,使其元素不超过给定数量;
     * skip(n):跳过元素,返回一个扔掉了前n个元素的流.若流中元素不足n个,则返回一个空流.与limit互补.
     * distinct:筛选,通过流所生成元素的hashCode()和equals()去除重复元素
     */
    // 内部迭代:迭代操作由Stream API完成
    @Test
    public void test1() {
        // 中间操作,不会执行任何操作
        Stream<Student> stream = list.stream()
                .filter(s -> {
                    System.out.println("Stream API 中间操作");
                    return s.getAge() > 17;
                });

        // 终止操作,一次性执行完全部内容,即"惰性求值"
        stream.forEach(System.out::println);

        System.out.println("--------------------------------------------------------");

        list.stream()
                .filter(s ->{
                    System.out.println("Stream API 中间操作");
                    return s.getAge() > 18;
                })
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        list.stream()
                .filter(s -> s.getScore() > 500)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("--------------------------------------------------");

        list.stream()
                .filter(s -> {
                    System.out.println("Stream 截断流");
                    return s.getScore() > 500;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        list.stream()
                .filter(s -> s.getScore() > 500)
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void test4() {
        list.stream()
                .filter(s -> s.getScore() > 500)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }

}
