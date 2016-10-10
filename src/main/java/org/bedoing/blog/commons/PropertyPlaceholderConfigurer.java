package org.bedoing.blog.commons;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

public class PropertyPlaceholderConfigurer extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer  {

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        System.out.println(propertyName + " ******************** " + propertyValue);
//		propertyValue = EndecryptUtil.decrypt(propertyValue);
//		System.out.println(propertyValue);

        return super.convertProperty(propertyName, propertyValue);
    }

}
