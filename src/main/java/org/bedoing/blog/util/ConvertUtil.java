package org.bedoing.blog.util;

import org.apache.commons.lang3.StringUtils;

public class ConvertUtil {
	public ConvertUtil(){}
	
	public static int convertSex(String sexStr){
		return "女".equals(sexStr)? 0:1;
	}
	
	public static String getLoginAccount(String openId){
		if(StringUtils.isNotBlank(openId)){
			if(!openId.startsWith("WX_")){
				openId = "WX_" + openId;
			}
		}
		
		return openId;
	}

}
