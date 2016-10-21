package org.bedoing.blog.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {
	private static final Logger log = Logger.getLogger(PropertiesUtil.class);
	
	private PropertiesUtil() {
		
	}
	
	private static Map<String, Properties> fileProperties = new HashMap<String, Properties>();

	/*public static void main(String[] args) {
		Properties p = getPropertiesFile("company.properties");
		System.out.println(p.getProperty("companyNameChn"));
	}*/
	
	/**
	 * 获取properties文件
	 * 
	 * @param propertiesName
	 * @return
	 */
	public static Properties getPropertiesFile(String propertiesName) {
		if (fileProperties.containsKey(propertiesName)) {
			return fileProperties.get(propertiesName);
		}

		InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesName);
		if (null != inputStream) {
			try {
				Properties properties = new Properties();
				properties.load(inputStream);
				fileProperties.put(propertiesName, properties);
				return properties;
			} catch (IOException e) {
				log.error("can not load the name is'" + propertiesName + "' properties file,error:" + e.toString());
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}

		return null;
	}

	/**
	 * 不带默认值的返回
	 * 
	 * @param propertiesName
	 * @param keyName
	 * @return
	 */
	public static String getValue(String propertiesName, String keyName) {
		Properties properties = getPropertiesFile(propertiesName);
		if (null != properties) {
			return properties.getProperty(keyName);
		}
		return null;
	}

	/**
	 * 带默认值的返回
	 * 
	 * @param propertiesName
	 * @param keyName
	 * @param defaultValue
	 * @return
	 */
	public static String getValueWithDefault(String propertiesName, String keyName, String defaultValue) {
		Properties properties = getPropertiesFile(propertiesName);
		if (null != properties) {
			return properties.getProperty(keyName, defaultValue);
		}
		return null;
	}
}
