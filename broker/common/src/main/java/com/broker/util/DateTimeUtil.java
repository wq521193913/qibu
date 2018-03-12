package com.broker.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	/**
	 * @author: Administrator
	 * @description:
	 * @param:  dateStr
	 * @return: java.util.Date
	 * @date: Create in 2018/3/11 0011 上午 10:48
	 * @modified:
	 */
	public static Date convertDate(String dateStr) throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = df.parse(dateStr);
		return date;
	}

	/**
	 * 格式化日期
	 * @param formater
	 * @param date
	 * @return
	 * @author wanqing
	 * @date 2016/10/21 0021 10:56
	*/
	public static String getFormatDate(String formater, Date date) throws ParseException{
		if(null == formater || null == date) return null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formater);
		String resultDate = simpleDateFormat.format(date);
		return resultDate;
	}

	/**
	 * 格式化日期
	 * @param formater
	 * @return
	 * @author wanqing
	 * @date 2016/10/21 0021 10:56
	 */
	public static String getFormatDateNow(String formater) throws ParseException{
		if(null == formater) return null;
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formater);
		String resultDate = simpleDateFormat.format(date);
		return resultDate;
	}

	public static String getYMDDate(Date date) throws ParseException{
		return DateTimeUtil.getFormatDate("yyyy-MM-dd",date);
	}
	public static String getYMDHMDate(Date date) throws ParseException{
		return DateTimeUtil.getFormatDate("yyyy-MM-dd HH:mm",date);
	}
	public static String getYMDHMSDate(Date date) throws ParseException{
		if(null == date) return null;
		return DateTimeUtil.getFormatDate("yyyy-MM-dd HH:mm:ss",date);
	}
}
