package org.bedoing.blog.entity;

import lombok.Data;

/**
 * 
 * @author ken
 *
 */
@Data
public class Clicks extends BaseEntity {
	
	private int articleId;
	private int clicks;
}
