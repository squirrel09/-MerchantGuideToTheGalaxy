package com.thoughtworks.homework.currencyExchangeTool.config;
/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * @FileName GenericConfigManager.java
 * @author Xie Di
 * @Date 2016��3��4��
 * @Description TODO
 */
public abstract class GenericConfigManager {
	
	public void load(){
		readFile();
	}
	
	public abstract void readFile();

}
