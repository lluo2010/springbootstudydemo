package com.example.study.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: zzqfsy
 * @Description:
 * @Date: Created in 16:02 2018/5/24
 * @Modified By:
 **/
public class HttpParamUtls {
    /**
     * 获取字符串的url encoding
     * @param s
     * @return
     */
    public static String getUrlEncoding(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("getUrlEncoding UnsupportedEncodingException:" + s);
        }
    }
}
