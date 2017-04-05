package com.utilslib;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

public class ExcelReadHelperTest {
	
	@Test
	public void TestGetDataFromSheet(){
		String filePath = System.getProperty("user.dir") + "\\data\\testData.xls";
		String sheetName = "Sheet1";
		ExcelReadHelper eReader = new ExcelReadHelper(filePath,sheetName);
		Map<String, Map<String, String>> map = eReader.readSheet();
		
		for(String key : map.keySet()){
			System.out.println("***"+key);
			Map<String, String> map2 = map.get(key);
			for(String key2: map2.keySet()){
				System.out.println(key2 + ":" + map2.get(key2));
			}
		}
	}

}
