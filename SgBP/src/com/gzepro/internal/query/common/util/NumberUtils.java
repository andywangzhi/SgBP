package com.gzepro.internal.query.common.util;

import java.text.DecimalFormat;

/**
 * 数字格式化工具类
 * 
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class NumberUtils {
	/**
	 * 按指定的样式格式化数字.<br>
	 * 例如:
	 * format(1,"##.###"),结果1.000
	 * format(1.165686,"##.###"),结果1.166
	 * format(0,"##.##"),结果0.00
	 * format(0.2556,"##.##%"),结果25.56%
	 * format(1,"##%"),结果100%
	 * @param d double
	 * @param pattern 格式化字符串. 如:##.###(带三位小数点,四舍五入)
	 * @return
	 */
	public static String format(double d, String pattern) {
		DecimalFormat nf = new DecimalFormat(pattern);
		return nf.format(d);
	}
	
	public static String format(Integer i, String pattern) {
		DecimalFormat nf = new DecimalFormat(pattern);
		return nf.format(i);
	}

	/**
	 * #format(double, String)}
	 * @param doubleStr
	 * @param pattern
	 * @return
	 */
	public static String format(String doubleStr, String pattern) {
		double d = 0;
		try {
			d = Double.parseDouble(doubleStr);
		} catch (NumberFormatException e) {
			System.out.println("字符串转换成数字有异常!  doubleStr=" + doubleStr);
		}
		return format(d, pattern);
	}

	/**
	 *#format(double, String)相似,区别在于返回值增加了一个html的空格字符(&nbsp;).
	 * @param d
	 * @param pattern
	 * @return 返回值增加了一个html格式的空格符(&nbsp;).
	 */
	public static String formatWithBlank(double d, String pattern) {
		return format(d, pattern) + "&nbsp;";
	}

	/**
	 * formatWithBlank(double, String)
	 * @param doubleStr
	 * @param pattern
	 * @return
	 */
	public static String formatWithBlank(String doubleStr, String pattern) {
		double d = 0;
		try {
			d = Double.parseDouble(doubleStr);
		} catch (NumberFormatException e) {
			System.out.println("字符串转换成数字有异常!  doubleStr=" + doubleStr);
		}
		return formatWithBlank(d, pattern);
	}

	/**
	 * 给数字字符后增加一个html格式的空格符(&nbsp;);<br>
	 * 用途:在将html页面导出excel格式时,excel会默认将数字字符串转换成数字,这样会导致字符串前后的00被清掉.
	 * 调用此方法,增加了一个空格字符后,可以避免excel的自动转换. 如:1.200,excel会自动转换成1.2;
	 * 00012,excel会自动转换成12;
	 * @param numStr 数字字符串
	 * @return
	 */
	public static String addBlank(String numStr) {
		return numStr + "&nbsp;";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer b = 11656;
		
		String result2 = NumberUtils.format("1596.53", "###.##");
		System.out.println("" + result2);
		
		String result = NumberUtils.format(b, ",###");
		System.out.println("" + result);
		
		double a = 11656.865678;
		result = NumberUtils.format(a, ",###.###");
		System.out.println("" + result);
		
		double d = 1.165686;
		result = NumberUtils.format(d, "##.###");
		System.out.println("" + result);
		d = 1;
		result = NumberUtils.format(d, "##.##%");
		System.out.println("" + result);
		d = 0;
		result = NumberUtils.format(d, "##.#%");
		System.out.println("" + result);
		d = 0.2556;
		result = NumberUtils.format(d, "##.##%");
		System.out.println("" + result);
		d = 1;
		result = NumberUtils.format(d, "##%");
		System.out.println("" + result);
		System.out.println("-----------");
		System.out.println(NumberUtils.format("3.1415926", "##.##"));
	}

}
