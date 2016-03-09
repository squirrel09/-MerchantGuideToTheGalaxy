package com.thoughtworks.homework.currencyExchangeTool.util;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thoughtworks.homework.currencyExchangeTool.TestTools;

public class CommonUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testConvertToBoolean() {
		String str = "N";
		boolean flag = CommonUtil.convertToBoolean(str);
		assertEquals(false, flag);
	}

	@Test
	public void testGetEndIndex() {
		String localStr = "XXIXXLLXXL";
		char c = 'X';
		int result = CommonUtil.getEndIndex(localStr, c);
		assertEquals(8, result);
	}

	@Test
	public void testGetBeginIndex() {
		String str = "ab cd ef";
		char c = ' ';
		int index = CommonUtil.getBeginIndex(str, c);
		assertEquals(2, index);
	}

	@Test
	public void testConverToList() {
		String str = "agsd oiur gwer";
		List<String> list = CommonUtil.converToList(str, " ");
		TestTools.printList(list);
	}
	
	@Test
	public void testDivisionCalculate(){
		double result = 3.00;
		double creditNumeral = 21.00;
		double actual = CommonUtil.divisionCalculate(result, creditNumeral);
		assertEquals(7.0, actual, 0.0);
	}
	
	@Test
	public void testMultipCalculate(){
		double unit = 12.00;
		double amount = 3.00;
		double result = CommonUtil.multipCalculate(unit, amount);
		assertEquals(36.00, result, 0.0);
	}

}
