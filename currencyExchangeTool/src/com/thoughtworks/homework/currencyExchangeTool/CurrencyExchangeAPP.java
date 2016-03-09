package com.thoughtworks.homework.currencyExchangeTool;

import java.util.Scanner;

import com.thoughtworks.homework.currencyExchangeTool.command.BaseCommand;
import com.thoughtworks.homework.currencyExchangeTool.command.CurrencyExchangeCommand;
import com.thoughtworks.homework.currencyExchangeTool.config.GalacticConfigManager;
import com.thoughtworks.homework.currencyExchangeTool.config.RomanConfigManager;
import com.thoughtworks.homework.currencyExchangeTool.module.BaseModule;
import com.thoughtworks.homework.currencyExchangeTool.module.CurrencyExchangeModule;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName CurrencyExchangeAPP.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ4ÈÕ
 * @Description TODO
 */
public class CurrencyExchangeAPP {

	public void init() {
		RomanConfigManager.getInstance().load();
		GalacticConfigManager.getInstance().load();
	}

	public void start() {
		init();
		System.out.println("Currency Exchange APP Has Been Loaded...");
	}

	public String recieveMessage() {
		System.out.println("If you want to quit, please input 0");
		System.out.println("Please input currency you want to exchange: ");
		Scanner scanner = new Scanner(System.in);
		String request = scanner.nextLine();
		if ("0".equals(request)) {
			System.exit(0);
		}
		return request;
	}

	public void pressExchangeButton() {
		BaseModule module = new CurrencyExchangeModule();
		BaseCommand exchangeCommand = new CurrencyExchangeCommand(module);
		while (true) {
			String message = recieveMessage();
			String output = exchangeCommand.execute(message);
			System.out.println(output);
			System.out.println("***********************************");
		}

	}
}
