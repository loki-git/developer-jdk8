package com.loki.developerjdk8.stream;

import com.loki.developerjdk8.lambda.Student;
import com.loki.developerjdk8.lambda.Student.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 3、终止操作（终端操作）
 */
public class StreamTest4 {

    List<Student> list = Arrays.asList(
            new Student("张三", 16, "男", 500, Status.BUSY),
            new Student("李丽", 17, "女", 450, Status.FREE),
            new Student("王五", 19, "男", 530, Status.FREE),
            new Student("赵六", 18, "男", 600, Status.VOCATION),
            new Student("田七", 17, "女", 570, Status.BUSY)
    );

    /**
     * 查找与匹配
     * allMatch:检查是否匹配所有元素
     * anyMatch:检查是否至少匹配一个元素
     * noneMatch:检查是否没有匹配所有元素
     * findFirst:返回第一个元素
     * findAny:返回当前流中的任意元素
     * count:返回流中元素的总个数
     * max:返回流中最大值
     * min:返回流中最小值
     */
    @Test
    public void test1() {
        boolean b1 = list.stream()
                .allMatch(s -> s.getStatus().equals(Status.BUSY));
        System.out.println(b1);

        boolean b2 = list.stream()
                .anyMatch(s -> s.getStatus().equals(Status.BUSY));
        System.out.println(b2);

        boolean b3 = list.stream()
                .noneMatch(s -> s.getStatus().equals(Status.BUSY));
        System.out.println(b3);

        Optional<Student> op = list.stream()
                .sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
                .findFirst();
        System.out.println(op.get());

        // stream串行流,单个线程找;parallelStream并行流,多个线程进行查找,先找到算谁的
        Optional<Student> op1 = list.parallelStream()
                .filter(s -> s.getStatus().equals(Status.FREE))
                .findAny();
        System.out.println(op1.get());
    }

    @Test
    public void test2() {
        Long count = list.stream()
                .count();
        System.out.println(count);

        Optional<Student> op =  list.stream()
                .max((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()));
        System.out.println(op.get());

        Optional<Integer> op1 = list.stream()
                // 对象::实例方法名
                .map(Student::getScore)
                // 类::静态方法名
                .min(Integer::compare);
        System.out.println(op1.get());
    }

}
