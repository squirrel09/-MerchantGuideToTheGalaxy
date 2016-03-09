package com.thoughtworks.homework.currencyExchangeTool.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.thoughtworks.homework.currencyExchangeTool.VO.CreditNumeral;
import com.thoughtworks.homework.currencyExchangeTool.VO.GalacticNumeral;
import com.thoughtworks.homework.currencyExchangeTool.strategy.RomanCalculateStrategy;
import com.thoughtworks.homework.currencyExchangeTool.util.CommonUtil;
import com.thoughtworks.homework.currencyExchangeTool.util.Constants;

/**
 * 
 * Copy Right 2016 currencyExchangeTool
 * 
 * @FileName GalacticConfigManager.java
 * @author Xie Di
 * @Date 2016Äê3ÔÂ3ÈÕ
 * @Description To read galactic numeral data from txt file and transform to
 *              object.
 */
public class GalacticConfigManager extends GenericConfigManager {

	private static GalacticConfigManager config;
	private Map<String, GalacticNumeral> map = new HashMap<String, GalacticNumeral>();
	private List<CreditNumeral> creditList = new ArrayList<CreditNumeral>();
	private Map<String, Double> creditMap = new HashMap<String, Double>();

	private GalacticConfigManager() {
	}

	public static GalacticConfigManager getInstance() {
		if (config == null) {
			config = new GalacticConfigManager();
		}
		return config;
	}

	public void readFile() {
		File file = new File(Constants.GALACTIC_FILE_PATH);
		FileInputStream fis = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(fis));
			String line = null;
			while ((line = (br.readLine())) != null) {
				paraseGalacticString(line);
				// System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * @Description To parse galactic string, there are 2 types: 1. Galactic
	 *              numeral 2. Credit numeral
	 */
	public void paraseGalacticString(String str) {
		GalacticNumeral galactic = new GalacticNumeral();
		if (!str.contains("Credits")) {
			String[] tempStr = str.split(" ");
			galactic.setGalactic(tempStr[0]);
			galactic.setRoman(tempStr[tempStr.length - 1]);
			map.put(tempStr[0], galactic);
		} else {
			String[] types = Constants.GALACTIC_CREDIT_TYPE;
			CreditNumeral credit = new CreditNumeral();
			for (int i = 0; i < types.length; i++) {
				if (str.contains(types[i])) {
					String[] galacticStr = str.split(types[i]);
					String[] texts = galacticStr[0].split(" ");
					for (int j = 0; j < texts.length; j++) {
						if (texts[j] != "") {
							credit.getList().add(texts[j]);
						}
					}
					credit.setType(types[i]);
					int index = galacticStr[1].indexOf(" ", 2);
					String tempStr = galacticStr[1].substring(index + 1);
					int end = tempStr.indexOf(" ");
					credit.setCredit(Double.parseDouble(tempStr.substring(0,
							end)));
					creditList.add(credit);
				}
			}
			processCredit();
		}
	}

	public void processCredit() {
		Iterator<CreditNumeral> it = getCreditList().iterator();
		while (it.hasNext()) {
			CreditNumeral credit = it.next();
			List<String> list = credit.getList();
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				String str = list.get(i);
				GalacticNumeral galactic = map.get(str);
				buffer.append(galactic.getRoman());
			}
			RomanCalculateStrategy calculate = new RomanCalculateStrategy();
			double result = calculate.calculate(buffer.toString());
			double unit = CommonUtil.divisionCalculate(result,
					credit.getCredit());
			creditMap.put(credit.getType(), unit);
		}
	}

	public Map<String, GalacticNumeral> getMap() {
		return map;
	}

	public List<CreditNumeral> getCreditList() {
		return creditList;
	}

	public GalacticNumeral getGalacticNumeral(String key) {
		return map.get(key);
	}

	public Map<String, Double> getCreditMap() {
		return creditMap;
	}

	public double getCreditUnit(String key) {
		return creditMap.get(key);
	}

}
