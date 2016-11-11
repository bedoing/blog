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

public class DateUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatCalendar(Calendar objCal, String strFormat) {

        if (objCal == null) {
            return null;
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
            return formatter.format(objCal.getTime());
        }
    }

    public static String formatDate(Date dt, String format) {
        if (dt == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            return formatCalendar(cal, format);
        }
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

	
	public static long getTimeImMillis(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getTimeInMillis();
	}

    private DateUtils() {

    }
}
