package com.core;

import java.util.HashMap;
import java.util.Map;

import com.utilslib.ExcelReadHelper;

public class CaseReader {
	

	/*
	 * @sheetData 读取一整张表的数据
	 */
	public static Map<String, Map<String, String>> getCases(String fileName,String sheetName){
		Map<String, Map<String, String>> sheetData = new HashMap<String, Map<String,String>>();
		String filePath = System.getProperty("user.dir") + "\\data\\"+fileName+".xls";
		ExcelReadHelper excelReader = new ExcelReadHelper(filePath, sheetName);
		sheetData = excelReader.readSheet();
		return sheetData;
	}
}
