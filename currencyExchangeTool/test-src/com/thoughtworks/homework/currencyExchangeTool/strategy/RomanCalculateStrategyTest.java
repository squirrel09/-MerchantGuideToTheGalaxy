package com.thoughtworks.homework.currencyExchangeTool.strategy;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thoughtworks.homework.currencyExchangeTool.config.RomanConfigManager;

public class RomanCalculateStrategyTest {

	private static RomanCalculateStrategy calculate;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		calculate = new RomanCalculateStrategy();
	}

	@Test
	public void testCalculate() {
		RomanConfigManager.getInstance().load();
		String str = "X";
		double result = calculate.calculate(str);
		System.out.println(result);
	}

}
