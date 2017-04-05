package com.utilslib;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;

public class HttpClientHelper {
	
	public static String getResponse(String url, Map<String,String> parameters, Boolean isGet) throws Exception{
		String resultString="";
		   if(isGet)
		   {
			   resultString=getResponseText(getMethod(url));
		   }
		   else
		   {
			   resultString=getResponseText(postMethod(url));
		   }
		   return resultString;
	}
	
	private static CloseableHttpResponse getMethod(String url){
		
		return null;
	}
	private static CloseableHttpResponse postMethod(String url){
		return null;
	}
	
	
	private static String getResponseText(CloseableHttpResponse response) throws Exception
	   {
		return null;
	   }

}
