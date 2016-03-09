package com.thoughtworks.homework.currencyExchangeTool.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName CommonUtil.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ4ÈÕ
 * @Description The common static methods as tools.
 */
public class CommonUtil {
	private static DecimalFormat decimalFormat = new DecimalFormat("#.00");

	public static boolean convertToBoolean(String str) {
		if ("Y".equals(str)) {
			return true;
		}
		return false;
	}

	public static int getEndIndex(String str, char c) {
		int endIndex = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			char c1 = str.charAt(i);
			if (c == c1) {
				endIndex = i;
				break;
			}
		}
		return endIndex;
	}

	public static int getBeginIndex(String str, char c) {
		return str.indexOf(c);
	}

	public static List<String> converToList(String str, String split) {
		List<String> list = new ArrayList<String>();
		String[] tempStr = str.split(split);
		for (int i = 0; i < tempStr.length; i++) {
			list.add(tempStr[i]);
		}
		return list;
	}

	public static DecimalFormat getDecimalFormat() {
		return decimalFormat;
	}

	public static double divisionCalculate(double result, double creditNumeral) {
		return Double.parseDouble(getDecimalFormat().format(
				creditNumeral / result));
	}

	public static double multipCalculate(double unit, double amount) {
		return Double.parseDouble(getDecimalFormat().format(unit * amount));
	}

}
