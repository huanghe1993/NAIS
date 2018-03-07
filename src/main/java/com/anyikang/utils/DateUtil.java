/**
 * 
 */
package com.anyikang.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author wangwei
 * @date 2017年4月20日
 */
public class DateUtil {
	private DateUtil(){}
	public static SimpleDateFormat simpleDate = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	/** 年月日的日期格式化 */
	public static String df_YYYY_MM_DD = "yyyy-MM-dd";

	/** 年月的日期格式化 */
	public static String df_yyyy_MM = "yyyy-MM";

	/** 年月日时分秒的日期格式化  */
	public static String df_MM_dd_yyyy_HH_mm_ss_sprit = "MM/dd/yyyy HH:mm:ss";
	/** 年月日时分秒的日期格式化  */
	public static String df_MM_dd_yyyy_sprit = "MM/dd/yyyy";
	
	

	/** 年月日时分秒大写HH表示的是24小时进行限制  */
	public static String df_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

	/** 年月日时分秒大写HH表示的是12小时进行限制 */
	public static String df_yyyy_MM_hh_mm_ss = "yyyy-MM-dd hh:mm:ss";
	

	/** 年月日时分秒大写HH表示的是12小时进行限制 */
	public static String df_yyyy_MM_dd = "yyyy-MM-dd";
	

	/** 年月日时分秒大写HH表示的是12小时进行限制 */
	public static String df_yyyy_MM_hh_mm = "yyyy-MM-dd hh:mm";
	
	
	/** 年月日时分秒大写HH表示的是12小时进行限制  */
	public static String df_yyyy_MM_HH_mm = "yyyy-MM-dd HH:mm";
	
	
	public static String df_yyyyMMddhhmmss="yyyyMMddhhmmss";
	
	public static String df_yyyyMMddHHmmss="yyyyMMddHHmmss";
	
	public static String df_yyyyMMddHHmm="yyyyMMddHHmm";
	public static String dfyyyyMM="yyyyMM";

	/** 小时分钟的格式化方法  */
	public static String df_HH_mm = "HH:mm";
	
	public static String df_hh_mm="hh:mm";
	
	/** 小时分钟的格式化方法  */
	public static String df_HH_mm_ss = "HH:mm:ss";
	public static String df_hh_mm_ss = "hh:mm:ss";
	/**亚洲上海时区*/
	public static DateTimeZone datetime_zone_id=DateTimeZone.forID(buildMap().get("CTT"));
	
	/**
	  * <dl>
	  * <dt><span class="strong">方法说明:</span></dt>
	  * <dd>获取当前时间</dd>
	  * </dl> 
	  * <dl><dt><span class="strong">创建时间:</span></dt>
	  * <dd> 2015年7月31日 上午10:06:36</dd></dl> 
	  * </dl> 
	  * @author su_jian
	  * @param  没有参数
	  * @return String类型的时间
	 */
	public static String getCurrentTimeByString(){
		DateTime dateTime =DateTime.now(datetime_zone_id);
		return dateTime.toString(df_yyyy_MM_dd_HH_mm_ss);
	}
	
	/**
	  * <dl>
	  * <dt><span class="strong">方法说明:</span></dt>
	  * <dd>获取当前时间</dd>
	  * </dl> 
	  * <dl><dt><span class="strong">创建时间:</span></dt>
	  * <dd> 2015年7月31日 上午10:06:36</dd></dl> 
	  * </dl> 
	  * @author su_jian
	  * @param  没有参数
	  * @return Date类型的时间
	 */
	public static Date getCurrentTimeByDate(){
		DateTime dateTime =DateTime.now(datetime_zone_id);
		return dateTime.toDate();
	}
	
	
	/**
	  * <dl>
	  * <dt><span class="strong">方法说明:</span></dt>
	  * <dd>获取当前时间</dd>
	  * </dl> 
	  * <dl><dt><span class="strong">创建时间:</span></dt>
	  * <dd> 2015年7月31日 上午10:06:36</dd></dl> 
	  * </dl> 
	  * @author su_jian
	  * @param  没有参数
	  * @return Date类型的时间
	 */
	public static DateTime getCurrentTimeByDateTime(){
		DateTime dateTime =DateTime.now(datetime_zone_id);
		return dateTime;
	}
	
	
	/**
	  * <dl>
	  * <dt><span class="strong">方法说明:</span></dt>
	  * <dd>获取当前日期没有天数</dd>
	  * </dl> 
	  * <dl><dt><span class="strong">创建时间:</span></dt>
	  * <dd> 2015年7月31日 上午10:06:36</dd></dl> 
	  * </dl> 
	  * @author su_jian
	  * @param  没有参数
	  * @return Date类型的时间
	 */
	public static String getCurrentDay(){
		DateTime dateTime =DateTime.now(datetime_zone_id);
		return dateTime.toString(df_yyyy_MM_dd);
	}
	
