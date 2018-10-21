package com.loki.developerjdk8.lambda;

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

    public Student() {
    }

    public Student(String name, Integer age, String sex, Integer score) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.score = score;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", score=" + score +
                '}';
    }

}
