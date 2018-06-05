package com.example.study;

import com.example.study.service.RedisCacheDB1Service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by louis on 2018/6/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    private RedisCacheDB1Service redisCacheDB1Service;


    @Test
    public void saveAndGetValueTest(){
        String strKey = "luokey1";
        redisCacheDB1Service.put(strKey,"2");
        String s = redisCacheDB1Service.get(strKey);
        Assert.assertEquals("2", s);
        System.out.println("result:"+s);
    }


    @Test
    public void get(){
        String strKey = "luokey1";
        String s = redisCacheDB1Service.get(strKey);
        System.out.println("result:"+s);
    }
}
