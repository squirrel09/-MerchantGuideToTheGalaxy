package com.thoughtworks.homework.currencyExchangeTool.VO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName RomanNumeral.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ3ÈÕ
 * @Description Roman numeral object that created based on properties file.
 */
public class RomanNumeral extends BaseNumeral {

	private String number;
	private double decimalNumber;
	private boolean isRepeated;
	private boolean isSubtracted;
	private List<String> list = new ArrayList<String>();

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isRepeated() {
		return isRepeated;
	}

	public void setRepeated(boolean isRepeated) {
		this.isRepeated = isRepeated;
	}

	public boolean isSubtracted() {
		return isSubtracted;
	}

	public void setSubtracted(boolean isSubtracted) {
		this.isSubtracted = isSubtracted;
	}

	public double getDecimalNumber() {
		return decimalNumber;
	}

	public void setDecimalNumber(double decimalNumber) {
		this.decimalNumber = decimalNumber;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			buffer.append(list.get(i));
			buffer.append(", ");
		}
		return "Roman: " + number + "; Repeated: " + this.isRepeated
				+ "; Substracted: " + this.isSubtracted + "; Decimal: "
				+ this.decimalNumber + "; List: " + buffer.toString();
	}
}
