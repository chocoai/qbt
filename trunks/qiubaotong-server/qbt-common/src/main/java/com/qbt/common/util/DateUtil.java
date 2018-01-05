package com.qbt.common.util;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateUtil {

	public static final String DATE_TIME_FORMAT_01 = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_TIME_FORMAT_02 = "yyyy-MM-dd HH:mm:00";
	public static final String DATE_TIME_FORMAT_03 = "yyyy年MM月dd日 HH时mm分";
	public static final String DATE_TIME_FORMAT_04 = "yyyy-MM-dd HH:mm";
	public static final String DATE_TIME_FORMAT_05 = "yyyyMMddHHmmss";
	public static final String DATE_TIME_FORMAT_06 = "yyyy年MM月dd日 HH时mm分ss秒";
	public static final String DATE_FORMAT_01 = "yyyy-MM-dd";
	public static final String DATE_FORMAT_02 = "yyyy年MM月dd日";
	public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
	public static final String DATE_FORMAT_YYMMDD = "yyMMdd";
	private static final SimpleDateFormat format_date = new SimpleDateFormat(DATE_FORMAT_01);
	private static final SimpleDateFormat format_date_time = new SimpleDateFormat(DATE_TIME_FORMAT_01);

	public static String snPrefix() {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		return df.format(Calendar.getInstance().getTime());
	}

	public static Date makeUpTime() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -5);
		return cal.getTime();
	}

	/**
	 * 格式化日期时间
	 * 
	 * @return
	 */
	public static String formatDateTime(Date date) {
		return format_date_time.format(date);
	}

	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static String formatDate(Date date) {
		return format_date.format(date);
	}

	/**
	 * 取当前日期时间
	 * 
	 * @return
	 */
	public static String getCurrentDateTime() {
		return format_date_time.format(new Date());
	}

	/**
	 * 取当前日期
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		return format_date.format(new Date());
	}

	/**
	 * @param startDate
	 *            开始日期时间
	 * @param endDate
	 *            结束日期时间
	 * @return 获取日期天数
	 */
	public static long getDiffDays(Date startDate, Date endDate) {
		try {
			long diff = endDate.getTime() - startDate.getTime();
			long days = diff / (1000 * 60 * 60 * 24);
			return days;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * @param startDate
	 *            开始日期时间
	 * @param endDate
	 *            结束日期时间
	 * @return 获取日期天数
	 */
	public static long getDiffDaysForDay(Date startDate, Date endDate) {
		try {
			startDate = DateUtil.str2Date(DateUtil.formatDate(startDate, DateUtil.DATE_FORMAT_01),
					DateUtil.DATE_FORMAT_01);
			endDate = DateUtil.str2Date(DateUtil.formatDate(endDate, DateUtil.DATE_FORMAT_01), DateUtil.DATE_FORMAT_01);
			long diff = endDate.getTime() - startDate.getTime();
			long days = diff / (1000 * 60 * 60 * 24);
			return days;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 获取周几
	 * 
	 * @Title: getWeekDay
	 * @Description: TODO
	 * @author: share 2016年8月15日
	 * @modify: share 2016年8月15日
	 * @return
	 */
	public static String getWeekDay() {
		DateFormatSymbols symboles = new DateFormatSymbols(Locale.getDefault());
		symboles.setShortWeekdays(new String[] { "", "7", "1", "2", "3", "4", "5", "6" });
		SimpleDateFormat date = new SimpleDateFormat("E", symboles);
		return date.format(new Date());
	}

	public static long getDiffDays2(Date startDate, Date endDate) {
		try {

			long diff = endDate.getTime() - startDate.getTime();
			long days = diff / (999 * 60 * 60 * 24);
			return days;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public static String getCurrentDayStartTime(int weightValue, boolean showTime) {
		Calendar clr = Calendar.getInstance();
		clr.setTime(new Date());
		clr.add(Calendar.DATE, weightValue);
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		if (showTime) {
			return shortSdf.format(clr.getTime()) + " 00:00:00";
		} else {
			return shortSdf.format(clr.getTime());
		}

	}

	public static String getCurrentDayEndTime(int weightValue, boolean showTime) {
		Calendar clr = Calendar.getInstance();
		clr.setTime(new Date());
		clr.add(Calendar.DATE, weightValue);
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		if (showTime) {
			return shortSdf.format(clr.getTime()) + " 23:59:59";
		} else {
			return shortSdf.format(clr.getTime());
		}

	}

	public static Date getPointDate(int weightValue) {
		Calendar clr = Calendar.getInstance();
		clr.setTime(new Date());
		clr.add(Calendar.DATE, weightValue);
		return clr.getTime();
	}

	/**
	 * 字符串yyyy-MM-dd转换到Date类型
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd
	 * @return Date
	 */
	public static Date strDate2Date(String dateStr) {
		return str2Date(dateStr, DATE_FORMAT_01);
	}

	/**
	 * 字符串转换到Date类型
	 * 
	 * @param dateStr
	 *            需要转换的字符串
	 * @param format
	 *            转换格式
	 * @return Date
	 */
	public static Date str2Date(String dateStr, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		Date date = dateFormat.parse(dateStr, new ParsePosition(0));
		return date;
	}

	/**
	 * @param dt
	 *            Date日期类型
	 * @param fmtDate
	 *            格式样式，如：yyyy-MM-dd HH:mm:ss
	 * @return 自定义格式
	 */
	public static String formatDate(java.util.Date dt, String fmtDate) {
		if (dt != null) {
			return (new SimpleDateFormat(fmtDate)).format(dt);
		}
		return null;
	}

	/**
	 * 时间转日期
	 * 
	 * @param timeStr
	 * @return
	 */
	public static String timeConvertDate(String timeStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_01);
		dateFormat.setLenient(false);
		Date date = dateFormat.parse(timeStr, new ParsePosition(0));
		return dateFormat.format(date);
	}

	/**
	 * 获取时间段内所有的日期集合
	 * 
	 * @param dBegin
	 * @param dEnd
	 * @return
	 */
	public static List<Date> findDates(Date dBegin, Date dEnd) {
		List<Date> lDate = new ArrayList<Date>();
		lDate.add(dBegin);
		Calendar calBegin = Calendar.getInstance();
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(dEnd);
		while (dEnd.after(calBegin.getTime())) {
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			lDate.add(calBegin.getTime());
		}
		return lDate;
	}

	/**
	 * 日期加减计算
	 * 
	 * @param date
	 *            日期字符串，格式yyyy_MM_dd
	 * @param day
	 *            正为加负为减
	 * @return 日期字符串
	 */
	public static String dateStrCalculate(String date, int day) {
		Calendar nowCalender = str2Calendar(date, DATE_FORMAT_01);
		nowCalender.add(Calendar.DAY_OF_MONTH, day);
		return formatDate(nowCalender.getTime(), DATE_FORMAT_01);
	}

	/**
	 * 字符串转换到Calendar类型
	 * 
	 * @param dateStr
	 *            需要转换的字符串
	 * @param format
	 *            转换格式
	 * @return Calendar
	 */
	public static Calendar str2Calendar(String dateStr, String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(str2Date(dateStr, format));
		return calendar;
	}

	public static String dateCalculate(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return formatDate(calendar.getTime(), DATE_FORMAT_01);
	}

	public static Date getTimeByPointParams(Date date, Integer year, Integer month, Integer day, Integer hour,
			Integer minute, Integer second) {
		Calendar calendar = Calendar.getInstance();
		if (date == null) {
			calendar.setTime(new Date());
		} else {
			calendar.setTime(date);
		}
		if (year != null) {
			calendar.set(Calendar.YEAR, year);
		}
		if (month != null) {
			calendar.set(Calendar.MONTH, month - 1);
		}
		if (day != null) {
			calendar.set(Calendar.DAY_OF_MONTH, day);
		}
		if (hour != null) {
			calendar.set(Calendar.HOUR_OF_DAY, hour);
		}
		if (minute != null) {
			calendar.set(Calendar.MINUTE, minute);
		}
		if (second != null) {
			calendar.set(Calendar.SECOND, second);
		}
		return calendar.getTime();
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @return 对比 startDate > endDate 为true 否为false
	 */
	public static boolean compareDate(Date startDate, Date endDate) {
		if (startDate.compareTo(endDate) == 0) {
			return false;
		} else {
			if (startDate.after(endDate)) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @return 对比 startDate > endDate 为true 否为false
	 */
	public static boolean compareDate(String startDate, String endDate, String formatDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
		Date d1 = null;
		Date d2 = null;

		try {
			d1 = sdf.parse(startDate);
			d2 = sdf.parse(endDate);
			return compareDate(d1, d2);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @return 对比 startDate > endDate 为true 否为false
	 */
	public static boolean compareDate(Date startDate, String endDate, String formatDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
		Date d2 = null;

		try {
			d2 = sdf.parse(endDate);
			return compareDate(startDate, d2);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @return 对比 startDate > endDate 为true 否为false
	 */
	public static boolean compareDate(String startDate, Date endDate, String formatDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
		Date d1 = null;
		try {
			d1 = sdf.parse(startDate);
			return compareDate(d1, endDate);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param startDate
	 *            开始日期时间
	 * @param endDate
	 *            结束日期时间
	 * @return 获取日期天数
	 */
	public static long getDiffDay(Date startDate, Date endDate) {
		try {
			long diff = endDate.getTime() - startDate.getTime();
			long days = diff / (1000 * 60 * 60 * 24);
			return days;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @param startDate
	 *            开始日期时间
	 * @param endDate
	 *            结束日期时间
	 * @return 获取日期天数
	 */
	public static long getDiffDay(String startDate, String endDate, String formatPattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
		try {
			Date start = sdf.parse(startDate);
			Date end = sdf.parse(endDate);
			return getDiffDay(start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * @param startDate
	 *            开始日期时间
	 * @param endDate
	 *            结束日期时间
	 * @return 获取两个日期时间的秒数差值
	 */
	public static long getDiffSecond(Date startDate, Date endDate) {
		try {
			long diff = endDate.getTime() - startDate.getTime();
			long days = diff / 1000;
			return days;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @param startDate
	 *            开始日期时间
	 * @param endDate
	 *            结束日期时间
	 * @return 获取两个日期时间的秒数差值
	 */
	public static long getDiffSecond(String startDate, String endDate, String formatPattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
		try {
			Date start = sdf.parse(startDate);
			Date end = sdf.parse(endDate);
			return getDiffSecond(start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public static Date calDateOfSecond(int seconds) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, seconds);
		return cal.getTime();
	}
	
	public static Date calDateOfSecond(Date date, int seconds) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, seconds);
		return cal.getTime();
	}
	
	public static String calDateOfSecond(Date date, int seconds, String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, seconds);
		return formatDate(cal.getTime(), format);
	}
	
	public static String calDateOfSecond(String dateStr, int seconds, String format) {
		Date date = str2Date(dateStr, format);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, seconds);
		return formatDate(cal.getTime(), format);
	}

	public static Date calDateOfMinute(int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

	public static Date calDateOfHour(int hours) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, hours);
		return cal.getTime();
	}

	public static Date calDateOfDay(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}

	public static Date calDateOfDay(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}

	public static Date calDateOfMonth(int month) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}

	/**
	 * 功能描述：返回小
	 *
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能描述：返回分
	 *
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}
	
	/**
	 * 功能描述：返回秒
	 *
	 * @param date
	 *            日期
	 * @return 返回秒
	 */
	public static int getSecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}
	
	/**
	 * 
	 * getWeek:(返回周).
	 *
	 * @author huangyihao
	 * 2017年4月6日 下午3:41:19
	 * @param date
	 * @return 1-7 周日-周六
	 *
	 */
	public static int getWeek(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	public static List<String> getTimes(Date date, Date compareDate) {
		List<String> timeArray = new ArrayList<String>();
		int leftMin = 9;
		int leftMax = 17;
		int rightMin = 11;
		int rightMax = 19;
		long days = getDiffDays(compareDate, date);
		int currHours = DateUtil.getHour(date);
		int minute = DateUtil.getMinute(date);

		if (days < 0)
			return timeArray;
		for (int i = leftMin, k = rightMin; i <= leftMax; i++, k++) {
			if (days == 0) {
				if (currHours + 1 >= i && minute != 0)
					continue;
			}
			if (k > rightMax) {
				k = rightMax;
			}
			String datestr = StringUtil.left_fill(i, 2) + ":00-" + k + ":00";
			timeArray.add(datestr);
		}
		return timeArray;
	}
	
	/**
	 * 
	 * isNight:(判断时间是否17点以后).
	 *
	 * @author huangyihao
	 * 2017年8月18日 下午5:05:20
	 * @param date
	 * @return
	 *
	 */
	public static boolean isNight(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		return 17 <= hour;
	}
	
	/**
	 * 
	 * ajustNight:(调整17点后的日期时间为第二天的9点).
	 *
	 * @author huangyihao
	 * 2017年8月18日 下午5:06:44
	 * @param date
	 * @return
	 *
	 */
	public static Date ajustNight(Date date) {
		if(isNight(date)) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.HOUR_OF_DAY, 9);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			date = calendar.getTime();
		}
		return date;
	}
	
	public static void main(String args[]) {
		Date d1 = str2Date("2017-04-10 18:30:00", DATE_TIME_FORMAT_01);
		System.out.println(DateUtil.ajustNight(d1));
	}
}
