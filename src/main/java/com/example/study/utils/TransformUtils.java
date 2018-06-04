package com.example.study.utils;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author: zzqfsy
 * @Description:
 * @Date: Created in 13:46 2018/5/25
 * @Modified By:
 **/
public class TransformUtils {
    /**
     * 转换Map值
     * @param params
     * @return
     */
    public static Map<String, Object> Map2MapForParseValue(Map<String, String[]> params) {

        Map<String, Object> result = new HashMap<>();

        //遍历
        for (Iterator iter = params.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry element = (Map.Entry) iter.next();
            //key值
            String strKey = String.valueOf(element.getKey());
            //value,数组形式
            String[] value = (String[]) element.getValue();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < value.length; i++) {
                sb.append(value[i] + ((i == value.length - 1) ? "" : ","));
            }

            result.put(strKey, sb.toString());
        }

        return result;
    }

    /**
     * object转map, 依赖json
     * 属性->key
     * 值->value
     * @param obj
     * @return
     */
    public static Map<String, Object> Obj2MapByJson(Object obj) {
        return JSONObject.parseObject(JSONObject.toJSONString(obj));
    }

    /**
     * object转map, 依赖反射
     * 属性->key
     * 值->value
     * @param obj
     * @return
     */
    @Deprecated
    public static Map<String, Object> Obj2MapByReflect(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = getAllFields(obj);
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Obj2MapByReflect IllegalAccessException:" + JSONObject.toJSONString(obj));
            }
        }
        return map;
    }

    /**
     * 获取一个对象的所有属性
     * @param object
     * @return
     */
    private static Field[] getAllFields(Object object){
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null){
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }
}
