package com.thoughtworks.homework.currencyExchangeTool.strategy;

import com.thoughtworks.homework.currencyExchangeTool.config.GalacticConfigManager;
import com.thoughtworks.homework.currencyExchangeTool.util.CommonUtil;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName CreditCalculateStrategy.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ4ÈÕ
 * @Description To calculate credit after Roman calculate.
 */
public class CreditCalculateStrategy extends RomanCalculateStrategy {

	private String type;

	@Override
	public double calculate(String str) {
		double amount = super.calculate(str);
		double unit = GalacticConfigManager.getInstance().getCreditUnit(type);
		double result = CommonUtil.multipCalculate(unit, amount);
		return result;
	}

	public void setType(String type) {
		this.type = type;
	}

}
