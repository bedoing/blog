package org.bedoing.blog.commons;

import java.util.HashMap;
import java.util.Map;

public class DictParam {

	private DictParam(){}
	
	private static Map<String, Object> dictMap = new HashMap<String, Object>();
	
	public static String getSexStr(int key) {
		return (String) dictMap.get(SEX + key);
	}

	public static String getRole(int key) {
		return (String) dictMap.get(ROLE + key);
	}
	
	public static String getUserStatus(int key) {
		return (String) dictMap.get(USER_STATUS + key);
	}
	
	public static String getDateFormat(int key) {
		return (String) dictMap.get(DATE_FORMAT + key);
	}
	
	public static final String SEX = "SEX";
	public static final String ROLE = "ROLE";
	public static final String USER_STATUS = "USER_STATUS";
	public static final String DATE_FORMAT = "DATE_FORMAT";
	
	public static void put(String key, String value) {
		dictMap.put(key, value);
	}
}
