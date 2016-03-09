package com.thoughtworks.homework.currencyExchangeTool.module.request;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName MessageRequest.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ5ÈÕ
 * @Description TODO
 */
public class MessageRequest {

	private String galacticString;
	private String type;
	private String text;
	private String romanString;
	private String errorMsg;
	private boolean isCredit;

	public String getGalacticString() {
		return galacticString;
	}

	public void setGalacticString(String galacticString) {
		this.galacticString = galacticString;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRomanString() {
		return romanString;
	}

	public void setRomanString(String romanString) {
		this.romanString = romanString;
	}

	public String toString() {
		return "Galactic: " + this.galacticString + "; Type: " + this.type
				+ "; Text: " + this.text + "; Roman: " + this.romanString;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public boolean isCredit() {
		return isCredit;
	}

	public void setCredit(boolean isCredit) {
		this.isCredit = isCredit;
	}
	
	
	

}
