package com.thoughtworks.homework.currencyExchangeTool.validation;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thoughtworks.homework.currencyExchangeTool.config.RomanConfigManager;

public class SubstractedValidationTest {

	private static SubstractedValidation validation;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		RomanConfigManager.getInstance().load();
		validation = new SubstractedValidation();
	}

	@Test
	public void testCheckSubstracted() {
		String str = "XIVXC";
		boolean result = validation.checkSubstracted(str);
		assertEquals(true, result);
	}

}
