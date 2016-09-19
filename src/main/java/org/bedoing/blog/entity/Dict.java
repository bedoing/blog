package org.bedoing.blog.entity;

import lombok.Data;

/**
 * 
 * @author Ken
 *
 */
@Data
public class Dict extends BaseEntity {

	private int dictId;
	private String dictType;
	private String dictCode;
	private int dictKey;
	private String dictValue;
}
