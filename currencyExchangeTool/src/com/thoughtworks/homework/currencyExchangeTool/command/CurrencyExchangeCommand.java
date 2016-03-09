package com.thoughtworks.homework.currencyExchangeTool.command;

import com.thoughtworks.homework.currencyExchangeTool.module.BaseModule;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName CurrencyExchangeCommand.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ4ÈÕ
 * @Description TODO
 */
public class CurrencyExchangeCommand extends BaseCommand {

	private BaseModule module;

	public CurrencyExchangeCommand(BaseModule module) {
		this.module = module;
	}

	@Override
	public String execute(String request) {
		return module.translate(request);
	}

}
