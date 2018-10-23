package com.loki.developerjdk8.stream;

import com.loki.developerjdk8.lambda.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作步骤
 * 1、创建Stream
 * 2、中间操作
 * 3、终止操作（终端操作）
 */
public class StreamTest2 {

    List<Student> list = Arrays.asList(
            new Student("张三", 16, "男", 500),
            new Student("李丽", 17, "女", 450),
            new Student("王五", 19, "男", 530),
            new Student("赵六", 18, "男", 600),
            new Student("田七", 17, "女", 570)
    );

    // 中间操作
    /**
     * 映射
     * map:接收Lambda,将元素转换成其他形式或提取信息.接收一个函数作为参数,该函数会被应用到每个元素上,并将其映射成一个新的元素.
     * flatMap:接收一个函数作为参数,将流中的每个值都换成另一个流,然后把所有流连接成一个流
     */
    @Test
    public void test1() {
        List<String> li = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        li.stream()
                .map(str -> str.toUpperCase())
                .forEach(System.out::println);

        list.stream()
                .map(Student::getName)
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<String> li = Arrays.asList("aa", "bb", "cc", "dd", "ee");

        Stream<Stream<Character>> stream = li.stream()
                .map(StreamTest2::filterCharacter);

        stream.forEach(sm -> sm.forEach(System.out::println));

        System.out.println("------------------------------------------------");

        li.stream()
                .flatMap(StreamTest2::filterCharacter)
                .forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> l = new ArrayList<>();
        for (Character c: str.toCharArray()) {
            l.add(c);
        }

        return l.stream();
    }

}
