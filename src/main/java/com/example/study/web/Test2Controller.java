package com.example.study.web;

import com.example.study.model.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by louis on 2018/5/30.
 */
@RestController
@RequestMapping("test2")
public class Test2Controller {


    @GetMapping("getUser")
    public UserInfo getUser(){
        System.out.println("get user---");
        UserInfo info = new UserInfo();
        info.setAge(10);
        info.setName("luo");
        return info;
    }
}
