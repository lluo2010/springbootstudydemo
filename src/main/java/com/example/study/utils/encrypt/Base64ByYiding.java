package com.example.study.utils.encrypt;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author: zzqfsy
 * @Description: Base64封装类
 * @Date: Created in 11:09 2018/5/24
 * @Modified By:
 **/
public class Base64ByYiding {
    public static void main(String[] args) {
        String encodeValue = encode("atool.org中文");
        System.out.println("base64 encode: " + encodeValue);
        System.out.println("base64 decode: " + decode(encodeValue));
    }

    public static String encode(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String s) {
        return new String(Base64.getDecoder().decode(s),StandardCharsets.UTF_8);
    }
}
