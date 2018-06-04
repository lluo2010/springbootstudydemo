package com.example.study.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zzqfsy on 2017/5/3.
 */
public class ListUtils {
    public final static List<String> commonProperty = Arrays.asList("addTime", "addUserId", "modifyTime", "modifyUserId", "isDelete", "isDeleted");

    public static <T> boolean isEmpty(List<T> list){
        if (list == null || list.isEmpty()) return true;

        return false;
    }

    public static String[] getIgnoreProperties(boolean bCommon, String... ignoreProperties){
        List<String> result = new ArrayList<>();
        if (bCommon) result.addAll(commonProperty);
        Collections.addAll(result, ignoreProperties);
        return (String[]) result.toArray(new String[result.size()]);
    }

    public static <T> List<T> copyProperties(List<T> obj, Class<T> cls, String... ignoreProperties){
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < obj.size(); i++) {
            T t = null;
            try {
                t = cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                return result;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return result;
            }
            BeanUtils.copyProperties(obj.get(i), t, ignoreProperties);
            result.add(t);
        }

        return result;
    }

    public static <T, E> List<E> copyProperties(List<T> obj, Class<E> cls){
        List<E> result = new ArrayList<E>();
        for (int i = 0; i < obj.size(); i++) {
            E t = null;
            try {
                t = cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                return result;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return result;
            }
            BeanUtils.copyProperties(obj.get(i), t);
            result.add(t);
        }

        return result;
    }

    /**
     *
     * @param obj
     * @param pageNo start by 1;
     *               if set 0, then get all list;1
     * @param pageSize page size;
     * @param <T>
     * @return
     */
    public static <T> List<T> subListByPage(final List<T> obj, Integer pageNo, Integer pageSize){
        Integer fromIndex = getStartByPageNo(pageNo, pageSize);
        if (fromIndex == null) return obj;

        Integer toIndex = null;
        if (obj.size() < fromIndex){
            return new ArrayList<T>();
        }else if (obj.size() >= (fromIndex + Integer.valueOf(pageSize))) {
            toIndex = fromIndex + Integer.valueOf(pageSize);
        }else {
            toIndex = obj.size();
        }
        return obj.subList(fromIndex, toIndex);
    }

    public static Integer getStartByPageNo(Integer pageNo, Integer pageSize){
        if (pageNo.equals(0) || pageSize.equals(0)) return null;

        if (pageNo.equals(1)) return 0;

        return (Integer.valueOf(pageNo) - 1) * pageSize;
    }

    public static List<String> convertListToCommaList(List<String> mobiles, int size){
        if (size <= 0) return mobiles;

        List<String> mobilesPresend = new ArrayList<>();
        while (mobiles.size() > size){
            mobilesPresend.add(StringUtils.arrayToDelimitedString(mobiles.subList(0, size).toArray(), ","));
            mobiles = mobiles.subList(size, mobiles.size());
        }

        if (mobiles.size() != 0)
            mobilesPresend.add(StringUtils.arrayToDelimitedString(mobiles.toArray(), ","));

        return mobilesPresend;
    }
}
