package org.bedoing.blog.entity;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author ken
 *
 */
public class BaseEntity {

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
