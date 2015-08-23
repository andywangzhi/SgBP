package com.gzepro.internal.query.common.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class DateUtil {
	
	/**
	 * 按照默认formatStr的格式，转化dateTimeStr为Date类型 dateTimeStr必须是formatStr的形式
	 * @param dateTimeStr
	 * @param formatStr
	 * @return
	 */
	public static Date getDate(String dateTimeStr, String formatStr) {
		try {
			if (dateTimeStr == null || dateTimeStr.equals("")) {
				return null;
			}
			DateFormat sdf = new SimpleDateFormat(formatStr);
			java.util.Date d = sdf.parse(dateTimeStr);
			return d;
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将YYYYMMDD转换成Date日期
	 * @param date
	 * @return
	 * @throws BusinessException
	 */
	public static Date transferDate(String date) throws Exception {
		if (date == null || date.length() < 1)
			return null;

		if (date.length() != 8)
			throw new Exception("日期格式错误");
		String con = "-";

		String yyyy = date.substring(0, 4);
		String mm = date.substring(4, 6);
		String dd = date.substring(6, 8);

		int month = Integer.parseInt(mm);
		int day = Integer.parseInt(dd);
		if (month < 1 || month > 12 || day < 1 || day > 31)
			throw new Exception("日期格式错误");

		String str = yyyy + con + mm + con + dd;
		return DateUtil.getDate(str, "yyyy-MM-dd");
	}

	/**
	 * 将YYYY－MM－DD日期转换成yyyymmdd格式字符串
	 * @param date
	 * @return
	 */
	public static String getYYYYMMDDDate(Date date) {
		if (date == null)
			return null;
		String yyyy = getYear(date) + "";
		String mm = getMonth(date) + "";
		String dd = getDay(date) + "";
		mm = rightAlign(mm, 2, "0");
		dd = rightAlign(dd, 2, "0");
		return yyyy + mm + dd;
	}

	/**
	 * 将YYYY－MM－DD日期转换成YYYYMMDDHHMMSS格式字符串
	 * @param date
	 * @return
	 */
	public static String getYYYYMMDDHHMMSSDate(Date date) {
		if (date == null)
			return null;
		String yyyy = getYear(date) + "";
		String mm = getMonth(date) + "";
		String dd = getDay(date) + "";
		String hh = getHour(date) + "";
		String min = getMin(date) + "";
		String ss = getSecond(date) + "";

		mm = rightAlign(mm, 2, "0");
		dd = rightAlign(dd, 2, "0");
		hh = rightAlign(hh, 2, "0");
		min = rightAlign(min, 2, "0");
		ss = rightAlign(ss, 2, "0");

		return yyyy + mm + dd + hh + min + ss;
	}

	/**
	 * 将YYYY－MM－DD日期转换成yyyymmdd格式字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getYYYYMMDDDate(String date) {
		return getYYYYMMDDDate(getDate(date, "yyyy-MM-dd"));
	}

	/**
	 * 将MM－DD－YYYY日期转换成yyyymmdd格式字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getYYYYMMDDDate1(String date) {
		String[] dt=date.split("/");
		return dt[2]+(dt[0].length()>1?dt[0]:"0"+dt[0])+(dt[1].length()>1?dt[1]:"0"+dt[1]);
	}
	
	/**
	 * 将Date转换成formatStr格式的字符串
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String dateToDateString(Date date, String formatStr) {
		DateFormat df = new SimpleDateFormat(formatStr);
		return df.format(date);
	}

	/**
	 * 返回一个formatStr格式的日期时间字符串中的HH:mm:ss
	 * @param dateTime
	 * @param formatStr
	 * @return
	 */
	public static String getTimeString(String dateTime, String formatStr) {
		Date d = getDate(dateTime, formatStr);
		String s = dateToDateString(d,"yyyy-MM-dd HH:mm:ss");
		return s.substring("yyyy-MM-dd HH:mm:ss".indexOf('H'));
	}

	/**
	 * 获取当前日期yyyy-MM-dd的形式
	 * 
	 * @return
	 */
	public static String getCurDate() {
		return dateToDateString(Calendar.getInstance().getTime(),"yyyy-MM-dd");
	}

	/**
	 * 获取当前日期yyyy年MM月dd日的形式
	 * @return
	 */
	public static String getCurZhCNDate() {
		return dateToDateString(new Date(), "yyyy年MM月dd日");
	}

	/**
	 * 获取当前日期时间yyyy-MM-dd HH:mm:ss的形式
	 * 
	 * @return
	 */
	public static String getCurDateTime() {
		return dateToDateString(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取当前日期时间yyyy年MM月dd日HH时mm分ss秒的形式
	 * 
	 * @return
	 */
	public static String getCurZhCNDateTime() {
		return dateToDateString(new Date(), "yyyy年MM月dd日HH时mm分ss秒");
	}

	/**
	 * 获取日期d的days天后的一个Date
	 * @param d
	 * @param days
	 * @return
	 */
	public static Date getInternalDateByDay(Date d, int days) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.DATE, days);
		return now.getTime();
	}
    /**
     * 
     * @param d
     * @param months
     * @return
     */
	public static Date getInternalDateByMon(Date d, int months) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.MONTH, months);
		return now.getTime();
	}
    /**
     * 
     * @param d
     * @param years
     * @return
     */
	public static Date getInternalDateByYear(Date d, int years) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.YEAR, years);
		return now.getTime();
	}
    /**
     * 
     * @param d
     * @param sec
     * @return
     */
	public static Date getInternalDateBySec(Date d, int sec) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.SECOND, sec);
		return now.getTime();
	}
    /**
     * 
     * @param d
     * @param min
     * @return
     */
	public static Date getInternalDateByMin(Date d, int min) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.MINUTE, min);
		return now.getTime();
	}
    /**
     * 
     * @param d
     * @param hours
     * @return
     */
	public static Date getInternalDateByHour(Date d, int hours) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.HOUR_OF_DAY, hours);
		return now.getTime();
	}

	/**
	 * 根据一个日期字符串，返回日期格式，目前支持4种 如果都不是，则返回null
	 * 
	 * @param DateString
	 * @return
	 */
	public static String getFormateStr(String DateString) {
		String patternStr1 = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}"; // "yyyy-MM-dd"
		String patternStr2 = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}\\s[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}"; // "yyyy-MM-dd

		String patternStr3 = "[0-9]{4}年[0-9]{1,2}月[0-9]{1,2}日";// "yyyy年MM月dd日"
		String patternStr4 = "[0-9]{4}年[0-9]{1,2}月[0-9]{1,2}日[0-9]{1,2}时[0-9]{1,2}分[0-9]{1,2}秒";// "yyyy年MM月dd日HH时mm分ss秒"

		Pattern p = Pattern.compile(patternStr1);
		Matcher m = p.matcher(DateString);
		boolean b = m.matches();
		if (b)
			return "yyyy-MM-dd";
		p = Pattern.compile(patternStr2);
		m = p.matcher(DateString);
		b = m.matches();
		if (b)
			return "yyyy-MM-dd HH:mm:ss";

		p = Pattern.compile(patternStr3);
		m = p.matcher(DateString);
		b = m.matches();
		if (b)
			return "yyyy年MM月dd日";

		p = Pattern.compile(patternStr4);
		m = p.matcher(DateString);
		b = m.matches();
		if (b)
			return "yyyy年MM月dd日HH时mm分ss秒";
		return null;
	}

	/**
	 * 将一个"yyyy-MM-dd HH:mm:ss"字符串，转换成"yyyy年MM月dd日HH时mm分ss秒"的字符串
	 * @param dateStr
	 * @return
	 */
	public static String getZhCNDateTime(String dateStr) {
		Date d = getDate(dateStr,"yyyy-MM-dd HH:mm:ss");
		return dateToDateString(d, "yyyy年MM月dd日HH时mm分ss秒");
	}

	/**
	 * 将一个"yyyy-MM-dd"字符串，转换成"yyyy年MM月dd日"的字符串
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getZhCNDate(String dateStr) {
		Date d = getDate(dateStr,"yyyy-MM-dd");
		return dateToDateString(d, "yyyy年MM月dd日");
	}

	/**
	 * 将dateStr从fmtFrom转换到fmtTo的格式
	 * 
	 * @param dateStr
	 * @param fmtFrom
	 * @param fmtTo
	 * @return
	 */
	public static String getDateStr(String dateStr, String fmtFrom, String fmtTo) {
		Date d = getDate(dateStr, fmtFrom);
		return dateToDateString(d, fmtTo);
	}

	/**
	 * 比较两个"yyyy-MM-dd HH:mm:ss"格式的日期，之间相差多少毫秒,time2-time1
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static long compareDateStr(String time1, String time2) {
		Date d1 = getDate(time1,"yyyy-MM-dd HH:mm:ss");
		Date d2 = getDate(time2,"yyyy-MM-dd HH:mm:ss");
		return d2.getTime() - d1.getTime();
	}

	/**
	 * 将小时数换算成返回以毫秒为单位的时间
	 * @param hours
	 * @return
	 */
	public static long getMicroSec(BigDecimal hours) {
		BigDecimal bd;
		bd = hours.multiply(new BigDecimal(3600 * 1000));
		return bd.longValue();
	}

	/**
	 * 获取Date中的分钟
	 * @param d
	 * @return
	 */
	public static int getMin(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.MINUTE);
	}

	/**
	 * 获取Date中的小时(24小时)
	 * @param d
	 * @return
	 */
	public static int getHour(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取Date中的秒
	 * @param d
	 * @return
	 */
	public static int getSecond(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.SECOND);
	}

	/**
	 * 获取xxxx-xx-xx的日
	 * @param d
	 * @return
	 */
	public static int getDay(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取月份，1-12月
	 * 
	 * @param d
	 * @return
	 */
	public static int getMonth(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取19xx,20xx形式的年
	 * @param d
	 * @return
	 */
	public static int getYear(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.YEAR);
	}

	/**
	 * 得到d的上个月的年份+月份,如201005
	 * @param d
	 * @return
	 */
	public static String getYearMonthOfLastMon(Date d) {
		Date newdate = getInternalDateByMon(d, -1);
		String year = String.valueOf(getYear(newdate));
		String month = String.valueOf(getMonth(newdate));
		return year + month;
	}

	/**
	 * 得到当前日期的年和月如200509
	 * @return String
	 */
	public static String getCurYearMonth() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		String DATE_FORMAT = "yyyyMM";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}
    /**
     * 
     * @param year
     * @param month
     * @return
     */
	public static Date getNextMonth(String year, String month) {
		String datestr = year + "-" + month + "-01";
		Date date = getDate(datestr, "yyyy-MM-dd");
		return getInternalDateByMon(date, 1);
	}
    /**
     * 
     * @param year
     * @param month
     * @return
     */
	public static Date getLastMonth(String year, String month) {
		String datestr = year + "-" + month + "-01";
		Date date = getDate(datestr, "yyyy-MM-dd");
		return getInternalDateByMon(date, -1);
	}
	
	/**
	 * @function:返回格式'yyyy-MM-dd'的系统当前日期。
	 * @retinfo:String，格式为'yyyy-MM-dd'的系统当前日期。
	 * @throws java.lang.Exception
	 */
	public static String getSystemDate() throws Exception {
		Date dateSystem = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(dateSystem);
	}
	
	/**
	 * @function:返回格式'yyyy-MM-dd HH:mm:ss.SSS'的系统当前日期。
	 * @retinfo:String，格式为'yyyy-MM-dd HH:mm:ss.SSS'的系统当前日期。
	 * @throws java.lang.Exception
	 */
	public static String getSystemDateTime() throws Exception {
		Date dateSystem = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return sdf.format(dateSystem);
	}

	/**
	 * 得到日期d，按照页面日期控件格式，如"2001-3-16"
	 * 
	 * @param d
	 * @return
	 */
	public static String getSingleNumDate(Date d) {
		return dateToDateString(d, "yyyy-MM-dd");
	}

	/**
	 * 得到d半年前的日期,"yyyy-MM-dd"
	 * 
	 * @param d
	 * @return
	 */
	public static String getHalfYearBeforeStr(Date d) {
		return dateToDateString(getInternalDateByMon(d, -6), "yyyy-MM-dd");
	}

	/**
	 * 得到当前日期D的月底的前/后若干天的时间,<0表示之前，>0表示之后
	 * 
	 * @param d
	 * @param days
	 * @return
	 */
	public static String getInternalDateByLastDay(Date d, int days) {

		return dateToDateString(getInternalDateByDay(d, days), "yyyy-MM-dd");
	}

	/**
	 * 日期中的年月日相加
	 * @param field int 需要加的字段 年 月 日
	 * @param amount int 加多少
	 * @return String
	 */
	public static String addDate(int field, int amount) {
		int temp = 0;
		if (field == 1) {
			temp = Calendar.YEAR;
		}
		if (field == 2) {
			temp = Calendar.MONTH;
		}
		if (field == 3) {
			temp = Calendar.DATE;
		}
		String Time = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance(TimeZone.getDefault());
			cal.add(temp, amount);
			Time = sdf.format(cal.getTime());
			return Time;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获得系统当前月份的天数
	 * 
	 * @return
	 */
	public static int getCurentMonthDay() {
		Date date = Calendar.getInstance().getTime();
		return getMonthDay(date);
	}

	/**
	 * 获得指定日期月份的天数
	 * @param date
	 * @return
	 */
	public static int getMonthDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获得指定日期月份的天数 yyyy-mm-dd
	 * @param date
	 * @return
	 */
	public static int getMonthDay(String date) {
		Date strDate = getDate(date, "yyyy-MM-dd");
		return getMonthDay(strDate);
	}
    
	/**
	 * 
	 * @param cal
	 * @return
	 */
	public static String getStringDate(Calendar cal) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(cal.getTime());
	}

	/**
	 * 
	 * @param source
	 * @param length
	 * @param fit
	 * @return
	 */
	public static String rightAlign(String source, int length, String fit) {
		String result = "";
		int div = length - source.length();
		String tmp = "";
		if (div > 0) {
			for (int i = 0; i < div; i++) {
				tmp += fit;
			}
		}
		result = tmp + source;
		return result;
	}

    /**
	 * 转换日期
	 * @param date
	 * @return
	 */
	public static Calendar getCalendar(String date,String formatStr){
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		Calendar cld = Calendar.getInstance();
		try {
			cld.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cld;
	}
	
	/**
	 * 转换日期
	 * @param date
	 * @return
	 */
	public static String calendarToString(Calendar cal,String formatStr){
		if(cal==null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		String dateStr="";
		try {
		     dateStr = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateStr;
	}
	
	/**
	 * 在dto对象中把int转为Date
	 * @param intDate
	 * @param formatStr
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateFormInt(int intDate , String formatStr) throws ParseException{
		
		if(intDate == 0){  //该日期为null
			return null;
		}
		
		String dateStr = String.valueOf(intDate);
		if(formatStr .equals("yyyy-MM-dd") && dateStr.length()>=8){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			return format.parse(yyyy+"-"+MM+"-"+dd);
		}else if(formatStr .equals("MM/dd/yyyy") && dateStr.length()>=8){
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			return format.parse(MM+"/"+dd+"/"+yyyy);
		}
		return null;
	}
	
	 /**
     * 把yyyyMMdd格式的整型日期转换为Date类型的日期
     * @author hechuan
     * @param dateInt
     * @return
     */
    public static Date getYYYYMMddDateFromInt(int dateInt){
        if(dateInt==0)return null;
        return DateUtil.getDate(dateInt+"", "yyyyMMdd");
    }
	
	/**
	 * 在dto对象中把int转为字符窜格式的日期
	 * @param intDate  格式为 ：yyyyMMdd 的数字串
	 * @param formatStr
	 * @return
	 * @throws ParseException
	 */
	public static String getDateStringFormInt(int intDate , String formatStr) throws ParseException{
		
		if(intDate == 0){  //该日期为null
			return "";
		}
		
		String dateStr = String.valueOf(intDate);
		if(formatStr .equals("yyyy-MM-dd") && dateStr.length()>=8){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			return yyyy+"-"+MM+"-"+dd;
		}else if(formatStr .equals("yyyy/MM/dd") && dateStr.length()>=8){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			return yyyy+"/"+MM+"/"+dd;
		}else if(formatStr .equals("yyyy-MM") && dateStr.length()>=6){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			return yyyy+"-"+MM;
		}else if(formatStr .equals("yyyy年MM月dd日") && dateStr.length()>=8){
			return DateUtil.getDateStr(intDate+"", "yyyyMMdd", formatStr);
		}else if(formatStr .equals("dd/MM/yyyy") && dateStr.length()>=8){
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			return dd+"/"+MM+"/"+yyyy;
		}else if(formatStr .equals("MM/dd/yyyy") && dateStr.length()>=8){
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			return MM+"/"+dd+"/"+yyyy;
		}else if(formatStr .equals("yyyy年MM月") && dateStr.length()>=6){
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			return yyyy+"年"+MM+"月";
		}
		//2011-08-25hechuan修改
		else if(formatStr .equals("MM/yyyy") && dateStr.length()>=6){
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			return MM+"/"+yyyy;
		}
		return null;
	}
	
	/**
	 * 在dto对象中把long转为字符窜格式的日期
	 * @param longDate 格式为 ：yyyyMMdd HH:mm:ss 的long
	 * @param formatStr
	 * @return
	 * @throws ParseException
	 */
	public static String getDateStringFormLong(Long longDate , String formatStr) throws ParseException{
		

		if(longDate == 0){  //该日期为null
			return "";
		}
		
		String dateStr = String.valueOf(longDate);
		if(formatStr .equals("yyyy-MM-dd HH:mm:ss") && dateStr.length()>=14){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			
			String HH = dateStr.substring(8,10);
			String mm = dateStr.substring(10,12);
			String ss = dateStr.substring(12,14);
			return yyyy +"-"+ MM +"-"+ dd +" "+ HH +":"+ mm +":"+ ss;
		}else if(formatStr .equals("MM/dd/yyyyHH:mm:ss") && dateStr.length()>=14){
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			
			String HH = dateStr.substring(8,10);
			String mm = dateStr.substring(10,12);
			String ss = dateStr.substring(12,14);
			return  MM +"/"+yyyy+"/"+ dd + HH +":"+ mm +":"+ ss;
		}else if(formatStr .equals("MM/dd/yyyy HH:mm:ss") && dateStr.length()>=14){
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			
			String HH = dateStr.substring(8,10);
			String mm = dateStr.substring(10,12);
			String ss = dateStr.substring(12,14);
			return  MM +"/"+ dd +"/"+yyyy+" "+ HH +":"+ mm +":"+ ss;
		}else if(formatStr .equals("yyyy-MM-dd") && dateStr.length()>=8){
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			return yyyy+"-"+MM+"-"+dd;
		}else if(formatStr .equals("yyyy/MM/dd") && dateStr.length()>=8){
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			return yyyy+"/"+MM+"/"+dd;
		}
		//2011-08-25hechuan修改
		else if(formatStr .equals("MM/dd/yyyy") && dateStr.length()>=8){
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			return MM+"/"+dd+"/"+yyyy;
		}else if(formatStr .equals("yyyy-MM") && dateStr.length()>=6){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			return yyyy+"-"+MM;
		}
		//2011-08-25hechuan修改
		else if(formatStr .equals("MM/yyyy") && dateStr.length()>=6){
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			return MM+"/"+yyyy;
		}else if(formatStr .equals("yyyy-MM-dd HH:mm:ss SSS") && dateStr.length()>=17){
			return DateUtil.getDateStr(longDate+"", "yyyyMMddhhmmssSSS", formatStr);
		}else if(formatStr .equals("HH:mm:ss") && dateStr.length()>=14){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String HH = dateStr.substring(8,10);
			String mm = dateStr.substring(10,12);
			String ss = dateStr.substring(12,14);
			return HH+":"+mm+":"+ss;
		}else if(formatStr .equals("yyyy年MM月dd日 hh时") && dateStr.length()>=10){
			return DateUtil.getDateStr(longDate+"", "yyyyMMddhhmmssSSS", formatStr);
		}else if(formatStr .equals("yyyy-MM-dd HH") && dateStr.length()>=10){
			return DateUtil.getDateStr(longDate+"", "yyyyMMddhhmmssSSS", formatStr);
		}
		//2011-08-25hechuan修改
		else if(formatStr .equals("MM/dd/yyyy HH") && dateStr.length()>=10){
			return DateUtil.getDateStr(longDate+"", "yyyyMMddhhmmssSSS", formatStr);
		}
		return null;
	}
	
	
	/**
	 * 根据输入返回年月
	 * @param input
	 * @return
	 */
	public static String getYearMonth(String input){
		String[] tmp = input.split("-");
		String year = tmp[0];
		String month = tmp[1];
		
		if(month.length()==1 && Integer.parseInt(month) <= 9){
			month = "0"+month;
		}
		return year+month;
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static String getChinesDateStr(Object input){
		
		String dateStr="";
		String a = input.getClass().getName();
		if(input.getClass().getName().indexOf("java.lang.Integer") != -1){
			dateStr = String.valueOf(input);
		}else{
			dateStr = input.toString();
		}
		
		
		if (dateStr.length() == 6){
			return  dateStr.substring(0,4)+"年"+dateStr.substring(4,6)+"月";
		}else if(dateStr.length() == 8){
			return  dateStr.substring(0,4)+"年"+dateStr.substring(4,6)+"月"+dateStr.substring(6,8)+"日";
		}
		
		return "";
	}
	
	
	
	/**日期比较
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compare_date(String DATE1, String DATE2) {
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        Date dt1 = df.parse(DATE1);
	        Date dt2 = df.parse(DATE2);
	        if (dt1.getTime() > dt2.getTime()) {
	            return 1;
	        } else if (dt1.getTime() < dt2.getTime()) {
	            return -1;
	        } else {
	            return 0;
	        }
	    } catch (Exception exception) {
	        exception.printStackTrace();
	    }
	    return 0;
	}
	
	/**
	 * 根据当前时间获取时间控件开始时间(当前财年开始月份)
	 * @return
	 */
	public static String getDateFildBegin(){
		String beginMonth = "";
		
		Date todayDate=DateUtil.getDate(DateUtil.getCurDate(), "yyyy-MM");
		int bYYYY = DateUtil.getYear(todayDate);
		int bMM = DateUtil.getMonth(todayDate);
		int bDD = DateUtil.getDay(todayDate);
		
		if(bMM <=8)  {
			bYYYY = bYYYY-1;
			beginMonth= bYYYY + "-09";
		}else{
			beginMonth= bYYYY + "-09";
		}
		
		return beginMonth;
	}
	
	/**
	 * 根据当前时间获取时间控件结束时间(当前月份)
	 * @return
	 */
	public static String getDateFildEnd(){
		String endMonth = "";
		
		Date todayDate = DateUtil.getDate(DateUtil.getCurDate(), "yyyy-MM");
		int eYYYY = DateUtil.getYear(todayDate);
		int eMM = DateUtil.getMonth(todayDate);
		
		if(eMM <=9)  {
			
			endMonth= eYYYY + "-0"+eMM;
		}else{
			endMonth= eYYYY +"-"+ eMM;
		}
		
		return endMonth;
	}
	
	/**
	 * 退货查询的开始月份默认值(当前月份的前3个月)
	 * @return
	 */
	public static String getRtrDateFildBegin(){
		String beginMonth = "";
		
		Date todayDate = DateUtil.getDate(DateUtil.getCurDate(), "yyyy-MM");
		int bYYYY = DateUtil.getYear(todayDate);
		int bMM = DateUtil.getMonth(todayDate);
		
		if( (bMM-2)< 0 || (bMM-2) ==0 ){     //若果不输入,查询区间默认为当前月份的前三个月
			bYYYY = bYYYY-1;
			bMM = (bMM-2)+12;
			beginMonth = bYYYY+"-"+bMM;
		}else if ((bMM-2)>9){
			beginMonth = bYYYY+"-"+(bMM-2);
		}else{
			beginMonth = bYYYY+"-0"+(bMM-2);
		}
		
		return beginMonth;
	}
	
	
	/**
	 * 把string的date 转为相应格式
	 * @param dateStr
	 * @param formatStr
	 * @return
	 */
	public  static String changeDateStr(String dateStr ,String formatStr){
		if(formatStr .equals("yyyy-MM-dd HH:mm:ss") && dateStr.length()>=14){
			
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			
			String HH = dateStr.substring(8,10);
			String mm = dateStr.substring(10,12);
			String ss = dateStr.substring(12,14);
			return yyyy +"-"+ MM +"-"+ dd +" "+ HH +":"+ mm +":"+ ss;
		}else if(formatStr .equals("yyyy-MM-dd") && dateStr.length()>=8){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			return yyyy+"-"+MM+"-"+dd;
		}else if(formatStr .equals("MM/dd/yyyy") && dateStr.length()>=8){
			String yyyy = dateStr.substring(0,4);
			String MM = dateStr.substring(4,6);
			String dd = dateStr.substring(6,8);
			return MM +"/"+ dd +"/"+ yyyy;
		}
		return "";
	}

	

}
