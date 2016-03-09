package com.thoughtworks.homework.currencyExchangeTool.validation;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.thoughtworks.homework.currencyExchangeTool.config.RomanConfigManager;

public class RepeatedValidationTest {

	private static RepeatedValidation validation;
	private static String str;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		str = "XXIXDXM";
		validation = new RepeatedValidation();
		RomanConfigManager.getInstance().load();
	}

	@Test
	public void testCheckRepeated() {
//		String str = "XXCML";
//		String str = "VXMMXLDD";
		boolean result = validation.checkRepeated(str);
		assertEquals(true, result);
	}

	@Test
	public void testCheckCanBeMore() {
		boolean result = validation.checkCanBeMore(str);
		assertEquals(false, result);
	}
	

}
