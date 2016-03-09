package com.thoughtworks.homework.currencyExchangeTool.module;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.thoughtworks.homework.currencyExchangeTool.config.GalacticConfigManager;
import com.thoughtworks.homework.currencyExchangeTool.config.RomanConfigManager;
import com.thoughtworks.homework.currencyExchangeTool.module.request.MessageRequest;

public class CurrencyExchangeModuleTest {
	private static CurrencyExchangeModule module;

	private static MessageRequest request;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		module = new CurrencyExchangeModule();
		RomanConfigManager.getInstance().load();
		GalacticConfigManager.getInstance().load();
		request = new MessageRequest();
	}

	@Test
	public void testParaseRequest() {
		String str = "how many Credits is glob prok Silver";
//		String str = "how much is pish glob";
		request = module.paraseRequest(str);
		System.out.println(request.toString());
	}

	@Ignore
	public void testValidation() {
		String str = "XCM";
		request.setRomanString(str);
		boolean flag = module.validation(request);
		assertEquals(true, flag);
	}

	@Test
	public void testProcess() {
	}

	@Ignore
	public void testValidationGalactic() {
		String str = "pish tegj glob glob";
		request.setGalacticString(str);
		boolean flag = module.validationGalactic(request);
		assertEquals(true, flag);
	}

	@Ignore
	public void testTranslateToRoman() {
		String str = "glob ";
		request.setGalacticString(str);
		String result = module.translateToRoman(request);
		System.out.println(result);
	}

}
