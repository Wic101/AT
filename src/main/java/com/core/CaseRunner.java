package com.core;

import java.util.Map;

import com.utilslib.HttpClientHelper;

public class CaseRunner {
	
	String caseID = null;
	public CaseRunner(String caseID){
		this.caseID = caseID;
	}
	
	public String getCaseID(){
		return caseID;
	}
	
	/*
	 * 根据caseID,获取一行数据
	 */
	public Map<String, String> getsingleData(){
		String caseID = this.caseID;
		
		String fileName = caseID.split("\\.")[0];
		String sheetName = caseID.split("\\.")[1];
		String caseName = caseID.split("\\.")[2];
		
		Map<String,String> singleData = CaseReader.getCases(fileName,sheetName).get(caseName);
		return singleData;
	}
	
	
	public String run() throws Exception{
		SetUpParameters set = new SetUpParameters(getsingleData());
		String response = HttpClientHelper.getResponse(set.getUrl(), set.getParameters(), set.getMethodType());
		return response;
	}

}
