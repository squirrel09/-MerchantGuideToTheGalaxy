package com.thoughtworks.homework.currencyExchangeTool.validation;

import com.thoughtworks.homework.currencyExchangeTool.VO.RomanNumeral;
import com.thoughtworks.homework.currencyExchangeTool.config.RomanConfigManager;
import com.thoughtworks.homework.currencyExchangeTool.module.request.MessageRequest;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName SubstractedRule.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ3ÈÕ
 * @Description To validate Roman numeral can be substracted or not.
 */
public class SubstractedValidation extends BaseNumeralValidation {

	@Override
	public boolean validationModule(MessageRequest request) {
		String str = request.getRomanString();
		if (!checkSubstracted(str)) {
			return false;
		} else if (this.getValidation() != null) {
			return this.getValidation().validationModule(request);
		}
		return true;
	}

	public boolean checkSubstracted(String str) {
		for (int i = 1; i < str.length() - 1; i = i + 2) {
			char c = str.charAt(i);
			char c1 = str.charAt(i + 1);
			RomanNumeral roman = RomanConfigManager.getInstance()
					.getRomanNumeral(String.valueOf(c));
			RomanNumeral roman1 = RomanConfigManager.getInstance()
					.getRomanNumeral(String.valueOf(c1));
			if (roman.getDecimalNumber() < roman1.getDecimalNumber()
					&& !(roman.getList().contains(String.valueOf(c1)))) {
				return false;
			}
		}
		return true;
	}

}
