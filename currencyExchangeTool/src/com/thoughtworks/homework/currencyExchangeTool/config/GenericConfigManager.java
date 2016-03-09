package com.thoughtworks.homework.currencyExchangeTool.config;
/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * @FileName GenericConfigManager.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ4ÈÕ
 * @Description TODO
 */
public abstract class GenericConfigManager {
	
	public void load(){
		readFile();
	}
	
	public abstract void readFile();

}
