package com.example.study.model;

import java.io.Serializable;

/**
 * Created by louis on 2018/5/30.
 */
public class UserInfo implements Serializable{
    int age;
    String name;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
