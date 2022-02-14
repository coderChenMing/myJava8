package com.learn.java8.bean;

import java.util.Objects;

/**
 * Project: myJava8
 * File Created at 2022-02-12 16:27:16:27
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Student.java
 * @Desc
 * @date 2022/2/12 16:27
 */
public class Student {
    private String name;
    private int age;
    private double score;
    private Status status;

    public Student() {
    }

    public Student(String name, int age, double score, Status status) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() &&
            Double.compare(student.getScore(), getScore()) == 0 &&
            Objects.equals(getName(), student.getName()) &&
            getStatus() == student.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getScore(), getStatus());
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", score=" + score +
            ", status=" + status +
            '}';
    }

    public enum  Status{
        FREE,
        BUSY,
        VOCATION
    }
}
