package com.example.demo.pojo;

import lombok.Data;

/**
 * @author ：hzd
 * @description：
 * @date ：2021/1/27 0027 11:55
 */
@Data
public class People {
    private Integer id;

    private String name;

    private String sex;

    private Integer age;

    public People(Integer id, String name, String sex, Integer age) {

        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
