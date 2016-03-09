package com.thoughtworks.homework.currencyExchangeTool.validation;

import java.util.Arrays;

import com.thoughtworks.homework.currencyExchangeTool.module.request.MessageRequest;
import com.thoughtworks.homework.currencyExchangeTool.util.Constants;

public class CreditValidation extends BaseNumeralValidation {

	@Override
	public boolean validationModule(MessageRequest request) {
		String type = request.getType();
		if("".equals(type) || type == null 
				|| !(Arrays.asList(Constants.GALACTIC_CREDIT_TYPE).contains(type))){
			return false;
		} else if(this.getValidation() != null) {
			return getValidation().validationModule(request);
		}
		return true;
	}


}
