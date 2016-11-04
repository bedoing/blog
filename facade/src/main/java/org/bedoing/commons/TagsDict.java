package org.bedoing.commons;

import java.util.HashMap;
import java.util.Map;

public class TagsDict {

	private TagsDict(){}
	
	public static Map<Integer, String> tagsDict = new HashMap<Integer, String>();
	
	public static String getTagNameById(int tagId) {
		return tagsDict.get(tagId);
	}
	
	/**
	 * 
	 * @param tagName
	 * @return
	 * 	-1: 不存在字典
	 */
	public static int getTagIdByName(String tagName) {
		for (Map.Entry<Integer, String> m : tagsDict.entrySet()) {
			if(m.getValue().equals(tagName)) {
				return m.getKey();
			}
		}
		
		return -1;
	}
}
