package com.thoughtworks.homework.currencyExchangeTool.config;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;

import com.thoughtworks.homework.currencyExchangeTool.VO.CreditNumeral;
import com.thoughtworks.homework.currencyExchangeTool.VO.GalacticNumeral;

public class GalacticConfigManagerTest {

	private static GalacticConfigManager config;
	private static String str;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		RomanConfigManager.getInstance().load();
		config = GalacticConfigManager.getInstance();
//		str = "glob prok Gold is 57800 Credits";
		str = "glob is I";
	}

	@Test
	public void testReadFile() {
		config.readFile();
		Map<String, GalacticNumeral> map = config.getMap();
		Set set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			GalacticNumeral galactic = map.get(key);
			System.out.println(galactic.toString());
		}
		List<CreditNumeral> creditList = config.getCreditList();
		Iterator<CreditNumeral> creditIt = creditList.iterator();
		while(creditIt.hasNext()) {
			CreditNumeral credit = creditIt.next();
			System.out.println(credit.toString());
			System.out.println("Unit: " + config.getCreditUnit(credit.getType()));
		}
	}

	@Ignore
	public void testParaseGalacticString() {
		//String str = "glob is I";
		config.paraseGalacticString(str);
		Map<String, GalacticNumeral> map = config.getMap();
		Set set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			GalacticNumeral galactic = map.get(key);
			System.out.println(galactic.toString());
		}
		List<CreditNumeral> creditList = config.getCreditList();
		Iterator<CreditNumeral> creditIt = creditList.iterator();
		while(creditIt.hasNext()) {
			CreditNumeral credit = creditIt.next();
			System.out.println(credit.toString());
		}
	}
	@Ignore
	public void testParaseGalacticStringList() {
		
		//config.paraseGalacticString(str);
		List<CreditNumeral> creditList = config.getCreditList();
		Iterator<CreditNumeral> creditIt = creditList.iterator();
		while(creditIt.hasNext()) {
			CreditNumeral credit = creditIt.next();
			System.out.println(credit.toString());
		}
	}
	
	@Ignore
	public void testProcessCredit(){
		config.processCredit();
		Set<String> set = config.getCreditMap().keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			double value = config.getCreditUnit(key);
			System.out.println("Key=" + key + " value="+value);
		}
	}
	

}
