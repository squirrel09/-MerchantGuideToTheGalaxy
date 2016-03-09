package com.thoughtworks.homework.currencyExchangeTool.VO;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName GalacticNumeral.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ3ÈÕ
 * @Description TODO
 */
public class GalacticNumeral extends BaseNumeral {
	private String galactic;
	private String roman;

	public String getRoman() {
		return roman;
	}

	public void setRoman(String roman) {
		this.roman = roman;
	}

	public String getGalactic() {
		return galactic;
	}

	public void setGalactic(String galactic) {
		this.galactic = galactic;
	}

	public String toString() {
		return "Galactic: " + galactic + "; Roman: " + roman;
	}

}
