package com.thoughtworks.homework.currencyExchangeTool.module;

import com.thoughtworks.homework.currencyExchangeTool.module.request.MessageRequest;
import com.thoughtworks.homework.currencyExchangeTool.util.Constants;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName BaseModule.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ4ÈÕ
 * @Description This is a template super class.
 */
public abstract class BaseModule {
	public MessageRequest msgRequest;

	public String translate(String request) {
		msgRequest = paraseRequest(request);
		if(msgRequest.getErrorMsg() != null){
			return msgRequest.getErrorMsg();
		}
		if (!validationGalactic(msgRequest)) {
			return Constants.ERROR_VALIDATION_GALACTIC_MSG;
		}
		String str = translateToRoman(msgRequest);
		if (!validation(msgRequest)) {
			return Constants.ERROR_VALIDATION_ROMAN_MSG;
		}
		return process(str);
	}

	public abstract MessageRequest paraseRequest(String request);

	public abstract boolean validation(MessageRequest request);

	public abstract String process(String str);

	public abstract boolean validationGalactic(MessageRequest request);

	public abstract String translateToRoman(MessageRequest request);

}
