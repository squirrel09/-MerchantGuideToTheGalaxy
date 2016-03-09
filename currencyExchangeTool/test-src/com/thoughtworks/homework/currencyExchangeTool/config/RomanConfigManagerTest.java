package com.thoughtworks.homework.currencyExchangeTool.config;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thoughtworks.homework.currencyExchangeTool.VO.RomanNumeral;

public class RomanConfigManagerTest {

	private static RomanConfigManager config;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		config = RomanConfigManager.getInstance();
	}

	@Test
	public void testReadFile() {
		//config.readFile();
	}

	@Test
	public void testParseRomanString() {
		String key = "X";
		String value = "10 Y Y";
		config.parseRomanString(key, value);
		Map<String, RomanNumeral> map = config.getMap();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String str = it.next();
			RomanNumeral roman = map.get(str);
			System.out.println("Key: " + str + "; Roman: " + roman.toString());
		}
	}

}
