package org.bedoing.blog.entity;

import lombok.Data;

/**
 * 
 * @author ken
 *
 */
@Data
public class Tag extends BaseEntity {

	private int tagId;
	private String tagName;
	private int tagType;
}
