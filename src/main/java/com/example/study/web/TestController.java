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
import java.util.List;
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


    /**
     * 测试使用@Select返回Integer型
     * @return
     */
    @GetMapping("queryInt")
    public String queryAnnotationTest() {
        int id = 10;
        int count = userService.queryCount(id);
        return "id<" + id + ":" + count;
    }


    /**
     * 测试使用@Select返回ObjectList
     * @return
     */
    @GetMapping("queryUserList")
    public String queryUserListAnnotationTest() {
        int id = 10;
        List<User> users = userService.queryUserList(id);
        StringBuffer sb = new StringBuffer();
        sb.append("id<"+id+":\n");
        users.forEach(user->{
            sb.append(user.getUsername()+"\n");
        });
        return sb.toString();
    }


    /**
     * 测试使用@Select返回Object
     * @return
     */
    @GetMapping("queryUser")
    public String queryUserAnnotationTest() {
        int id = 10;
        User user = userService.queryUser(10);
        return "id<" + id + ":" + user.getUsername();
    }
}
