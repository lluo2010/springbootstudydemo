package com.example.study.utils.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: zzqfsy
 * @Description: SHA封装类
 * @Date: Created in 11:14 2018/5/24
 * @Modified By:
 **/
public class SHAByYiding {
    public static final String SHA_ALGORITHM = "SHA-256";

    public static void main(String[] args) {
        System.out.println("SHA-256: " + SHA256("atool.org中文"));
    }

    /**
     * SHA Security Hash Algorithm 安全散列算法，固定长度摘要信息
     * SHA-1 SHA-2( SHA-224 SHA-256 SHA-384 SHA-512) 使用的依然是MessageDigest类，JDK不支持224
     *
     * @param strText
     * @return
     */
    public static String SHA256(final String strText) {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance(SHA_ALGORITHM);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到 byte 類型结果
                byte byteBuffer[] = messageDigest.digest();

                // 將 byte 轉換爲 string
                StringBuffer strHexString = new StringBuffer();
                // 遍歷 byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("SHA256 NoSuchAlgorithmException: " + strText);
            }
        }

        return strResult;
    }
}
