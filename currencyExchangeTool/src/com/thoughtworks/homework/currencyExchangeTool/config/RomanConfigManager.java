package com.thoughtworks.homework.currencyExchangeTool.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.thoughtworks.homework.currencyExchangeTool.VO.RomanNumeral;
import com.thoughtworks.homework.currencyExchangeTool.util.CommonUtil;
import com.thoughtworks.homework.currencyExchangeTool.util.Constants;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName RomanConfigManager.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ3ÈÕ
 * @Description To read Roman numeral and transform them to object.
 */
public class RomanConfigManager extends GenericConfigManager {
	private static RomanConfigManager config;
	private Map<String, RomanNumeral> map = new HashMap<String, RomanNumeral>();
	private List<String> list = new ArrayList<String>();

	private RomanConfigManager() {

	}

	public static RomanConfigManager getInstance() {
		if (config == null) {
			config = new RomanConfigManager();
		}
		return config;
	}

	public void readFile() {
		File file = new File(Constants.ROMAN_FILE_PATH);
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(file));
			Set set = prop.keySet();
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String key = it.next();
				// System.out.println("key: " + key + "; value: " +
				list.add(key);
				parseRomanString(key, prop.getProperty(key));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void parseRomanString(String key, String value) {
		String[] tempStr = value.split(" ");
		RomanNumeral roman = new RomanNumeral();
		int i = 0;
		roman.setNumber(key);
		roman.setDecimalNumber(Double.parseDouble(tempStr[i++]));
		roman.setRepeated(CommonUtil.convertToBoolean(tempStr[i++]));
		roman.setSubtracted(CommonUtil.convertToBoolean(tempStr[i++]));
		if (tempStr.length > i) {
			String substract = tempStr[tempStr.length - 1];
			String[] tempSubstr = substract.split(",");
			for (int j = 0; j < tempSubstr.length; j++) {
				roman.getList().add(tempSubstr[j]);
			}
		}
		map.put(key, roman);
	}

	public Map<String, RomanNumeral> getMap() {
		return map;
	}

	public RomanNumeral getRomanNumeral(String key) {
		return map.get(key);
	}

}
