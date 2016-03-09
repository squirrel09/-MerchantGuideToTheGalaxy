package com.thoughtworks.homework.currencyExchangeTool.strategy;

import java.text.DecimalFormat;

import com.thoughtworks.homework.currencyExchangeTool.VO.RomanNumeral;
import com.thoughtworks.homework.currencyExchangeTool.config.RomanConfigManager;
import com.thoughtworks.homework.currencyExchangeTool.util.CommonUtil;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName RomanCalculateStrategy.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ4ÈÕ
 * @Description To translate Roman numeral to Arabic numeral.
 */
public class RomanCalculateStrategy extends BaseCalculateStrategy {

	private RomanConfigManager config = RomanConfigManager.getInstance();

	@Override
	public double calculate(String str) {
		double total = 0.00;
		DecimalFormat df = CommonUtil.getDecimalFormat();
		for (int i = 0; i < str.length() - 1; i = i + 2) {
			char c = str.charAt(i);
			char c1 = str.charAt(i + 1);
			RomanNumeral roman = config.getRomanNumeral(String.valueOf(c));
			RomanNumeral roman1 = config.getRomanNumeral(String.valueOf(c1));
			double decimal = roman.getDecimalNumber();
			double deciaml1 = roman1.getDecimalNumber();
			if (decimal < deciaml1) {
				double substractDec = deciaml1 - decimal;
				total = total + substractDec;
			} else {
				total = total + decimal + deciaml1;
			}
		}
		if(str.length() == 1) {
			total = config.getRomanNumeral(str).getDecimalNumber();
		}
		return Double.parseDouble(df.format(total));
	}

}
