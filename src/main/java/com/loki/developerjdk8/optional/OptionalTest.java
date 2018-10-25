package com.loki.developerjdk8.optional;

import com.loki.developerjdk8.lambda.Student;
import org.junit.Test;

import java.util.Optional;

/**
 * @ClassName OptionalTest
 * @Desc
 * @Author xujs
 * @Date 2018/10/23 16:48
 * @Version 1.0
 */
public class OptionalTest {

    /**
     * 一、Optional 容器类：用于尽量避免空指针异常
     * Optional.of(T t) : 创建一个 Optional 实例
     * Optional.empty() : 创建一个空的 Optional 实例
     * Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
     * isPresent() : 判断是否包含值
     * orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
     * orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
     * map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
     * flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
     */
    @Test
    public void test4 () {
        Optional<Student> op = Optional.ofNullable(new Student("唐三", 18, "男", 650, Student.Status.BUSY));

        Optional<String> op1 = op.map((s) -> s.getName());
        System.out.println(op1.get());

        Optional<String> op2 = op.flatMap((s) -> Optional.of(s.getName()));
        System.out.println(op2.get());
    }

    @Test
    public void test3 () {
        Optional<Student> op = Optional.ofNullable(null);

        // 判断op中是否有值
        if (op.isPresent()) {
            System.out.println(op.get());
        }

        Student s = op.orElse(new Student("唐三", 18, "男", 650, Student.Status.BUSY));
        System.out.println(s);

        Student s1 = op.orElseGet(() -> new Student());
        System.out.println(s1);
    }

    @Test
    public void test2() {
        Optional<Student> op = Optional.empty();
        System.out.println(op.get());
    }

    @Test
    public void test1() {
        Optional<Student> op = Optional.of(new Student());
        System.out.println(op.get());
    }

    @Test
    public void test5() {
        Man man = new Man();

        String name = getGodnessName(man);
        System.out.println(name);
    }

    //需求：获取一个男人心中女神的名字
    public String getGodnessName(Man man) {
        if (man != null) {
            Godness g = man.getGod();
            if (g != null) {
                return g.getName();
            }
        }

        return "苍老师";
    }

    //运用 Optional 的实体类
    @Test
    public void test6() {
        Optional<Godness> godness = Optional.ofNullable(new Godness("林志玲"));

        Optional<NewMan> op = Optional.ofNullable(new NewMan(godness));
        String name = getGodnessName2(op);
        System.out.println(name);
    }

    public String getGodnessName2(Optional<NewMan> man) {
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("苍老师"))
                .getName();
    }

}
