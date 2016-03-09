package com.thoughtworks.homework.currencyExchangeTool.validation;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thoughtworks.homework.currencyExchangeTool.config.GalacticConfigManager;
import com.thoughtworks.homework.currencyExchangeTool.config.RomanConfigManager;
import com.thoughtworks.homework.currencyExchangeTool.module.request.MessageRequest;

public class CreditValidationTest {

	private static MessageRequest request;
	private static CreditValidation validation;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		RomanConfigManager.getInstance().load();
		GalacticConfigManager.getInstance().load();
		request = new MessageRequest();
		validation = new CreditValidation();
	}

	@Test
	public void testValidationModule() {
		request.setType(null);
		boolean flag = validation.validationModule(request);
		assertEquals(false, flag);
	}

}
