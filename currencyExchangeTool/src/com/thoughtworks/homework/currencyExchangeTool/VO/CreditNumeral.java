package com.thoughtworks.homework.currencyExchangeTool.VO;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName CreditNumeral.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ3ÈÕ
 * @Description TODO
 */
public class CreditNumeral extends BaseNumeral {

	private List<String> list = new ArrayList<String>();
	private double credit;
	private String type;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			buffer.append(list.get(i));
			buffer.append(", ");
		}
		return "List: " + buffer.toString() + "; credit: " + credit
				+ "; type: " + type;
	}

}
