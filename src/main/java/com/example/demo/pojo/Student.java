package com.example.demo.pojo;

import lombok.Data;

/**
 * @author ：hzd
 * @description：
 * @date ：2021/2/18 0018 10:00
 */
@Data
public class Student {
    private String name;
    private Integer age;
    private Integer stature;


    public Student(String name, Integer age, Integer stature) {
        this.name = name;
        this.age = age;
        this.stature = stature;
    }
}