	/**
	 * Description: 获取当前日期的几天前日期 yyyy_MM_dd
	 * @param 
	 * @return String
	 * @throws
	 * @Author su_jian
	 * Create Date: 2016年11月30日 上午9:57:44
	 */
	public static String getCurrentDay(Integer num) {
		DateTime d =DateTime.now(datetime_zone_id);
		DateTime dateTimeBefore1 = DateUtil.plusDate(d, 0, 0, num, 0, 0, 0);
		dateTimeBefore1.toString(DateUtil.df_yyyy_MM_dd);
		return dateTimeBefore1.toString(DateUtil.df_yyyy_MM_dd);
	}
	
	/**
	 * Description: 获取当前日期的几天前日期 yyyy_MM_dd
	 * @param 
	 * @return String
	 * @throws
	 * @Author su_jian
	 * Create Date: 2016年11月30日 上午9:57:44
	 */
	public static String getCurrentDay(Integer num,String day) {
		DateTime d =DateTime.parse(day);
		DateTime dateTimeBefore1 = DateUtil.plusDate(d, 0, 0, num, 0, 0, 0);
		dateTimeBefore1.toString(DateUtil.df_yyyy_MM_dd);
		return dateTimeBefore1.toString(DateUtil.df_yyyy_MM_dd);
	}
	
	
	/**
	  * <dl>
	  * <dt><span class="strong">方法说明:</span></dt>
	  * <dd>获取当前日期没有天数</dd>
	  * </dl> 
	  * <dl><dt><span class="strong">创建时间:</span></dt>
	  * <dd> 2015年7月31日 上午10:06:36</dd></dl> 
	  * </dl> 
	  * @author su_jian
	  * @param  没有参数
	  * @return Date类型的时间
	 */
	public static String getCurrentDayDirect(){
		DateTime dateTime =DateTime.now(datetime_zone_id);
		return dateTime.toString(dfyyyyMM);
	}
	
	/**
	  * <dl>
	  * <dt><span class="strong">方法说明:</span></dt>
	  * <dd>获取当前日期没有天数</dd>
	  * </dl> 
	  * <dl><dt><span class="strong">创建时间:</span></dt>
	  * <dd> 2015年7月31日 上午10:06:36</dd></dl> 
	  * </dl> 
	  * @author su_jian
	  * @param  没有参数
	  * @return Date类型的时间
	 */
	public static String getCurrentDayDirect(Date date){
		String xxx=parseDateToString(date, df_yyyy_MM_dd_HH_mm_ss);
		DateTime dateTime =DateUtil.parseStringToDateTime(xxx, df_yyyy_MM_dd_HH_mm_ss);
		return dateTime.toString(dfyyyyMM);
	}
	
