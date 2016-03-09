package com.thoughtworks.homework.currencyExchangeTool.strategy;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thoughtworks.homework.currencyExchangeTool.config.GalacticConfigManager;
import com.thoughtworks.homework.currencyExchangeTool.config.RomanConfigManager;

public class CreditCalculateStrategyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		RomanConfigManager.getInstance().load();
		GalacticConfigManager.getInstance().load();
	}

	@Test
	public void testCalculate() {
		CreditCalculateStrategy cal = new CreditCalculateStrategy();
		cal.setType("Gold");
		String str = "XLII";
		double result = cal.calculate(str);
		System.out.println(result);
	}

}
