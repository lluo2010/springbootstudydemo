package com.example.study.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zzqfsy on 4/5/16.
 */
public class DateUtils {
    public static long SECONDS_OF_ONE_MINUTE=60L;
    public static long SECONDS_OF_ONE_HOUR=60L*SECONDS_OF_ONE_MINUTE;
    public static long SECONDS_OF_ONE_DAY=24L*SECONDS_OF_ONE_HOUR;
    public static long SECONDS_OF_ONE_WEEK=7*24L*SECONDS_OF_ONE_HOUR;

    public static final String FORMAT_DATE_CHS = "yyyy年MM月dd日";

    public static final String FORMAT_DATETIME_CHS = "yyyy年MM月dd日 HH:mm:ss";
    private static final String FORMAT_DATETIME_LONG = "yyyyMMddHHmmss";
    private static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATEHOUR = "yyyy-MM-dd HH";
    private static final String FORMAT_DATEMONTH = "yyyy-MM";
    private static final String FORMAT_DATE = "yyyy-MM-dd";
    private static final String FORMAT_TIME = "HH:mm:ss";
    private static final String FORMAT_TIME_HOUR_MIN = "HH:mm";
    private static final String FORMAT_TIME_HHMMSS = "HHmmss";
    public static final String FORMAT_DATETIME_YYYYMMDD = "yyyyMMdd";
    private static final String FORMAT_DATETIME_4MIN = "yyyyMMddHHmm";
    private static final String FORMAT_DATETIME_YYMMDD="yyMMdd";
    public static final String FORMAT_DATETIME_MMDD="MMdd";


    public static final SimpleDateFormat sdf=new SimpleDateFormat();
    public static String formatDate(Date date,String format){
        sdf.applyPattern(format);
        return sdf.format(date);
    }

    public static String formatDate(Date date){
        return formatDate(date, FORMAT_DATE);
    }

    public static String formatDateTime(Date date){
        return formatDate(date, FORMAT_DATETIME);
    }

    public static Date parseDate(String strDate) {
        return parse(strDate, FORMAT_DATE);
    }

    public static Date parseDateTime(String strDate) {
        return parse(strDate, FORMAT_DATETIME);
    }

    /**
     * 将日期转换为指定格式字符串
     *
     * @param date
     * @param strFormat
     * @return
     */
    public final static String format(Date date, String strFormat) {
        return new SimpleDateFormat(strFormat).format(date);
    }

    /**
     * 将日期转化为yyyy-MM格式字符串
     *
     * @param date
     * @return
     */
    public final static String formatDateMonth(Date date) {
        return format(date, FORMAT_DATEMONTH);
    }

    /**
     * 将日期时间转换为yyyyMMddHHmmss格式字符串
     *
     * @param date
     * @return
     */
    public final static String formatLongDateTime(Date date) {
        return format(date, FORMAT_DATETIME_LONG);
    }

    public static Date parseDateMonth(String strDate) {
        return parse(strDate, FORMAT_DATEMONTH);
    }

    public static Date getMonthFirstDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));

        // 设置时间为0时
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getMonthLastDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        // 设置时间为最后时刻
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    public static Date beforeXMonth(Date date, Integer X) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, X);
        return cal.getTime();
    }

    public static Date beforeXMINUTE(Date date, Integer X) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, X);
        return cal.getTime();
    }

    public static Date getCleanDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        date = cal.getTime();
        return date;
    }

    public static Date getLastMomentDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        date = cal.getTime();
        return date;
    }

    public static Date parse(String strDate, String strFormat) {

        if (strDate == null || strDate.trim().length() == 0) {
            return null;
        }

        try {
            return new SimpleDateFormat(strFormat).parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static Date beforeXDay(Date date, Integer X) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, X);

        // 设置时间为0时
        getDayFirstTime(cal);
        return cal.getTime();
    }

    public static Date addDay(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
    public static Date getDayFirstTime(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return getDayFirstTime(cal).getTime();
    }

    public static Calendar getDayFirstTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }
    public static Date getDayFinalTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return getDayFinalTime(cal).getTime();
    }
    public static Calendar getDayFinalTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal;
    }


    /**
     * 获取时间date1与date2相差的秒数
     *
     * @param date1
     *            起始时间
     * @param date2
     *            结束时间
     * @return 返回相差的秒数
     */
    public static int getOffsetSeconds(Date date1, Date date2) {
        int seconds = (int) ((date2.getTime() - date1.getTime()) / 1000);
        return seconds;
    }


    /**
     * 获取时间date1与date2相差的分钟数
     *
     * @param date1
     *            起始时间
     * @param date2
     *            结束时间
     * @return 返回相差的分钟数
     */
    public static int getOffsetMinutes(Date date1, Date date2) {
        return getOffsetSeconds(date1, date2) / 60;
    }

    /**
     * 是否周末
     * @param date
     * @return
     */
    public static boolean isWeekend(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (week == 6 || week == 0) {//0代表周日，6代表周六
            return true;
        }
        return false;
    }

    public static int getDaysBetweenToDate(Date end, Date start) {
        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();

        calst.setTime(start);
        caled.setTime(end);
        // 设置时间为0时
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);
        calst.set(Calendar.MILLISECOND, 0);
        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);
        caled.set(Calendar.MILLISECOND, 0);
        // 得到两个日期相差的天数
        return  ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;
    }
}