	public static String parseDateToString(Date date,String fmt){
		String fmts=df_yyyy_MM_dd_HH_mm_ss;
		if(fmt!=null){
			fmts = fmt;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(fmts);  
		String str=sdf.format(date);  
		return str;
	}
	
	/**
	  * <dl>
	  * <dt><span class="strong">方法说明:</span></dt>
	  * <dd>获取String类型的日期传入格式</dd>
	  * </dl> 
	  * <dl><dt><span class="strong">创建时间:</span></dt>
	  * <dd> 2015年7月31日 上午10:06:36</dd></dl> 
	  * </dl> 
	  * @author su_jian
	  * @param  时间个格式化格式
	  * @return Date类型的时间
	 */
	public static String getDateTimeByStringFmt(String formatter) {
		DateTime dateTime =DateTime.now(datetime_zone_id);
		return dateTime.toString(formatter);
	}
	
	
	/**
	 * @return 获取当前是第几个月
	 */
	public static Integer getDayOfMonth() {
		DateTime dateTime =DateTime.now(datetime_zone_id);
		return dateTime.getDayOfMonth();
	}
	
	/**
	 * @return 获取星期几 
	 */
	public static Integer getDayOfWeek() {
		DateTime dateTime =DateTime.now(datetime_zone_id);
		return dateTime.getDayOfWeek();
	}
	
	/**
	 * @return 一年中的第几天
	 */
	public static Integer getDayOfYear() {
		DateTime dateTime =DateTime.now(datetime_zone_id);
		return dateTime.getDayOfYear();
	}
	
	
	/**
	 * @return 获取当前年
	 */
	public static Integer getYear() {
		DateTime dateTime =DateTime.now(datetime_zone_id);
		return dateTime.getYear();
	}
	
	
	/**
	 * @return 增加年月日时分秒
	 */
	public static DateTime plus(int year,int months,int days,int hours,int minutes,int seconds) {
		DateTime dateTime =DateTime.now(datetime_zone_id);
		return dateTime.plusYears(year).plusMonths(months).plusDays(days)
				.plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
	}
	
	
	/**
	 * @return 增加年月日时分秒 根据当前日期
	 */
	public static DateTime plusDate(DateTime dateTime,int year,int months,int days,int hours,int minutes,int seconds) {
		return dateTime.plusYears(year).plusMonths(months).plusDays(days)
				.plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
	}
	

	/**
	 * @return 将String类型的日期转换成dateTime类型
	 */
	public static DateTime parseStringToDateTime(String date,String fmt) {
		String fmts=df_yyyy_MM_dd_HH_mm_ss;
		if(fmt!=null){
			fmts=fmt;
		}
		DateTimeFormatter format= DateTimeFormat.forPattern(fmts);
		DateTime ss=DateTime.parse(date, format);
		return ss;
	}
	
	
	/**
	 * @return 将String类型的日期转换成date类型
	 */
	public static Date parseStringToDate(String date,String fmt) {
		String fmts=df_yyyy_MM_dd_HH_mm_ss;
		if(fmt!=null){
			fmts=fmt;
		}
		DateTimeFormatter format= DateTimeFormat.forPattern(fmts);
		DateTime ss=DateTime.parse(date, format);
		return ss.toDate();
	}
	
	/**
	 * @return 计算两个时间之间的相差天数
	 */
	public static int daysBetween(String startDate,String endDate,String fmt) {
		String fmts=df_yyyy_MM_dd_HH_mm_ss;
		if(fmt!=null){
			fmts=fmt;
		}
		 DateTimeFormatter format = DateTimeFormat.forPattern(fmts);
		 DateTime dstart=format.parseDateTime(startDate);
		 DateTime dend=format.parseDateTime(endDate);
		return Days.daysBetween(dstart, dend).getDays();
	}
	
	/**
	 * @return 计算两个时间之间的相差年数
	 */
	public static int yearsBetween(String startDate,String endDate,String fmt) {
		String fmts=df_yyyy_MM_dd_HH_mm_ss;
		if(fmt!=null){
			fmts=fmt;
		}
		 DateTimeFormatter format = DateTimeFormat.forPattern(fmts);
		 DateTime dstart=format.parseDateTime(startDate);
		 DateTime dend=format.parseDateTime(endDate);
		return Years.yearsBetween(dstart, dend).getYears();
	}
	
	/**
	 * @return 计算两个时间之间的相差月份数
	 */
	public static int monthsBetween(String startDate,String endDate,String fmt) {
		String fmts=df_yyyy_MM_dd_HH_mm_ss;
		if(fmt!=null){
			fmts=fmt;
		}
		 DateTimeFormatter format = DateTimeFormat.forPattern(fmts);
		 DateTime dstart=format.parseDateTime(startDate);
		 DateTime dend=format.parseDateTime(endDate);
		return Months.monthsBetween(dstart, dend).getMonths();
	}
	
	
	/**
	 * @return 计算两个时间之间的相差分钟数
	 */
	public static int minutesBetween(String startDate,String endDate,String fmt) {
		String fmts=df_yyyy_MM_dd_HH_mm_ss;
		if(fmt!=null){
			fmts=fmt;
		}
		 DateTimeFormatter format = DateTimeFormat.forPattern(fmts);
		 DateTime dstart=format.parseDateTime(startDate);
		 DateTime dend=format.parseDateTime(endDate);
		return Minutes.minutesBetween(dstart, dend).getMinutes();
	}
	
	/**
	 * @return 计算两个时间之间的相差分钟数
	 */
	public static int minutesBetween(DateTime startDate,DateTime endDate,String fmt) {
		return Minutes.minutesBetween(startDate, endDate).getMinutes();
	}
	
	
	/**
	 * @return 计算两个时间之间的相差秒数
	 */
	public static int secondsBetween(String startDate,String endDate,String fmt) {
		String fmts=df_yyyy_MM_dd_HH_mm_ss;
		if(fmt!=null){
			fmts=fmt;
		}
		 DateTimeFormatter format = DateTimeFormat.forPattern(fmts);
		 DateTime dstart=format.parseDateTime(startDate);
		 DateTime dend=format.parseDateTime(endDate);
		return Seconds.secondsBetween(dstart, dend).getSeconds();
	}
	
	/**
	  * <dl>
	  * <dt><span class="strong">方法说明:</span></dt>
	  * <dd>获取所在时区</dd>
	  * </dl> 
	  * <dl><dt><span class="strong">创建时间:</span></dt>
	  * <dd> 2015年7月31日 上午10:06:36</dd></dl> 
	  * </dl> 
	  * @author su_jian
	  * @param  没有参数
	  * @return 不可修改的Map对象
	 */
	 private static Map<String, String> buildMap() {
         Map<String, String> map = new HashMap<String, String>();
         map.put("GMT", "UTC");
         map.put("WET", "WET");
         map.put("CET", "CET");
         map.put("MET", "CET");
         map.put("ECT", "CET");
         map.put("EET", "EET");
         map.put("MIT", "Pacific/Apia");
         map.put("HST", "Pacific/Honolulu");  // JDK 1.1 compatible
         map.put("AST", "America/Anchorage");
         map.put("PST", "America/Los_Angeles");
         map.put("MST", "America/Denver");  // JDK 1.1 compatible
         map.put("PNT", "America/Phoenix");
         map.put("CST", "America/Chicago");
         map.put("EST", "America/New_York");  // JDK 1.1 compatible
         map.put("IET", "America/Indiana/Indianapolis");
         map.put("PRT", "America/Puerto_Rico");
         map.put("CNT", "America/St_Johns");
         map.put("AGT", "America/Argentina/Buenos_Aires");
         map.put("BET", "America/Sao_Paulo");
         map.put("ART", "Africa/Cairo");
         map.put("CAT", "Africa/Harare");
         map.put("EAT", "Africa/Addis_Ababa");
         map.put("NET", "Asia/Yerevan");
         map.put("PLT", "Asia/Karachi");
         map.put("IST", "Asia/Kolkata");
         map.put("BST", "Asia/Dhaka");
         map.put("VST", "Asia/Ho_Chi_Minh");
         map.put("CTT", "Asia/Shanghai");
         map.put("JST", "Asia/Tokyo");
         map.put("ACT", "Australia/Darwin");
         map.put("AET", "Australia/Sydney");
         map.put("SST", "Pacific/Guadalcanal");
         map.put("NST", "Pacific/Auckland");
         return Collections.unmodifiableMap(map);//此处返回不可修改的Map
     }
	 /**
		 * 得到时间字符串,格式为 yyyy-MM-dd HH:mm:ss
		 * 
		 * @param date
		 *            待格式化日期
		 * @return 返回格式化后的时间字符串
		 * @since 0.1
		 */
		public static String getTimeNormalString(Date date) {
			DateFormat fmt = new SimpleDateFormat(df_yyyy_MM_dd_HH_mm_ss);
			return fmt.format(date);
		}
		/**
		 * 
		 * Description: 获取毫秒数
		 * @param 
		 * @return String
		 * @throws
		 * @Author su_jian
		 * Create Date: 2016年8月1日 下午4:47:14
		 */
		public static String getHaomiaoString(){
			Calendar cal = Calendar.getInstance(); 
			java.util.Date date = cal.getTime();  
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
			String myTime = sdFormat.format(date);
			return myTime;
		}
		
		/**
		 * 
		 * Description: （yyyyMMddhhmmss）获取当前时间（年月日时分秒）的字符串
		 * @param 
		 * @return String
		 * @throws
		 * @Author su_jian
		 * Create Date: 2016年8月1日 下午4:47:14
		 */
		public static String getCurrentTimeString(){
			Calendar cal = Calendar.getInstance(); 
			java.util.Date date = cal.getTime();  
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
			String myTime = sdFormat.format(date);
			return myTime;
		}
		
		/**
		  * 
		  * Description: 获取前几天或者后几天的时间
		  * @param 
		  * @return Date
		  * @throws
		  * @Author su_jian
		  * Create Date: 2016年9月5日 下午5:29:54
		  */
		 public static Date getBeforeOrAfterDay(Date date,Integer num) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				calendar.add(Calendar.DAY_OF_MONTH, num);
				date = calendar.getTime();
				return date;
		}
		 /**
		  * 
		  * Description: 获取前几分钟或者后几分钟的时间
		  * @param 
		  * @return Date
		  * @throws
		  * @Author su_jian
		  * Create Date: 2016年9月5日 下午5:29:54
		  */
		 public static Date getBeforeOrAfterMin(Date date,Integer num) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				calendar.add(Calendar.MINUTE, num);
				date = calendar.getTime();
				return date;
		}
		 
		 public static boolean betweenDateWithNow(String startHHmm, String endHHmm){

		        Calendar calendarUtil = Calendar.getInstance();
		        Date now = calendarUtil.getTime();
		        System.out.println(calendarUtil.getTime().toLocaleString());
		        String[] startStrs = startHHmm.split(":");
		        calendarUtil.set(Calendar.HOUR_OF_DAY, Integer.parseInt(startStrs[0]));
		        calendarUtil.set(Calendar.MINUTE, Integer.parseInt(startStrs[1]));
		        calendarUtil.set(Calendar.SECOND, 00);
		        Date startDate = calendarUtil.getTime();
		        String[] endStrs = endHHmm.split(":");
		        calendarUtil.set(Calendar.HOUR_OF_DAY, Integer.parseInt(endStrs[0]));
		        calendarUtil.set(Calendar.MINUTE, Integer.parseInt(endStrs[1]));
		        calendarUtil.set(Calendar.SECOND, 00);
		        Date endDate = calendarUtil.getTime();
		        //判定时间范围
		        if(now.getTime() < endDate.getTime() && now.getTime() > startDate.getTime()){
		            //设置标志
		            return true;
		        }
		        return false;
		    }
		    
		    /**
		     * 日期格式字符串转换成时间戳
		     * @param dateStr 字符串日期
		     * @param format   如：yyyy-MM-dd HH:mm:ss
		     * @return
		     */
		    public static String Date2TimeStamp(String dateStr, String format) {
		        try {
		            SimpleDateFormat sdf = new SimpleDateFormat(format);
		            return String.valueOf(sdf.parse(dateStr).getTime() / 1000);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return "";
		    }
		    
		    
		    
		    public static final String FULL_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

			/**
			 * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
			 * 
			 * @param date
			 * @return yyyy-MM-dd HH:mm:ss
			 */
			public static String date2Str(Date date) {
				return date2Str(date, FULL_TIME_FORMAT);
			}

			/**
			 * 按照参数format的格式，日期转字符串
			 * 
			 * @param date
			 * @param format
			 * @return
			 */
			public static String date2Str(Date date, String format) {
				if (date != null) {
					SimpleDateFormat sdf = new SimpleDateFormat(format);
					return sdf.format(date);
				} else {
					return "";
				}
			}

			public static Date str2Date(String str) {
				return str2Date(str, "yyyy-MM-dd");
			}

			public static Date str2Date(String str, String format) {
				if (StringUtils.isNotBlank(str)) {
					SimpleDateFormat sdf = new SimpleDateFormat(format);
					Date parseDate;
					try {
						parseDate = sdf.parse(str);
					} catch (Exception e) {
						parseDate = new Date();
					}
					return parseDate;
				}
				return new Date();
			}

			/**
			 * 根据用户生日计算年龄
			 */
			public static int getAgeByBirthday(Date birthday) {
				if (birthday == null) {
					return 0;
				}
				Calendar cal = Calendar.getInstance();

				if (cal.before(birthday)) {
					return 0;
				}

				int yearNow = cal.get(Calendar.YEAR);
				int monthNow = cal.get(Calendar.MONTH) + 1;
				int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

				cal.setTime(birthday);
				int yearBirth = cal.get(Calendar.YEAR);
				int monthBirth = cal.get(Calendar.MONTH) + 1;
				int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

				int age = yearNow - yearBirth;

				if (monthNow <= monthBirth) {
					if (monthNow == monthBirth) {
						if (dayOfMonthNow < dayOfMonthBirth) {
							age--;
						}
					} else {
						age--;
					}
				}
				return age;
			}

			public static long nowSeconds() {
				return System.currentTimeMillis() / 1000;
			}

			/**
			 * 获得当前日期的前一天
			 * 
			 * @param date
			 * @return
			 */
			public static Date getSpecifiedDayBefore(Date date) {
				if (date == null) {
					return null;
				}
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				int day = cal.get(Calendar.DATE);
				cal.set(Calendar.DATE, day - 1);
				return cal.getTime();
			}

			/**
			 * 获取时间年月日时00,30
			 * 
			 * @param date
			 * @return 201609210900,201609210930
			 */
			public static Long getDateMinute() {
				SimpleDateFormat sdf = null;
				Calendar c = Calendar.getInstance();
				int minute = c.get(Calendar.MINUTE);
				if (minute >= 30) {
					sdf = new SimpleDateFormat("yyyyMMddHH30");
				} else {
					sdf = new SimpleDateFormat("yyyyMMddHH00");
				}
				String ss = sdf.format(c.getTime());
				return Long.valueOf(ss);
			}

			/**
			 * 获取时间年月日时00,30
			 * 
			 * @param date
			 * @return 201609210900,201609210930
			 */
			public static Long getDateMinute(Date date) {
				SimpleDateFormat sdf = null;
				Calendar c = Calendar.getInstance();
				int minute = c.get(Calendar.MINUTE);
				if (minute >= 30) {
					sdf = new SimpleDateFormat("yyyyMMddHH30");
				} else {
					sdf = new SimpleDateFormat("yyyyMMddHH00");
				}
				String ss = sdf.format(date);
				return Long.valueOf(ss);
			}
			
			/**
		     * String转时间戳
		     * @param reportTime
		     * @return
		     */
		    public static Date stringToDate(String reportTime) {
				
				try {
					SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmss");
					Date date = simpleDateFormat .parse(reportTime);
					
					return date;
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return null;
				
			} 
		    
		    /**
		     * String转时间戳
		     * @param reportTime
		     * @return
		     */
            public static Timestamp stringToTimestamps(String reportTime) {
				
				try {
					SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = simpleDateFormat .parse(reportTime);
					long timeStemp = date.getTime();
			        Timestamp time =new Timestamp(timeStemp);
					return time;
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return null;
				
			}
            
            /**
             * 紧急救援时间+8小时
             * @param reportTime
             * @return
             */
            public static Timestamp addEnight(String reportTime) {
            	SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            	try {
					Date date = simpleDateFormat .parse(reportTime);
					
					Calendar calendar=Calendar.getInstance();   
	            	calendar.setTime(date); 
	            	calendar.add(Calendar.HOUR, +8);
	            	date =calendar.getTime();
	            	return new Timestamp(date.getTime());
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				return null;	
            }
            
            
            
            
            
            public static void main(String [] args){
            	System.err.println(new Timestamp(new Date().getTime()));
            	System.err.println(new Timestamp(new Date().getTime()-24*3*60*60*1000L));
            	String time = "2017-06-05 19:22:55";
            	System.err.println(addEnight(time) );
            }
}
