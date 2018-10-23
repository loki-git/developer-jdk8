package com.loki.developerjdk8.lambda;

import java.util.Objects;

/**
 * @ClassName Student
 * @Desc
 * @Author xujs
 * @Date 2018/10/21 13:19
 * @Version 1.0
 */
public class Student {

    private String name;
    private Integer age;
    private String sex;
    private Integer score;
    private Status status;

    public Student() {
    }

    public Student(Integer age) {
        this.age = age;
    }

    public Student(Integer age, Integer score) {
        this.age = age;
        this.score = score;
    }

    public Student(String name, Integer age, String sex, Integer score) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.score = score;
    }

    public Student(String name, Integer age, String sex, Integer score, Status status) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.score = score;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", score=" + score +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(age, student.age) &&
                Objects.equals(sex, student.sex) &&
                Objects.equals(score, student.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, score);
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }
}
