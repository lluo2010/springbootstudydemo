package com.example.study.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by louis on 2018/5/30.
 */
@RestController
public class TestController {


    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

}
