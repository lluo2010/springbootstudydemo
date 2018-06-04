package com.example.study.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.study.utils.encrypt.Base64ByYiding;
import com.example.study.utils.encrypt.SHAByYiding;
import org.junit.Assert;

import java.util.*;

/**
 * @Author: zzqfsy
 * @Description: 签名工具类
 * @Date: Created in 11:09 2018/5/24
 * @Modified By:
 **/
public class SignUtils {

    private static final String SIGN_KEY = "sign";

    public static void main(String[] args) {
        /*
//        String signValue = sign("atool.org中文");
//        System.out.println("sign: " + signValue);
        SmsMessageReq smsMessageReq = new SmsMessageReq();
        smsMessageReq.setMobile("18611111111");
        smsMessageReq.setMsg("您好");
        smsMessageReq.setSmsProvider(SmsProviderEnum.YUNXIN.getSmsProvider());
        smsMessageReq.setDeviceType(1);
        smsMessageReq.setTimestamp(DateUtils.parseDate("2018-05-24").getTime());
        smsMessageReq.setSign(signByParams(JSONObject.parseObject(JSONObject.toJSONString(smsMessageReq))));
        System.out.println("sign: " + JSONObject.toJSONString(smsMessageReq));

        Assert.assertNotEquals(smsMessageReq.getSign(), signByParams(JSONObject.parseObject(JSONObject.toJSONString(smsMessageReq))), "not equals");

        */
    }

    /**
     * 验证签名，参数中的
     *
     * @param map 所有参数
     * @return
     */
    public static boolean verifySign(Map<String, Object> map) {
        if (!String.valueOf(map.get(SIGN_KEY)).equals(String.valueOf(signByParams(map)))) {
            return false;
        }
        return true;
    }

    /**
     * 得到签名，根据参数串
     *
     * @param map 签名组成参数
     * @return
     */
    public static String signByParams(Map<String, Object> map) {
        String text = sortAndconcatParameter(map, SIGN_KEY);
        return HttpParamUtls.getUrlEncoding(sign(text));
    }

    /**
     * 得到签名，根据字符串
     *
     * @param text 字符串
     * @return 签名值
     */
    private static String sign(String text) {
        String cipher = SHAByYiding.SHA256(text).toUpperCase();
        if (cipher.length() > 4) cipher = cipher.substring(1, 4) + cipher;
        return Base64ByYiding.encode(cipher);
    }

    /**
     * 参数排序重组成字符串
     *
     * @param map            参数串
     * @param skipParamNames 跳过的参数名
     * @return
     */
    private static String sortAndconcatParameter(Map<String, Object> map, String... skipParamNames) {
        StringBuilder sb = new StringBuilder();

        List<String> skipParamNameList = Arrays.asList(skipParamNames);

        // 按照key做字母升序排列
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            if (skipParamNameList.contains(key)) {
                continue;
            }

            String value = String.valueOf(map.getOrDefault(key, ""));
            sb.append((i == 0 ? "" : "&") + key + "=" + value);
        }

        return sb.toString();
    }
}
