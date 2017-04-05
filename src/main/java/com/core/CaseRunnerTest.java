package com.core;

import org.junit.Assert;
import org.junit.Test;

public class CaseRunnerTest {
	

//	@Test
	public void testdemo(){
		String caseID = "testData.Sheet1.testpwd";
		String[] a = caseID.split("\\.");
		System.out.println(a.length);
		for(int i = 0 ; i< a.length ; i++){
			System.out.println(a[i]);
		}
	}
	
	
	@Test
	public void test() throws Exception {
		String caseID = "testData.Sheet1.testpwd";
		
		CaseRunner runner = new CaseRunner(caseID);
		String response = runner.run();
		
		System.out.println(response);
		Assert.assertEquals("so bad!",response, "Yes1");
	}

}
