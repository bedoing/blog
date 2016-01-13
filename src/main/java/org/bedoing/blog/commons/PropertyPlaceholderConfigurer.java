package org.bedoing.blog.commons;


public class PropertyPlaceholderConfigurer extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer  {

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
//		propertyValue = EndecryptUtil.get3DESDecrypt(propertyValue);
//		log.debug(propertyName + " = " + propertyValue);
		
		return super.convertProperty(propertyName, propertyValue);
	}
	
	/*public static void main(String[] args) {
		
	}*/
}
