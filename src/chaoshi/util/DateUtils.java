package chaoshi.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils
{
    public static String getDateTime()
    {
        Date dt = new Date();
        long tm = dt.getTime();
        return ((new java.sql.Date(tm)) + " " + (new java.sql.Time(tm)));
    }

    public static String getDate()
    {
        Date dt = new Date();
        long tm = dt.getTime();
        return (new java.sql.Date(tm)).toString();
    }

   
	/**
	 * 得到当前日期前几天的日期
	 * @return yyyy-mm-dd
	 */
	public static String getBeforeDay(int num)
	{
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(new Date());
    calendar.add(Calendar.DATE, -num);
    SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    return simpledateformat.format(calendar.getTime());
	}
	
	/**
	 * 得到给定日期后几日的日期
	 * @param num
	 * @return
	 */
	public static String getAfterDay(String date,int num)	{
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = null;
		try {
			a = parser.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(a);
		calendar.add(Calendar.DATE, num);
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		return simpledateformat.format(calendar.getTime());
	}
	
	/**
	 * 根据字符串得到日期型的日�?
	 * @param day
	 * @return date
	 */
	public static Date getStringToDate(String day)
	{
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		Date a=new Date();
		try {
			a = parser.parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return a;
	}
}
