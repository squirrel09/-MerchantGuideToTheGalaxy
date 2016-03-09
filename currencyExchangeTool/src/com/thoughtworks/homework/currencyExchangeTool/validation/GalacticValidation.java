package com.thoughtworks.homework.currencyExchangeTool.validation;

import java.util.Arrays;

import com.thoughtworks.homework.currencyExchangeTool.VO.GalacticNumeral;
import com.thoughtworks.homework.currencyExchangeTool.config.GalacticConfigManager;
import com.thoughtworks.homework.currencyExchangeTool.module.request.MessageRequest;
import com.thoughtworks.homework.currencyExchangeTool.util.Constants;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName GalacticValidation.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ4ÈÕ
 * @Description To validate the input galactic numeral is valid or not.
 */
public class GalacticValidation extends BaseNumeralValidation {

	@Override
	public boolean validationModule(MessageRequest request) {
		String str = request.getGalacticString();
		String[] tempStr = str.split(" ");
		for (int i = 0; i < tempStr.length; i++) {
			GalacticNumeral galactic = GalacticConfigManager.getInstance()
					.getGalacticNumeral(tempStr[i]);
			if (galactic == null) {
				return false;
			}
		}
		if(getValidation() != null) {
			return getValidation().validationModule(request);
		}
		return true;
	}

}
