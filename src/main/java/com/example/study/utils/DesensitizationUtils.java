package com.example.study.utils;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by zzqana on 8/19/2016.
 */
public class DesensitizationUtils {

    public static String getMobile(String mobile){
        if (!StringUtils.isEmpty(mobile) && (mobile.length() == 11))
            return mobile.substring(0, 3) + "****" + mobile.substring(7);
        else
            return mobile;
    }

    public static String getRealName(String realName){
        if (!StringUtils.isEmpty(realName) && (realName.length() == 2))
            return realName.substring(0 ,1) + "*";
        else if(!StringUtils.isEmpty(realName) && (realName.length() >= 3))
            return realName.substring(0 ,1) + "*" + realName.substring(2);
        else
            return realName;
    }

    public static String getRealName2(String realName){
        if (!StringUtils.isEmpty(realName) && (realName.length() >= 2))
            return realName.substring(0, 1) + realName.replaceAll("[0-9a-zA-Z\\u4e00-\\u9fa5]", "*").substring(1);
        else
            return realName;
    }

    public static String getCardNo(String cardNo){
        if (!StringUtils.isEmpty(cardNo) && (cardNo.length() == 15))
            return cardNo.substring(0, 3) + "*********" + cardNo.substring(11);
        else if (!StringUtils.isEmpty(cardNo) && (cardNo.length() == 18))
            return cardNo.substring(0, 3) + "************" + cardNo.substring(14);
        else
            return cardNo;
    }

    /**
     * 统一社会信用代码脱敏
     * @param uscc
     * @return
     */
    public static String getUnifiedSocialCreditCode(String uscc){
        return (StringUtils.isEmpty(uscc) || uscc.length() < 7) ? "" : uscc.substring(0, 3) + uscc.substring(3, uscc.length() - 4).replaceAll("\\w", "*") + uscc.substring(uscc.length() - 4);
    }

    /**
     * 地址脱敏
     * @param address
     * @return
     */
    public static String getAddress(String address){
        return (StringUtils.isEmpty(address) || address.length() < 6) ? "" : address.substring(0, 6) + address.substring(6).replaceAll("[\\w\\u4e00-\\u9fa5]", "*");
    }

    /**
     * 企业名称脱敏
     * @param enterpriseName
     * @return
     */
    public static String getEnterpriseName(String enterpriseName){
        return (StringUtils.isEmpty(enterpriseName) || enterpriseName.length() < 4) ? enterpriseName : enterpriseName.substring(0, 4) + enterpriseName.substring(4).replaceAll("[\\w\\u4e00-\\u9fa5]", "*");
    }


    /**
     * 去除html标签
     * @param html
     * @return
     */
    public static String removeHtmlTag(String html){
        return html.replaceAll("</?[^>]+>", "");
    }


    public static String getBankCardNo(String bankCardNo) {
        if (!StringUtils.isEmpty(bankCardNo)){
            return "尾号" + bankCardNo.substring(bankCardNo.length() - 4, bankCardNo.length());
        }else
            return bankCardNo;
    }

    public static String ID2HexID(Long id){
        long val = id * 1970;
        return Long.toHexString(val);
    }

    public static Long HexID2ID(String hexID){
        try{
            if (Long.parseLong(hexID, 16) % 1970 != 0) return null;
            return Long.parseLong(hexID, 16) / 1970;
        }catch(NumberFormatException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 手机号 打码
     * @param phone 1383838438
     * @return 138****8438
     */
    public static String phoneNumberFormat(String phone){
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
    }

    /**
     * 身份证 打码
     * @param idCard 430412123127733
     * @return 4304*****7733
     */
    public static String idCardFormat(String idCard){
        return idCard.replaceAll("(\\d{4})\\d{10}(\\w{4})","$1*****$2");
    }
}
