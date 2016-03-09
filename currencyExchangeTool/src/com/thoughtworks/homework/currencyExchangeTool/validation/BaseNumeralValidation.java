package com.thoughtworks.homework.currencyExchangeTool.validation;

import com.thoughtworks.homework.currencyExchangeTool.module.request.MessageRequest;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * @FileName RomanNumeralRule.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ3ÈÕ
 * @Description TODO
 */
public abstract class BaseNumeralValidation {

	private BaseNumeralValidation validation;

	public abstract boolean validationModule(MessageRequest request);


	public BaseNumeralValidation getValidation() {
		return validation;
	}

	public void setValidation(BaseNumeralValidation validation) {
		this.validation = validation;
	}
	

}
