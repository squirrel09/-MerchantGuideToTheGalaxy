package com.thoughtworks.homework.currencyExchangeTool;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CurrencyExchangeAPPTest {

	private static CurrencyExchangeAPP app;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		app = new CurrencyExchangeAPP();
	}

	@Test
	public void testInit() {
		app.init();
	}

	@Test
	public void testRecieveMessage() {
		String result = app.recieveMessage();
		System.out.println("Feedback: [" + result + "]");
	}

	@Test
	public void testPressExchangeButton() {
		
	}

}
