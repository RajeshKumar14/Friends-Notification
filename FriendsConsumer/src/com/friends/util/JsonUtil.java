package com.friends.util;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	/**
	 * This code is used to
	 * convert object to json string
	 * input is any object and
	 * output is json String
	 * 
	 */
	
	public static String convertObjToJson(Object ob){
		String json=null;
		try {
			
			ObjectMapper om=new ObjectMapper();
			json=om.writeValueAsString(ob);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
	   }
	
	/**
	 * This Method is used to convert given json string
	 * to given class type object
	 * it uses JACKSON conversion  
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static  Object convertJsonToObj(String json,Class cls){
		Object ob=null;
		try {
			ObjectMapper om=new ObjectMapper();
			 ob=om.readValue(json, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	  }
	
}
