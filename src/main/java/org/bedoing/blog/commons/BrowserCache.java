package org.bedoing.blog.commons;

import org.apache.log4j.Logger;
import org.bedoing.blog.util.PropertiesUtil;

public class BrowserCache {
	private static Logger log = Logger.getLogger(BrowserCache.class);
	private static String PROPERTY_NAME = "system.properties";
	
	private BrowserCache(){
		
	}
	
	public static String getTimestamp(String key){
		String value = PropertiesUtil.getValue(PROPERTY_NAME, "timeStr");
		log.info("BrowserCache.getTimestamp, timeStr = " + value);
		
		if(value == null || value.trim() == ""){
			return "20160219155600";
		} else {
			return value;
		}
	}
}
