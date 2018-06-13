package com.example.study.web;

import com.example.study.domain.User;
import com.example.study.service.UserService;
import com.example.study.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by louis on 2018/5/30.
 */
@RestController
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserService userService;

    @GetMapping("hello")
    public String hello() {

        Map<String, Object> params = new HashMap<>();
        //params.put("username", "15867109701");
        params.put("id", 96);
        User user = userService.get(params);
        if (user != null) {
            System.out.println("user:" + user.getUsername());
            LOG.info("user:"+user.getUsername());
        }
        return "hello";
    }

}
