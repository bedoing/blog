package org.bedoing.blog.commons;

import org.bedoing.blog.security.EndecryptUtil;


public class PropertyPlaceholderConfigurer extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer  {

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		propertyValue = EndecryptUtil.decrypt(propertyValue);
		
		return super.convertProperty(propertyName, propertyValue);
	}
	
}
