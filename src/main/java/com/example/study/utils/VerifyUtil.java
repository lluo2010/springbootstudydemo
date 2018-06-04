package com.example.study.utils;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyUtil {

	/**
	 * @Author: zzqfsy
	 * @Description: 比较版本号
	 * @Date: 18:25 2018/5/4
	 * @params:
	 * @param version1 版本号，如1.3.1
	 * @param version2 版本号，如1.3.1
	 * @return
	 */
	public static int compareVersion(String version1, String version2) {
		String[] arr1 = version1.replaceAll("[a-zA-Z]","").split("\\.");
		String[] arr2 = version2.replaceAll("[a-zA-Z]","").split("\\.");

		int i=0;
		while(i<arr1.length || i<arr2.length){
			if(i<arr1.length && i<arr2.length){
				if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])){
					return -1;
				}else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])){
					return 1;
				}
			} else if(i<arr1.length){
				if(Integer.parseInt(arr1[i]) != 0){
					return 1;
				}
			} else if(i<arr2.length){
				if(Integer.parseInt(arr2[i]) != 0){
					return -1;
				}
			}
			i++;
		}
		return 0;
	}

	public static boolean verifyMobile(String mobile){
		String regExp = "^[1][3,4,5,6,7,8,9][0-9]{9}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(mobile);
		return m.find();
	}



	public static boolean verifyIp(String str){
        boolean result;
        if(str.equals("0.0.0.0")){
            result=false;
        }else{
            Pattern pattern=Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
            Matcher matcher=pattern.matcher(str);
            result=matcher.matches();
        }
		return result;
	}

    public static String getTrueUserIp(String userIp){
        String result;
        if(verifyIp(userIp)){
            result=userIp;
        }else{
            result="192.168.0."+(new Random().nextInt(254)+1);
        }
        return result;
    }

    public static boolean isNumber(String str)
    {
    	
        Pattern pattern = Pattern.compile("^[1-9]\\d*$");
        Matcher match=pattern.matcher(str);
        return match.matches();
    }
    
    public static boolean isZZS(Double d)
    {
    	double y = d%1;
        return y == 0;
    }

	public static boolean isInteger(String str){
		try{
			Integer.valueOf(str);
		}catch(NumberFormatException ex){
			return  false;
		}
		return true;
	}

	public static Integer valueOfInteger(String str){
		try{
			return Integer.valueOf(str);
		}catch(NumberFormatException ex){
			return 0;
		}
	}

	public static Long valueOfLong(String str){
		try{
			return Long.valueOf(str);
		}catch(NumberFormatException ex){
			return 0L;
		}
	}


	public static boolean isLong(String str){
		try{
			Long.valueOf(str);
		}catch(NumberFormatException ex){
			return  false;
		}
		return true;
	}

	public static boolean validUserId(String userId){
		try{
			Long uid = Long.valueOf(userId);
			return uid > 0;
		}catch(NumberFormatException ex){
			return  false;
		}
	}

	public static boolean validUserId(Long userId){
		if (userId == null) return false;
		return userId > 0;
	}


	public static boolean isDouble(String str){
		try{
			Double.valueOf(str);
		}catch(NumberFormatException ex){
			return  false;
		}
		return true;
	}

	public static BigDecimal valueOfBigDecimal(String str){
		return valueOfBigDecimal(str, BigDecimal.ZERO);
	}

	public static BigDecimal valueOfBigDecimal(String str, BigDecimal defaultValue){
		try{
			return new BigDecimal(str);
		}catch(Exception ex){
			return defaultValue;
		}
	}

	public static boolean isJson(String str){
		try{
			JSONObject.parseObject(str);
		}catch(Exception ex){
			return  false;
		}
		return true;
	}

	private static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
		}
	public static void main(String[] args){
		System.out.println(isLong("11"));
		System.out.println(isInteger("11"));
		System.out.println(isDouble("11"));
	}

	public static String formatString(String text) {
		return text == null ? "" : text.trim();
	}
}
