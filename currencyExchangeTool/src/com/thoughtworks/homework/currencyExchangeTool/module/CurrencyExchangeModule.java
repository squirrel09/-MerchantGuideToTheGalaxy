package com.thoughtworks.homework.currencyExchangeTool.module;

import java.util.Arrays;
import java.util.List;

import com.thoughtworks.homework.currencyExchangeTool.VO.GalacticNumeral;
import com.thoughtworks.homework.currencyExchangeTool.config.GalacticConfigManager;
import com.thoughtworks.homework.currencyExchangeTool.module.request.MessageRequest;
import com.thoughtworks.homework.currencyExchangeTool.strategy.BaseCalculateStrategy;
import com.thoughtworks.homework.currencyExchangeTool.strategy.CreditCalculateStrategy;
import com.thoughtworks.homework.currencyExchangeTool.strategy.RomanCalculateStrategy;
import com.thoughtworks.homework.currencyExchangeTool.util.CommonUtil;
import com.thoughtworks.homework.currencyExchangeTool.util.Constants;
import com.thoughtworks.homework.currencyExchangeTool.validation.BaseNumeralValidation;
import com.thoughtworks.homework.currencyExchangeTool.validation.CreditValidation;
import com.thoughtworks.homework.currencyExchangeTool.validation.GalacticValidation;
import com.thoughtworks.homework.currencyExchangeTool.validation.RepeatedValidation;
import com.thoughtworks.homework.currencyExchangeTool.validation.SubstractedValidation;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName CurrencyExchangeModule.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ4ÈÕ
 * @Description The currency exchange module that include parse request,
 *              validation, translate to Roman object and process.
 */
public class CurrencyExchangeModule extends BaseModule {

	private BaseCalculateStrategy strategy;

	
	@Override
	public boolean validation(MessageRequest request) {
		BaseNumeralValidation repeated = new RepeatedValidation();
		BaseNumeralValidation substracted = new SubstractedValidation();
		repeated.setValidation(substracted);
		return repeated.validationModule(request);
	}

	@Override
	public String process(String str) {
		double result = strategy.calculate(str);
		return msgRequest.getText() + " is " + result;
	}

	@Override
	public MessageRequest paraseRequest(String request) {
		msgRequest = new MessageRequest();
		String galacitcStr = "";
		String[] tempStr = null;
		if (!request.contains(" is ") || (request.split(" is ").length < 2)) {
			msgRequest.setErrorMsg(Constants.ERROR_VALIDATION_GALACTIC_MSG);
			return msgRequest;
		}
		if (!request.contains("Credits")) {
			tempStr = request.split(" is ");
			galacitcStr = tempStr[1];
			msgRequest.setGalacticString(galacitcStr);
			strategy = new RomanCalculateStrategy();
		} else {
			tempStr = request.split(" is ");
			String lastStr = tempStr[1];
			int endInd = CommonUtil.getEndIndex(lastStr, ' ');
			galacitcStr = lastStr.substring(0, endInd);
			String type = lastStr.substring(endInd + 1);
			msgRequest.setGalacticString(galacitcStr);
			msgRequest.setType(type);
			msgRequest.setCredit(true);
			CreditCalculateStrategy creditStrategy = new CreditCalculateStrategy();
			creditStrategy.setType(type);
			strategy = creditStrategy;
		}
		msgRequest.setText(galacitcStr);
		return msgRequest;
	}

	public boolean validationGalactic(MessageRequest request) {
		BaseNumeralValidation galacticVal = new GalacticValidation();
		if(request.isCredit()){
			galacticVal.setValidation(new CreditValidation());
		}
		return galacticVal.validationModule(request);
	}

	public String translateToRoman(MessageRequest request) {
		String str = request.getGalacticString();
		List<String> list = CommonUtil.converToList(str, " ");
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			GalacticNumeral gal = GalacticConfigManager.getInstance()
					.getGalacticNumeral(list.get(i));
			buffer.append(gal.getRoman());
		}
		msgRequest.setRomanString(buffer.toString());
		return buffer.toString();
	}

}
