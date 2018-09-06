package com.example.study.mystudytest.beanValidator;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by louis on 2018/9/5.
 */
public class Info1 {
    @Min(value=100, message = "值太小了")
    private int value;
    @NotEmpty
    private String name;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
