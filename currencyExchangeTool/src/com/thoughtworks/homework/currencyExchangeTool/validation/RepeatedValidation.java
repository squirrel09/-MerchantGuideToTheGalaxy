package com.thoughtworks.homework.currencyExchangeTool.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.homework.currencyExchangeTool.VO.RomanNumeral;
import com.thoughtworks.homework.currencyExchangeTool.config.RomanConfigManager;
import com.thoughtworks.homework.currencyExchangeTool.module.request.MessageRequest;
import com.thoughtworks.homework.currencyExchangeTool.util.CommonUtil;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName RepeatedRule.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ3ÈÕ
 * @Description To validate Roman numeral can be repeated or not as per rules.
 */
public class RepeatedValidation extends BaseNumeralValidation {

	private Map<Character, Integer> countMap = new HashMap<Character, Integer>();
	private List<Character> repeatedList = new ArrayList<Character>();

	@Override
	public boolean validationModule(MessageRequest request) {
		String str = request.getRomanString();
		if (!checkRepeated(str) || !(checkCanBeMore(str))) {
			return false;
		} else if (this.getValidation() != null) {
			return this.getValidation().validationModule(request);
		}
		return true;
	}

	public boolean checkRepeated(String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			char c = str.charAt(i);
			if (repeatedList.contains(c)) {
				continue;
			}
			int count = 1;
			for (int j = i + 1; j < str.length(); j++) {
				char c1 = str.charAt(j);
				if (c == c1) {
					if (count == 1) {
						repeatedList.add(c);
					}
					++count;

				}
			}
			if (count > 1) {
				countMap.put(c, count);
			}
		}
		for (int i = 0; i < repeatedList.size(); i++) {
			char c = repeatedList.get(i);
			RomanNumeral roman = RomanConfigManager.getInstance()
					.getRomanNumeral(String.valueOf(c));
			if (!roman.isRepeated()) {
				return false;
			}
		}
		return true;
	}

	public boolean checkCanBeMore(String str) {
		for (int i = 0; i < repeatedList.size(); i++) {
			char c = repeatedList.get(i);
			int count = countMap.get(c);
			if (count > 4) {
				return false;
			} else if (count > 3) {
				int end = CommonUtil.getEndIndex(str, c);
				int begin = CommonUtil.getBeginIndex(str, c);
				if ((end - begin) > 4) {
					return false;
				}
				for (int j = end - 1; j >= begin; j--) {
					char c1 = str.charAt(j);
					if (c != c1) {
						RomanNumeral roman = RomanConfigManager.getInstance()
								.getRomanNumeral(String.valueOf(c));
						RomanNumeral roman1 = RomanConfigManager.getInstance()
								.getRomanNumeral(String.valueOf(c1));
						if (roman.getDecimalNumber() < roman1
								.getDecimalNumber()) {
							return false;
						}
					}

				}
			}
		}
		return true;
	}

}
