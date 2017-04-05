package com.core;

import java.util.HashMap;
import java.util.Map;

public class SetUpParameters {
	
	Map<String, String> map =new HashMap<String, String>();
	
	public SetUpParameters(Map<String,String> map){
		this.map = map;
	}
	
	/*
	 * @url 从参数列中抽取url
	 * header 名为：url
	 */
	public String getUrl(){
		Map<String, String> map = this.map;
		if(map.isEmpty()){
			System.out.println("Map is empty!");
			System.exit(0);
		}
		
		if(map.containsKey("url")){
			System.out.println("url字段缺失");
			System.exit(0);
		}
		
		return map.get("url").trim();
	}
	
	/*
	 * @methodTye 从参数列中抽取请求方式，get&post
	 * header 名为：isGet
	 */
	public Boolean getMethodType(){
		Map<String, String> map = this.map;
		if(map.isEmpty()){
			System.out.println("Map is empty!");
			System.exit(0);
		}
		
		if(!map.containsKey("isGet")){
			System.out.println("isGet字段缺失");
			System.exit(0);
		}
		
		Boolean methodType = null;
		if(map.get("isGet").equals("0") || map.get("isGet").equals("false")){
			methodType = false;
		}else if(map.get("isGet").equals("1") || map.get("isGet").equals("true")){
			methodType =  true;
		}
		return methodType;
		
	}

	/*
	 * @parameters 从参数列中抽取去请求参数
	 * 凡是header名，以$符号开始的列，为请求所需的参数列
	 */
	public Map<String, String> getParameters(){
		Map<String, String> map = this.map;
		Map<String,String> result = new HashMap<String, String>();
		for(String key:map.keySet()){
			if(key.startsWith("$")){
				result.put(key.substring(1, key.length()), map.get(key));
			}
		}
		
		return result;
	}
}
