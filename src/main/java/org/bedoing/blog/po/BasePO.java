package org.bedoing.blog.po;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author ken
 *
 */
public class BasePO {

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
