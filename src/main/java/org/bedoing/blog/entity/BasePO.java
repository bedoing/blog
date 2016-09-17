package org.bedoing.blog.entity;

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
