package com.example.study.utils;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by zzqfsy on 2017/7/17.
 */
public class TypeUtils {

    public static HashMap<String, Object> getHashMap(Object value){
        try{
            return (HashMap<String, Object>)value;
        }catch (Exception ex){
            return new HashMap<>();
        }
    }

    public static BigDecimal getBigDecimalValue(Object value){
        try{
            return new BigDecimal(value.toString());
        }catch (Exception ex){
            return BigDecimal.ZERO;
        } 
    }
}
