/**
 * DateUtils.java
 * Copyright (c) 2007 Sunrise Corporation.
 * #368, Guangzhou Avenue South, Haizhu District, Guangzhou
 * All right reserved.
 *
 */
package org.bedoing.util;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * <p>
 * Description: 时间类工具函数
 * </p>
 * 
 * @author 
 * @version 1.0
 */
public class DateUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 根据当前时间返回一个形式为'yyyy-MM-dd-HH-mm-ss'的字符串
     * <P>
     * 改字符串可作为一个文件的名称
     * 
     * @return 形式如'yyyy-MM-dd-HH-mm-ss'的字符串
     */
    public static final String dateTime2FileName() {
        String date_time = DateUtils.formatDate(new Date(),
                                                "yyyy-MM-dd HH:mm:ss");
        date_time = date_time.replaceAll(":", "-");
        date_time = date_time.replaceAll(" ", "-");
        return date_time;
    }

    /**
     * 格式化时间的显示，传入参数为Calendar
     * 
     * @param objCal
     *            Calendar Object
     * @param strFormat
     *            日期格式化的标准 e.g. "yyyy/MM/dd
     *            HH:mm:ss"（务必按标准写，可参考java.text.simpleDateFormat.java)
     * @return String 格式化的时间
     */
    public static String formatCalendar(Calendar objCal, String strFormat) {

        if (objCal == null) {
            return null;
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
            return formatter.format(objCal.getTime());
        }
    }

    /**
     * 格式化时间的显示，传入参数为Date
     * 
     * @param dt
     *            Date
     * @param strFormat
     *            日期格式化的标准 e.g. "yyyy/MM/dd
     *            HH:mm:ss"（务必按标准写，可参考java.text.simpleDateFormat.java)
     * @return String 格式化的时间
     */
    public static String formatDate(Date dt, String format) {
        if (dt == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            return formatCalendar(cal, format);
        }
    }
    
    public static String formatDate(Date dt) {
        if (dt == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            return formatCalendar(cal, "yyyy-MM-dd");
        }
    }
    
    public static String formatDateTime(Date dt, String format) {
        if (dt == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            return formatCalendar(cal, format);
        }
    }
    
    public static String formatDateTime(Date dt) {
        if (dt == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            return formatCalendar(cal, "yyyy-MM-dd HH:mm:ss" );
        }
    }

    /**
     * 格式化时间的显示
     * <p>
     * <code>strFormat</code>的格式如"yyyy/MM/dd
     * HH:mm:ss"（务必按标准写，可参考java.text.simpleDateFormat.java)
     * 
     * @param objTS
     *            Timestamp Object
     * @param strFormat
     *            日期格式化的标准 e.g. "yyyy/MM/dd
     *            HH:mm:ss"（务必按标准写，可参考java.text.simpleDateFormat.java)
     * @return String 格式化的时间
     */
    public static String formatTimestamp(Timestamp objTS, String strFormat) {

        if (objTS == null) {
            return null;
        } else {
            Calendar objCal = Calendar.getInstance();
            Date d = new Date(objTS.getTime());
            objCal.setTime(d);
            return formatCalendar(objCal, strFormat);
        }
    }

    /**
     * 返回特定时间的前几天 如果特定时间为"2005-5-23 23:22:32",<code>days</code>为7，
     * 如果from=false,则为2005-5-16 23:22:32, 如果from＝true，则为2005-5-16 00:00:00
     * <P>
     * 如果<code>days</code>是负数，则是返回其后几天
     * 
     * @param dt
     *            Date 指定的特定时间
     * @param days
     *            int 返回前几天的天数
     * @param from0
     *            boolean 是否从零点开始
     * @return Date
     */
    public static Date getBeforeDays(Date dt, int days, boolean from0) {
        if (dt == null) {
            return null;
        } else {
            Calendar cl = Calendar.getInstance();
            cl.setTime(dt);

            if (from0) {
                Calendar c2 = Calendar.getInstance();
                c2.set(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH), cl
                        .get(Calendar.DATE), 0, 0, 0);
                cl = c2;
            }

            cl.add(Calendar.DATE, -days);
            return cl.getTime();
        }
    }

    /**
     * 得到特定时间的前几个月的时间
     * <P>
     * 如果<code>months</code>是负数，则是返回其后几个月
     * 
     * @param dt
     *            Date 指定的特点时间
     * @param months
     *            int 返回前几月的月数
     * @return Date
     */
    public static Date getBeforeMonths(Date dt, int months) {
        if (dt == null) {
            return null;
        }
        int[] dts = DateUtils.TimeSplit(DateUtils
                .formatDate(dt, "yyyy-MM-dd HH-mm-ss"));
        int years = dts[0];
        int all = years * 12 + dts[1];
        int all_new = all - months - 1;
        int years_new = all_new / 12;
        int month_new = all_new % 12;
        Calendar dt_new = Calendar.getInstance();
        dt_new.setTime(dt);
        dt_new.set(years_new, month_new, dts[2], dts[3], dts[4], dts[5]);
        return dt_new.getTime();
    }

    /**
     * 计算两个时间之间相隔天数
     * <P>
     * 如果<code>startDay</code>或<code>endDay</code>有一个格式不为'yyyyMMdd'，则返回-1
     * 
     * @param startday
     *            开始时间
     * @param endday
     *            结束时间
     * @return 相隔的天数
     */
    public static int getIntervalDays(String startDay, String endDay) {
        if (startDay.length() != 8 || endDay.length() != 8) {
            return -1;
        }
        return getIntervalDays(DateUtils.string2Date(startDay, "yyyyMMdd"),
                               DateUtils.string2Date(endDay, "yyyyMMdd"));
    }

    /**
     * 计算两个时间之间相隔天数
     * <P>
     * 如果<code>startDay</code>或<code>endDay</code>有一个为<code>null</code>，则返回-1
     * 
     * @param startday
     *            开始时间
     * @param endday
     *            结束时间
     * @return 相隔的天数
     */
    public static int getIntervalDays(Calendar startDay, Calendar endDay) {
        if (startDay == null || endDay == null) {
            return -1;
        }
        return getIntervalDays(startDay.getTime(), endDay.getTime());
    }

    /**
     * 计算两个时间之间相隔天数
     * <P>
     * 如果<code>startDay</code>或<code>endDay</code>有一个为<code>null</code>，则返回-1
     * 
     * @param startday
     *            开始时间
     * @param endday
     *            结束时间
     * @return 相隔的天数
     */
    public static int getIntervalDays(Date startDay, Date endDay) {
        if (startDay == null || endDay == null) {
            return -1;
        }
        // 确保startday在endday之前
        if (startDay.after(endDay)) {
            Date cal = startDay;
            startDay = endDay;
            endDay = cal;
        }
        // 分别得到两个时间的毫秒数
        long start = startDay.getTime();
        long end = endDay.getTime();
        long inter = end - start;

        long dateMillSec = 24 * 60 * 60 * 1000;

        long dateCnt = inter / dateMillSec;

        long remainder = inter % dateMillSec;

        if (remainder != 0) {
            dateCnt++;
        }

        // 根据毫秒数计算间隔天数
        return (int) (dateCnt);
    }
    
    /**
     * 计算两个时间之间相隔天数
     * 如果开始时间比结束时间大则返回正值，否则返回负值
     * @param startDay
     * @param endDay
     * @return
     */
    public static int getDateIntervalDays(Date startDay, Date endDay) {
    	 // 分别得到两个时间的毫秒数
        long start = startDay.getTime();
        long end = endDay.getTime();
        long inter = end - start;

        long dateMillSec = 24 * 60 * 60 * 1000;

        long dateCnt = inter / dateMillSec;

        long remainder = inter % dateMillSec;
        
        if (remainder != 0) {
        	if(remainder>0){
        		dateCnt++;
        	}else{
        		dateCnt--;
        	}
        }

        // 根据毫秒数计算间隔天数
        return (int) (dateCnt);
    }

    /**
     * 计算某一月份的最大天数
     * 
     * @param year
     *            年份
     * @param month
     *            月份
     * @return 返回指定月份的最大天数
     */
    public static int getMaxDayInMonth(int year, int month) {
        Calendar time = Calendar.getInstance();
        time.clear();
        time.set(Calendar.YEAR, year);
        time.set(Calendar.MONTH, month - 1);// 注意,Calendar对象默认一月为0
        int day = time.getActualMaximum(Calendar.DAY_OF_MONTH);// 本月份的天数
        return day;
    }

    /**
     * 计算某一天是一年中的第几星期
     * <P>
     * 如果<code>date</code>为<code>null</code>，则返回0
     * 
     * @param date
     *            指定的时间
     * @return 返回指定时间是是一年中的第几星期
     */
    public static int getWeekNoOfDay(Date date) {
        if (date == null) {
            return -1;
        }
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        return time.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 返回当前时间，显示格式为：yyyy-MM-dd HH:mm:ss
     * 
     * @return String 格式化后的时间
     */
    public static String getNowDateTime() {
        Date datetime = new Date();
        return sdf.format(datetime);
    }

    /**
     * 把传入的 <code>sdate</code> 转化成<code>Date</code>
     * <P>
     * 传入的 <code>sdate</code>
     * 的格式务必按标准写（可参考java.text.simpleDateFormat.java）如'yyyy-MM-dd'、'yyyy-MM-dd
     * HH:mm:ss'
     * <P>
     * 当<code>sdate</code>为<code>null</code>或者<code>sdate</code>的长度为0时，返回<code>null</code>
     * <P>
     * 当<code>sdate</code>和<code>format</code>格式不同时返回<code>null</code>
     * 
     * @param sdate
     *            传入的时间串，格式为'yyyy-MM-dd'
     * @return 返回<code>sdate</code>表示的时间
     */
    public static final Date string2Date(String sdate, String format) {
        if (sdate == null || sdate.length() == 0) {
            return null;
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.parse(sdate);
        } catch (ParseException ex) {
            return null;
        }
    }

    /**
     * 从标准时间格式的字符串中取出年、月、日、时、分、秒组成的int类型数组
     * <P>
     * 如果传入的String为null或空，则直接返回null
     * 
     * @param DateTimeStr
     *            String "2004-2-2 3-34-35" (用－或：或/作间隔）
     * @return int[] 返回以年、月、日、时、分、秒组成的int类型数组
     */
    public static int[] TimeSplit(String DateTimeStr) {
        if (DateTimeStr == null || DateTimeStr.length() == 0) {
            return null;
        }

        DateTimeStr = DateTimeStr.trim().replaceAll("/", "-");
        DateTimeStr = DateTimeStr.replaceAll(" ", "-").replaceAll(":", "-");
        String[] values = DateTimeStr.split("-");
        int[] timeArr = new int[values.length];
        for (int i = 0; i < timeArr.length; i++) {
            try {
                timeArr[i] = Integer.parseInt(values[i]);
            } catch (NumberFormatException nfe) {
                timeArr[i] = 0;
            }
        }
        return timeArr;
    }

    /**
     * 根据毫秒，返回特定格式的日期字符串
     * @param format
     * @param millis
     * @return
     */
    public static String getDateStrByTimiMillis(String format, long millis){
    	Calendar cl = Calendar.getInstance();
    	cl.setTimeInMillis(millis);
    	
    	return new SimpleDateFormat(format).format(cl.getTime());
    }
    
    /**
     * 获取日期对应的星期中文<br/>
     * @param dateStr
     * @return 
     * @throws ParseException
     */
    public static String getWeekOfDayCn(Date date) {
	    Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
    	String[] cns = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
    	int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
    	if(w < 0 ){
    		w = 0;
    	}
    	
    	return cns[w];
    }
    
    /**
	 * 
	* <b>Summary: </b>
	*     toGreenwichTime(把“YYYY-MM-DD HH:MM:SS”时间串转成自1900-01-01 00:00:00格林威治时间以来的微秒数。)
	* @author YiLiang
	* @param sdate
	* @return
	* @throws ParseException 
	* @return Long
	 */
	public static Long toGreenwichTime(String dateFormatStr, String sdate) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat(StringUtils.isBlank(dateFormatStr)? "yyyy-MM-dd":dateFormatStr);
		
		Date dDate = dateFormat.parse(sdate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dDate);
		long srcTime = calendar.getTimeInMillis() + 2208988800000L;
		long targetTime = srcTime * 1000;
		return targetTime;
	}
	
    /**
	 * 
	* <b>Summary: </b>
	*     toGreenwichTime(把Date类型转成自1900-01-01 00:00:00格林威治时间以来的微秒数。)
	* @author wuhuabin
	* @param date
	* @return Long
	 */
	public static Long toGreenwichTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		long srcTime = calendar.getTimeInMillis() + 2208988800000L;
		long targetTime = srcTime * 1000;
		return targetTime;
	}
	
	/**
	 * 
	* <b>Summary: </b>
	*     toBeijinDate(把自1900-01-01格林威治时间以来的微秒数，转成北京时间，格式为YYYY-MM-DD HH:MM:SS,字符串格式。)
	* @author YiLiang
	* @param timeinmillis
	* @return 
	* @return String
	 */
	public static String toBeijinDate(long time){
		return toBeijinDate(time, null);
	}
    
	/**
	 * 
	* <b>Summary: </b>
	*     toBeijinDate(把自1900-01-01格林威治时间以来的微秒数，转成北京时间，格式默认为YYYY-MM-DD HH:MM:SS,可以自定义字符串格式。)
	* @author Jeson
	* @param timeinmillis
    * @param strFormat
    *            日期格式化的标准 e.g. "yyyy/MM/dd
    *            HH:mm:ss"（务必按标准写，可参考java.text.simpleDateFormat.java)
	* @return 
	* @return String
	 */
	public static String toBeijinDate(long time, String timeFormat){
		if (time <= 0L) {
			throw new IllegalArgumentException("Not Available Time: " + time);
		}
		SimpleDateFormat dateFormat = null;
		if(StringUtils.isBlank(timeFormat)) {
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else {
			dateFormat = new SimpleDateFormat(timeFormat);
		}
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		cal.setTimeInMillis(time);
		
		String sdate =dateFormat.format(cal.getTime());
		return sdate;
	}
	
	/**  
     * 计算两个日期之间相差的毫秒数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
	public static int secondBetween(Date smdate,Date bdate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }
	
	public static long getTimeImMillis(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getTimeInMillis();
	}
	
    /**
     * 私有的构造函数，可防止本类被实例化
     * 
     */
    private DateUtils() {

    }
    
   
}
